package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplicationContext;
import beans.Artical;
import beans.ArticalType;
import beans.Gender;
import beans.Location;
import beans.Restaurant;
import beans.Role;
import beans.User;
import dao.ArticalDAO;
import dao.RestaurantDAO;
import dao.UserDAO;

public class AddNewArticalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public AddNewArticalServlet()
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
    	String restourantID = (String)request.getParameter("restaurantID");
    	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
		
		Restaurant restaurant = restaurantDAO.findById(restourantID);
		
    	request.setAttribute("restourantID", restourantID);
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/addNewArtical.jsp");
    	disp.forward(request, response);
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
   
    	User user = (User)request.getSession().getAttribute("user");
    	
    	String restaurantId = (String)request.getParameter("restaurantId");
    	
    	RestaurantDAO restaurantDAO = new RestaurantDAO();
    	Restaurant restaurant = restaurantDAO.findById(restaurantId);
    	
    	if(user == null)
    	{
    		RequestDispatcher disp = request.getRequestDispatcher("/JSP/login.jsp");
    		disp.forward(request, response);
    		return;
    	}
    	if(!user.getRole().equals(Role.menager))
    	{
    		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
    		rd.forward(request, response);
    		return;
    	}
    	
      	String articalName = (String)request.getParameter("articalName");
    	String price = (String)request.getParameter("price");
		Double articalPrice = Double.parseDouble(price);
		
    	String articalTypeString = (String)request.getParameter("articalType");
    	ArticalType articalType;
    	
		if(articalTypeString.equals("Drink"))
		{
			articalType = ArticalType.Drink;
		}
		else
		{
			articalType = ArticalType.Food;
		}
		
    	String quantity = (String)request.getParameter("quantity");
    	String description = (String)request.getParameter("description");
    	String picture = (String)request.getParameter("picture");
    	
    	for(Artical artical: ApplicationContext.getInstane().getArticals()) {
			if(artical.getArticalName().equals(articalName)) {
				request.setAttribute("error", "Already exists artical with that name!");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/AddNewArticalServlet");
				 dispatcher.forward(request, response);
				 return;
			}
		}
			
    	ArticalDAO articalDAO = new ArticalDAO();
		articalDAO.addArtical( articalName, price, articalType, quantity, description, picture, restaurant);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
				 	
    }

}

