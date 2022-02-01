package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
import dao.ArticalDAO;
import dao.CartDAO;

public class ShowChartServlet extends HttpServlet {
	
	private static final long serialVersionUID=313l;
	
	public ShowChartServlet()
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
	     
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		
		if(cart == null)
		{
			cart = new Cart();
		}
		
		ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
		
		cartItems = cart.getCartItems();
		
		request.setAttribute("cartItems", cartItems);
		request.setAttribute("cart", cart);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showChart.jsp");
		dispatcher.forward(request, response);
		return;
	}
	
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  User user = (User)request.getSession().getAttribute("user");
		  Cart cart = (Cart)request.getSession().getAttribute("cart");
		  String quantity = (String)request.getParameter("quantity");
		  String id = (String)request.getParameter("cartItemID");
		  
		  double quantity1 = Double.parseDouble(quantity);
		  double price = 0;
		  
		  if(quantity1 < 1)
		  {
			request.setAttribute("error", "Quantity can't be less than 1!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WebShop/ShowChartServlet");
			dispatcher.forward(request, response);
			return;
		  }
		  
		  for(CartItem cartItem : cart.getCartItems())
		  {
			if(cartItem.getCartItemID().equals(id))
			{
				cartItem.setQuantity(quantity);
				for(CartItem cartItem1 : cart.getCartItems())
				{
					price += cartItem1.getArtical().getPrice()*quantity1;
				}
			}
		  }
		  
		  if(user.getTypeOfCostumer().getNameType().equals("Silver")) {
				price = price - 3*price/100;
			}
			
			if(user.getTypeOfCostumer().getNameType().equals("Golden")) {
				price = price - 6*price/100;
			}
		  
		  cart.setPrice(price);
	  
	      request.getSession().setAttribute("cart", cart);
	      request.setAttribute("cartID", cart.getCartID());
		  request.setAttribute("cart", cart);
		  request.setAttribute("cartItems", cart.getCartItems());

		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showChart.jsp");
			dispatcher.forward(request, response);
			return;
		}

}
