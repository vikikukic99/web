package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplicationContext;
import beans.Gender;
import beans.Restaurant;
import beans.Role;
import dao.RestaurantDAO;
import dao.UserDAO;

public class ViewRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ViewRestaurantsServlet()
	{
		super();
	}
	
	 public void init() throws ServletException { 
	    	super.init();
	    	ServletContext context = getServletContext();
	    	String contextPath = context.getRealPath("");
	    	
			ApplicationContext.getInstane().setContextPath(contextPath);
	    }

	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	ArrayList<Restaurant> restaurants = ApplicationContext.getInstane().getRestaurants();
    	ArrayList<Restaurant> sortRestaurant = new ArrayList<Restaurant>();
    	
    	for(Restaurant restaurant : restaurants)
    	{
    		if(restaurant.getStatus().toString().equals("Open"))
    		{
    			sortRestaurant.add(restaurant);
    		}
    	}
    	
    	for(Restaurant restaurant : restaurants)
    	{
    		if(restaurant.getStatus().toString().equals("Close"))
    		{
    			sortRestaurant.add(restaurant);
    		}
    	}
    	
    	request.setAttribute("restaurants", sortRestaurant);
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/viewRestaurants.jsp");
    	disp.forward(request, response);
    }
    
	    	
    

}
