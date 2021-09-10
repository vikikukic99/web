package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplicationContext;
import beans.Artical;
import beans.Location;
import beans.Restaurant;
import beans.Status;
import dao.ArticalDAO;
import dao.RestaurantDAO;

public class ViewRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ViewRestaurantServlet()
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
    	String restaurantId = (String)request.getParameter("restaurantId");

    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	Restaurant restaurant = restaurantDAO.findById(restaurantId);
    	
    	// naci sve artikle od restorana i proslediti
    	
    	ArticalDAO articalDAO = new ArticalDAO();
    	request.setAttribute("articals", articalDAO.getAllForRestoaurant(restaurantId));
    	request.setAttribute("restaurant", restaurant);
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/viewRestaurant.jsp");
    	disp.forward(request, response);
    }
    
	    	
    


}
