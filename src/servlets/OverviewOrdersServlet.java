package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Order;
import beans.Role;
import beans.User;
import beans.WebContext;
import dao.OrderDAO;

public class OverviewOrdersServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverviewOrdersServlet() {
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
		User user = (User)request.getSession().getAttribute("user");
		String userId= user.getUserID();
		
		ArrayList<Order> orders = new ArrayList<Order>();
		
		if(user.getRole().equals(Role.Buyer)) {
			OrderDAO orderDAO = new OrderDAO();
			orders = orderDAO.getAllOrdersByUsers(userId);
		}
		else {
			RequestDispatcher disp = request.getRequestDispatcher("index.html");
			disp.forward(request, response);
	    	return;
		}
		
		
		request.setAttribute("orders", orders);	
		 
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/showBuyerOrder.jsp");
	    	disp.forward(request, response);	
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
		 
			
		 RequestDispatcher disp = request.getRequestDispatcher("/JSP/orderOverview.jsp");
			disp.forward(request, response);
			return;
	}
	
}
