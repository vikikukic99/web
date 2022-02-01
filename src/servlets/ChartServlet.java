package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Artical;
import beans.Cart;
import beans.CartItem;
import beans.User;
import beans.WebContext;
import dao.CartDAO;
import dao.CartItemDAO;

public class ChartServlet extends HttpServlet {
	
	private static final long serialVersionUID=313l;
	
	public ChartServlet()
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/chart.jsp");
		dispatcher.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
          String quantity = (String)request.getAttribute("quantity");
          Artical artical = (Artical)request.getAttribute("artical");
          Cart cart = (Cart)request.getSession().getAttribute("cart");
          User costumer = (User)request.getSession().getAttribute("user");
          
          if(cart == null)
          {
        	  CartDAO cartDAO = new CartDAO();
        	  cart = new Cart(cartDAO.generateID(), costumer);
          }
          
          CartItemDAO cartItemDAO = new CartItemDAO();
          CartItem cartItem = new CartItem(cartItemDAO.generateID(),cart,artical,quantity);
          
          cart.getCartItems().add(cartItem);
          
          double price = 0;
          double quantity1 = Double.parseDouble(quantity);
          
          
          for(CartItem cartItemm : cart.getCartItems())
          {
        	  price += cartItemm.getArtical().getPrice()*quantity1;
          }
          
          cart.setPrice(price);
          
          request.getSession().setAttribute("cart",cart);
          request.setAttribute("id", artical.getRestaurant().getRestaurantID());
          

		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
		requestDispatcher.forward(request, response);
		return;
	}

}
