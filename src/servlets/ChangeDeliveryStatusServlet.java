package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.OrderStatus;
import beans.WebContext;
import dao.OrderDAO;


public class ChangeDeliveryStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDeliveryStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showOrdersToManager.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = (String)request.getParameter("orderId");
		
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findById(orderId);
		
		order.setOrderStatus(OrderStatus.PendingDelivery);
		WebContext.getInstance().save();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
