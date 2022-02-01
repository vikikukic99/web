package dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OrderItem;
import beans.WebContext;


public class ShowArticalForOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticalForOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = (String)request.getParameter("orderId");
		ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		for(OrderItem orderItem : WebContext.getInstance().getOrderItems()) {
			if(orderItem.getOrder().getOrderId().equals(orderId)){
				orderItems.add(orderItem);
			}
		}
		
		request.setAttribute("orderItems", orderItems);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/showArticalForOrder.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		requestDispatcher.forward(request, response);
		return;
	}

}
