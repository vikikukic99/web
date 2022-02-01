package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Restaurant;
import beans.Role;
import beans.User;
import beans.WebContext;
import dao.RestourantDAO;
import dao.UserDAO;

public class AdministratorOverviewUsersServlet extends HttpServlet {

private static final long serialVersionUID = 2L;
	
	public AdministratorOverviewUsersServlet() {
		super();
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		 ArrayList<User> users = userDAO.getAllUsers();
		 
		 request.setAttribute("users", users);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/administratorOverviewUsers.jsp");
		dispatcher.forward(request, response);
	}
	
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 User user = (User)request.getSession().getAttribute("user");
			
			if(user == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/login.jsp");
				dispatcher.forward(request, response);
		    	return;
			}
			
			
			if(!user.getRole().equals(Role.Administrator)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request, response);
		    	return;
			}
			
			 String sort = (String)request.getParameter("sort");
			 String fitleringByRole = (String)request.getParameter("role");
			 String filteringByBuyerType = (String)request.getParameter("typeOfBuyer");
			 
			 String search = (String)request.getParameter("search");
			 UserDAO userDAO = new UserDAO();
			 ArrayList<User> users = userDAO.searchAllUsers(search, fitleringByRole, filteringByBuyerType);
			 
			 if(sort != null) {
				 if(sort.equals("FirstName")) {
					 users = userDAO.sortByFirstName(users);
				 }else if(sort.equals("LastName")) {
					 users = userDAO.sortByLastName(users);
				 }else if(sort.equals("UserName")) {
					 users = userDAO.sortByUserName(users);
				 }else if(sort.equals("PointsCollected")) {
					 users = userDAO.sortByPointsCollected(users);
				 }
			 }
		 
		
		 
		 request.setAttribute("users", users);
		 
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/administratorOverviewUsers.jsp");
		 dispatcher.forward(request, response);
			
		
			
	 }
	

	
}
