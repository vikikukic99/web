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
import beans.Role;
import beans.Type;
import beans.User;
import beans.WebContext;
import dao.ArticalDAO;
import dao.LocationDAO;
import dao.RestourantDAO;
import dao.UserDAO;

public class ChangeArticalServlet extends HttpServlet {
	
	private static final long serialVersionUID=313l;
	Artical oldArtical = new Artical();
	
	public ChangeArticalServlet()
	{
		super();
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String)request.getParameter("articalID");
		ArticalDAO articalDAO = new ArticalDAO();
		oldArtical = articalDAO.findByID(id);
		
		request.setAttribute("artical", oldArtical);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/changeArtical.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
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
		
		
		
		
		String articalName = (String)request.getParameter("articalName");
		String price = (String)request.getParameter("price");
		String typeString = (String)request.getParameter("type");
		String articalImage = (String)request.getParameter("articalImage");
		String description = (String)request.getParameter("description");
		String quantity = (String)request.getParameter("quantity");
		
		Type type = Type.drink;
		
		if(typeString.equals("meal")) {
			type = Type.meal; 
		}
		
		
		Double priceDouble = Double.parseDouble(price);
		Double quantityDouble = Double.parseDouble(quantity);
		
		//articalDAO.changeArtical(id,articalName, priceDouble, type, articalImage, description, quantityDouble);
		
		
		
		Artical artical = new Artical(oldArtical.getArticalID(), articalName, priceDouble, type, oldArtical.getRestaurant()  , quantityDouble, description, articalImage);
		
		WebContext.getInstance().getArticals().remove(oldArtical);
		WebContext.getInstance().getArticals().add(artical);
		WebContext.getInstance().save();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
	}
	

}
