package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Restaurant;
import beans.User;
import beans.WebContext;
import dao.RestourantDAO;

public class rateRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rateRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
   	String contextPath = context.getRealPath("");
   	
   	WebContext.getInstance().setContextPath(contextPath);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Restaurant restaurant = (Restaurant)request.getSession().getAttribute("restaurant");
		String id = restaurant.getRestaurantID();
		
		 request.setAttribute("restaurantID", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/rateRestaurant.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
