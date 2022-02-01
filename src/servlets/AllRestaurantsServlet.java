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

public class AllRestaurantsServlet extends HttpServlet {

private static final long serialVersionUID = 2L;
	
	public AllRestaurantsServlet() {
		super();
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Restaurant> restaurants = WebContext.getInstance().getRestaurants();
		ArrayList<Restaurant> opendRestaurants = new ArrayList<Restaurant>();
		
		for(Restaurant restaurant : restaurants)
		{
			if(restaurant.getRestaurantStatus().toString().equals("working")) {
				opendRestaurants.add(restaurant);
			}
		}
		for(Restaurant restaurant : restaurants)
		{
			if(restaurant.getRestaurantStatus().toString().equals("not_working")) {
				opendRestaurants.add(restaurant);
			}
		}
		
		request.setAttribute("restaurants", opendRestaurants);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/allRestaurants.jsp");
		dispatcher.forward(request, response);
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 Restaurant restaurant = (Restaurant)request.getSession().getAttribute("restaurant");
			
		 String sort = (String)request.getParameter("sort");
		 String search = (String)request.getParameter("search");
		 String typeOfRestaurant = (String)request.getParameter("typeOfRestaurant");
		 String restaurantStatus = (String)request.getParameter("restaurantStatus");
		 
		 RestourantDAO restourantDAO = new RestourantDAO();
		 ArrayList<Restaurant> restaurants = restourantDAO.searchAllRestourants(search, typeOfRestaurant, restaurantStatus);
		 
		 if(sort != null) {
			 if(sort.equals("Name")) {
				 restaurants = restourantDAO.sortByName(restaurants);
			 }else if(sort.equals("Location")) {
				 restaurants = restourantDAO.sortByLocation(restaurants);
			 }	 
		 }
		 
		 
		 
		 request.setAttribute("restaurants", restourantDAO.searchAllRestourants(search,typeOfRestaurant, restaurantStatus));
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/allRestaurants.jsp");
		 dispatcher.forward(request, response);
		 
 }
	 
	 
}