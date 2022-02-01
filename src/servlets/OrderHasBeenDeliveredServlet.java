package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.OrderStatus;
import beans.WebContext;

public class OrderHasBeenDeliveredServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHasBeenDeliveredServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
    	String contextPath = context.getRealPath("");
   	
    	WebContext.getInstance().setContextPath(contextPath);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		@SuppressWarnings("unchecked")
		ArrayList<Order> orders = (ArrayList<Order>) getServletContext().getAttribute("deliveryGuyOrders");
		for( int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderId().equals(id)) {
				if(orders.get(i).getOrderStatus().toString().equals("Transport"))
				orders.get(i).setOrderStatus(OrderStatus.Deliverd);}
		}
		
		getServletContext().getRequestDispatcher("/ViewAllOrdersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
