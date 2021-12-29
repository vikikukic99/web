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
import beans.Location;
import beans.Role;
import beans.Status;
import beans.User;
import dao.RestaurantDAO;
import dao.UserDAO;

public class AddRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public AddRestaurantServlet()
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
    	UserDAO userDAO =  new UserDAO();
    	
    	ArrayList<User> users = userDAO.getMenagers();
    	
    	request.setAttribute("managers", users);
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/addRestaurant.jsp");
    	disp.forward(request, response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String restaurantName = (String)request.getParameter("restaurantName");
    	String restaurantType = (String)request.getParameter("restaurantType");
    	String menagerId = (String)request.getParameter("menagerId");
    	
    	UserDAO userDAO = new UserDAO();
    	User menager = userDAO.findById(menagerId);

    	String statusString = (String)request.getParameter("status");
    	Status status;
		
		if(statusString.equals("Open")) {
			status = Status.Open;
		}
		else
		{
			status = Status.Close;
		}
    	
		String logoOfRestaurant = (String)request.getParameter("logoOfRestaurant");
		
		
		Location location = new Location();
		
		String adress = (String)request.getParameter("adress");
		location.setAddress(adress);
		

		Double geograficalLenght = Double.parseDouble(request.getParameter("geograficalLenght")) ;
		location.setGeograficalLenght(geograficalLenght);
		

		Double geograficalWidth = Double.parseDouble(request.getParameter("geograficalWidth"));
		location.setGeograficalWidth(geograficalWidth);
		
		RestaurantDAO restaurantDAO = new RestaurantDAO();
		restaurantDAO.saveRestaurant(restaurantName, restaurantType,  status,logoOfRestaurant, menager, location  );
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/addRestaurant.jsp");
    	disp.forward(request, response);
				 	
    }

}
