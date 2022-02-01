package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.User;
import beans.WebContext;
import dao.OrderDAO;

public class ViewOrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ViewOrdersServlet()
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
		// TODO Auto-generated method stub
		User user = (User)request.getSession().getAttribute("user");
		String userId = user.getUserID();
		ArrayList<Order> orders = new ArrayList<Order>();
		OrderDAO orderDAO = new OrderDAO();
		orders = orderDAO.getAllOrdersWaiting();
		getServletContext().setAttribute("orders", orders);
		ArrayList<Order> deliveryGuyOrders = new ArrayList<Order>();
		OrderDAO orderDAO1 = new OrderDAO();
		deliveryGuyOrders = orderDAO1.getMyOrders(userId);
		getServletContext().setAttribute("deliveryGuyOrders", deliveryGuyOrders);
		getServletContext().getRequestDispatcher("/JSP/deliveryGuyOrders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
