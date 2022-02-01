package servlets;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.TypeOfCostumer;
import beans.WebContext;
import dao.UserDAO;

public class RegServlet extends HttpServlet{
		
	private static final long serialVersionUID=2l;
	
	public RegServlet() {
		super();
	}
	
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/registration.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		String firstName = (String)request.getParameter("firstName");
		String lastName = (String)request.getParameter("lastName");
		String gender = (String)request.getParameter("gender");
		String date = (String)request.getParameter("date");
		UserDAO userDAO = new UserDAO();
		
		try {
			userDAO.addNewUser(username, password, firstName, lastName, gender, date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/login.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
	
}
