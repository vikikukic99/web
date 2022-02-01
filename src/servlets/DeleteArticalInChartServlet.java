package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import beans.CartItem;
import beans.WebContext;

public class DeleteArticalInChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public DeleteArticalInChartServlet()
	{
		super();
	}
	
	@Override
	public void init() throws ServletException
	{
		super.init();
		ServletContext con = getServletContext();
		String contextPath = con.getRealPath("");
		
		WebContext.getInstance().setContextPath(contextPath);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showChart.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String)request.getParameter("articalID");
		String quantity = (String)request.getParameter("quantity");
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		
		double price = 0;
		CartItem forDelete = null;
		
		for(CartItem cartItem: cart.getCartItems())
		{
			if(cartItem.getArtical().getArticalID().equals(id))
			{
				forDelete = cartItem;
			}
		}
		
			if(forDelete != null)
			{
				cart.getCartItems().remove(forDelete);
				for(CartItem cartItem1 : cart.getCartItems())
				{
					Double parseQuantity = Double.parseDouble(cartItem1.getQuantity());
					price += cartItem1.getArtical().getPrice() * parseQuantity;
			    }
			
			}
		
		
		cart.setPrice(price);
		
		request.getSession().setAttribute("cart", cart);
		request.getSession().setAttribute("cartItems", cart.getCartItems());
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/showChart.jsp");
		requestDispatcher.forward(request, response);
		return;
	}

}
