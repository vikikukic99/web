package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Location;
import beans.Role;
import beans.User;
import beans.WebContext;
import dao.LocationDAO;
import dao.RestourantDAO;
import dao.UserDAO;

public class AddNewRestaurantServlet extends HttpServlet{

	private static final long serialVersionUID=313l;
	
	public AddNewRestaurantServlet() {
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
		ArrayList<User> managers = userDAO.getFreeManagers();
		
		
		request.setAttribute("managers", managers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/addNewRestaurant.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
		if(user == null)
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/login.jsp");
			requestDispatcher.forward(request,response);
			return;
	    }
		
		if(!user.getRole().equals(Role.Administrator))
		{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
			requestDispatcher.forward(request,response);
			return;
	    }
		
		String name = (String)request.getParameter("name");
		String restaurantType = (String)request.getParameter("restaurantType");
		String geographicalLength = (String)request.getParameter("geographicalLength");
		String geographicalWidth = (String)request.getParameter("geographicalWidth");
		String address = (String)request.getParameter("address");
		String restaurantLogo = (String)request.getParameter("restaurantLogo");
		String userID = (String)request.getParameter("managerId");
		
		
		UserDAO userDAO = new UserDAO();
		User manager = userDAO.findByID(userID);
		
		LocationDAO locationDAO = new LocationDAO();
		Location location = locationDAO.addLocation(geographicalWidth, geographicalLength, address);
		
		RestourantDAO restourantDAO = new RestourantDAO();
		
		restourantDAO.addRestaurant(name, restaurantType, location, manager, restaurantLogo);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
	
}
