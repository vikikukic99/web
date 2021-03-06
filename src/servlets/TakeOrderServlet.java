package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.OrderStatus;
import beans.User;
import beans.WebContext;
import dao.OrderDAO;


public class TakeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		User user = (User)request.getSession().getAttribute("user");
		
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findById(orderId);
		
		order.setOrderStatus(OrderStatus.ManagerRequest);
		order.setDeliveryGuy(user);
		WebContext.getInstance().save();
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/homePage.jsp");
		disp.forward(request, response);
    	return;
		
		
	}

}
