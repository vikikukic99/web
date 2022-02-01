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

import beans.Artical;
import beans.Location;
import beans.Restaurant;
import beans.Role;
import beans.Type;
import beans.User;
import beans.WebContext;
import dao.ArticalDAO;
import dao.LocationDAO;
import dao.RestourantDAO;
import dao.UserDAO;

public class AddNewArticalServlet extends HttpServlet{

	private static final long serialVersionUID=313l;
	
	public AddNewArticalServlet() {
		super();
		
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idRestaurant = (String)request.getParameter("restaurantID"); 
		RestourantDAO restourantDAO = new RestourantDAO();
		
		Restaurant restaurant = restourantDAO.findByID(idRestaurant);
		
		
		request.setAttribute("restaurant",restaurant);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/addNewArtical.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
		String restaurantID = (String)request.getParameter("restaurantID");
		
		RestourantDAO restourantDAO = new RestourantDAO();
		Restaurant restaurant = restourantDAO.findByID(restaurantID);
		
		if(user == null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/login.jsp");
			rd.forward(request,response);
			return;
	    }
		
		if(!user.getRole().equals(Role.Manager))
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request,response);
			return;
	    }
		
		String articalName = (String)request.getParameter("articalname");
		double price =  Double.parseDouble((String)request.getParameter("price"));
		String typeString = (String)request.getParameter("type");
		String articalImage = (String)request.getParameter("articalImage");
		String description = (String)request.getParameter("description");
		double quantity = Double.parseDouble((String)request.getParameter("quantity"));
		
		Type type = Type.drink;
		
		if(typeString.equals("meal")) {
			type = Type.meal;
		}
		
		for(Artical artical: WebContext.getInstance().getArticals()) {
			if(artical.getArticalName().equals(articalName)) {
				request.setAttribute("error", "Already exists artical with that name!");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/AddNewArticalServlet");
				 dispatcher.forward(request, response);
				 return;
			}
		}
		
		ArticalDAO articalDAO = new ArticalDAO();
		
		articalDAO.addArtical(articalName, price, type, articalImage, description, quantity, restaurant);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
	
}