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
import dao.CartItemDAO;

public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateOrderServlet()
	{
		super();
	}
	
    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
    	String contextPath = context.getRealPath("");
   	
    	WebContext.getInstance().setContextPath(contextPath);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/viewArtical.jsp");
		disp.forward(request, response);
	}
	
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   User user = (User)request.getSession().getAttribute("user");
		String quantity = (String)request.getParameter("quantity");
		String id = (String)request.getParameter("articalID");
		ArticalDAO articalDAO = new ArticalDAO();
		Artical artical = articalDAO.findByID(id);
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		User buyer = (User)request.getSession().getAttribute("user");

		if(cart == null) {
			CartDAO cartDAO = new CartDAO();
			cart = new Cart(cartDAO.generateID(),buyer,artical.getRestaurant());
		}
		
		CartItemDAO cartItemDAO = new CartItemDAO();
		CartItem cartItem = new CartItem(cartItemDAO.generateID(), cart, artical, quantity);			
		
		cart.getCartItems().add(cartItem);
		
		double price=0;
		double quantityDouble = Double.parseDouble(quantity);
		for(CartItem cartItem2 : cart.getCartItems()) {
			price += cartItem2.getArtical().getPrice() * quantityDouble ;
		}
		
		cart.setPrice(price);
		request.getSession().setAttribute("cart", cart);
		request.setAttribute("cartID", cart.getCartID());
		request.setAttribute("restaurant", artical.getRestaurant());
		request.setAttribute("user", user);
		ArrayList<Artical> articals = new ArrayList<Artical>();
		
		articals=articalDAO.getArticalsForRestorants(cart.getRestaurant().getRestaurantID());
		
		
		request.setAttribute("articals", articals);
	//	response.sendRedirect("/WebShop/RestaurantViewServlet");
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/restaurantView.jsp");
		disp.forward(request, response);
		return;
	}
	
}
