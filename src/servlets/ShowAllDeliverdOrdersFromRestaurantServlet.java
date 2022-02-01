package servlets;

import java.io.IOException;
import java.util.ArrayList;

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

public class ShowAllDeliverdOrdersFromRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllDeliverdOrdersFromRestaurantServlet() {
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
		
		OrderDAO orderDAO = new OrderDAO();
		
		ArrayList<Order> orders = orderDAO.getAllOrderByState(OrderStatus.Deliverd);
		
		request.setAttribute("orders", orders);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showAllDeliverdOrdersFromRestaurant.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
// TREBA DA NAPRAVIM DA IZLISSTA SVE DOSTAVLJENJE NARUDZBINE I LINKOVE DO KOMENTARA!!!1
}
