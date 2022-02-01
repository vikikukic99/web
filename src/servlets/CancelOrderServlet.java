package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.OrderStatus;
import beans.User;
import beans.WebContext;

public class CancelOrderServlet  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
    public CancelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
    	String contextPath = context.getRealPath("");
   	
        WebContext.getInstance().setContextPath(contextPath);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/showBuyerOrders.jsp");
		disp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getParameter("orderID");
		User user = (User)request.getSession().getAttribute("user");
		
		double numberOfLostPoints=0;
		double numberOfPoints=Double.parseDouble(user.getPointsCollected());
		
		Order toDelete = new Order();
		
		for(Order order : WebContext.getInstance().getOrders()) {
			if(order.getOrderId().equals(id)) {
			
				toDelete=order;
			}
		}
		
		if(toDelete!=null) {
			for(Order order : WebContext.getInstance().getOrders()) {
				if(order.getOrderId().equals(toDelete.getOrderId())) {
					order.setOrderStatus(OrderStatus.Canceled);
					WebContext.getInstance().save();
					numberOfLostPoints = toDelete.getCost()/1000*33*4;
				}
			}
			
		}

		numberOfPoints=numberOfLostPoints-numberOfLostPoints;
		
		String newPoints=Double.toString(numberOfPoints);
		
		user.setPointsCollected(newPoints);
		
	    request.getSession().setAttribute("user", user);
		
	    response.sendRedirect("/WebShop/ShowBuyersOrderServlet");
	    
//		RequestDispatcher disp = request.getRequestDispatcher("/OrderOverviewServlet");
//		disp.forward(request, response);
		return;
	}
	
}
