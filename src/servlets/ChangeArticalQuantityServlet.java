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
import beans.Role;
import beans.Type;
import beans.User;
import beans.WebContext;
import dao.ArticalDAO;
import dao.CartDAO;

public class ChangeArticalQuantityServlet extends HttpServlet {
	
private static final long serialVersionUID=313l;
	
	public ChangeArticalQuantityServlet()
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
			
			String id = (String)request.getAttribute("id");
			CartDAO cartDAO = new CartDAO();
			Cart cart = cartDAO.findByID(id);
			
			ArrayList<CartItem> cartItems = cart.getCartItems();
			
			request.setAttribute("cartItems", cartItems);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/chart.jsp");
			dispatcher.forward(request, response);
		}
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		 Cart cart = (Cart)request.getSession().getAttribute("cart");
		 String quantity = (String)request.getAttribute("quantity");
		 String id = (String)request.getAttribute("id");
		 
		 double quantity1 = Double.parseDouble(quantity);
		 double price = 0;
		 
		 if(quantity1 < 1)
		 {
			 request.setAttribute("error", "Quantity can't be less than 1!");
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/ChangeArticalQuantityServlet");
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
					 price += cartItem1.getArtical().getPrice() * quantity1;
				 }
			 }
		 }
		 
		 cart.setPrice(price);
		 
		 request.getSession().setAttribute("cart", cart);
		 request.setAttribute("id", cart.getCartID());
		 
		
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ChangeArticalQuantityServlet");
			requestDispatcher.forward(request, response);
			return;
		}
		

}
