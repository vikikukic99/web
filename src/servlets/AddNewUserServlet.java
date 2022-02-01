package servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Role;
import beans.User;
import beans.WebContext;
import dao.UserDAO;

public class AddNewUserServlet extends HttpServlet{

	private static final long serialVersionUID = 2L;
	
	public AddNewUserServlet() {
		super();
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/addNewUser.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/login.jsp");
			rd.forward(request,response);
			return;
	    }
		
		
		if(!user.getRole().equals(Role.Administrator))
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request,response);
			return;
	    }
		
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String firstName = (String)request.getParameter("firstName");
		String lastName = (String)request.getParameter("lastName");
		String gender = (String)request.getParameter("gender");
		String date = (String)request.getParameter("date");
		String roleString = (String)request.getParameter("role");
	
		UserDAO userDAO = new UserDAO();
		
		try {
			userDAO.addNewManagerOrDeliveryGuy(username, password, firstName, lastName, gender, date,roleString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
}
