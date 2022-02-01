package servlets;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import beans.WebContext;
import dao.UserDAO;

/**
 * Servlet implementation class SeeYourProfileServlet
 */
	public class SeeYourProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeeYourProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/seeYourProfile.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String firstName = (String)request.getParameter("firstName");
		String lastName = (String)request.getParameter("lastName");
		String gender = (String)request.getParameter("gender");
		String date = (String)request.getParameter("date");
		UserDAO userDAO = new UserDAO();
		
		DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOfBirth = null;
		
		try {
			dateOfBirth=(Date)dateFormater.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		User newUser = new User(user.getUserID(),username,password,firstName,lastName,user.getGender(),dateOfBirth,user.getRole(),user.getPointsCollected(), user.getTypeOfCostumer());
	
		WebContext.getInstance().getUsers().remove(user);
		WebContext.getInstance().getUsers().add(newUser);
		WebContext.getInstance().save();
		
		request.getSession().setAttribute("user", newUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
