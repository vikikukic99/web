package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.Restaurant;
import beans.Role;
import beans.User;
import beans.WebContext;
import dao.OrderDAO;
import dao.RestourantDAO;

public class ShowBuyersOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 78L;

    /**
     * Default constructor. 
     */
    public ShowBuyersOrderServlet() {
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
		
		User user = (User)request.getSession().getAttribute("user");
		String id = user.getUserID();
		
		ArrayList<Order> orders = new ArrayList<Order>();
		if(user.getRole().equals(Role.Buyer)) {
			
			OrderDAO orderDAO = new OrderDAO();
			orders = orderDAO.findOrdersForUser(id);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/JSP/index.jsp");
			rd.forward(request,response);
			return;
		}
		
		request.setAttribute("orders",orders);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showBuyersOrder.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String search = (String)request.getParameter("search");
		 String searchByPriceFrom = (String)request.getParameter("searchByPriceFrom");
		 String searchByPriceTo = (String)request.getParameter("searchByPriceTo");
		 String searchByDateFrom = (String)request.getParameter("searchByDateFrom");
		 String searchByDateTo = (String)request.getParameter("searchByDateTo");
		 String sort = (String)request.getParameter("sort");
		 String filteringRestaurantType = (String)request.getParameter("filteringRestaurantType");
		 String filteringByOrderStatus = (String)request.getParameter("filteringByOrderStatus");
		 
		 OrderDAO orderDAO = new OrderDAO();
		 ArrayList<Order> orders = orderDAO.searchOrders(search, searchByPriceFrom,searchByPriceTo, searchByDateFrom, searchByDateTo,filteringByOrderStatus, filteringRestaurantType);
	
		 if(sort.equals("Restaurant")) {
			 orders = orderDAO.restaurantTypeSort(orders);
		 }else if(sort.equals("Price")) {
			 orders = orderDAO.sortByPrice(orders);
		 }else {
			 orders = orderDAO.sortByDate(orders);
		 }
		 
		 request.setAttribute("orders", orders);
		 
			
		 RequestDispatcher disp = request.getRequestDispatcher("/JSP/showBuyersOrder.jsp");
			disp.forward(request, response);
			return;
		}		
}

	
