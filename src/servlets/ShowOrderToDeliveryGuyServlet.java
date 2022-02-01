//package servlets;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import beans.Order;
//import beans.Restaurant;
//import beans.Role;
//import beans.User;
//import beans.WebContext;
//import dao.OrderDAO;
//import dao.RestourantDAO;
//
//public class ShowOrderToDeliveryGuyServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 88L;
//
//    /**
//     * Default constructor. 
//     */
//    public ShowOrderToDeliveryGuyServlet() {
//        // TODO Auto-generated constructor stub
//    	
//    }
//    
//    public void init() throws ServletException {
//    	super.init();
//    	ServletContext context = getServletContext();
//   	String contextPath = context.getRealPath("");
//   	
//   	WebContext.getInstance().setContextPath(contextPath);
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		User user = (User)request.getSession().getAttribute("user");
//		String id = user.getUserID();
//		
//		ArrayList<Order> orders = new ArrayList<Order>();
//		if(user.getRole().equals(Role.DeliveryGuy)) {
//			
//			OrderDAO orderDAO = new OrderDAO();
//			orders = orderDAO.findByDeliveryGuy(id);
//			
//		}else {
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.forward(request,response);
//			return;
//		}
//		
//		request.setAttribute("orders",orders);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showBuyersOrder.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String search = (String)request.getAttribute("search");
//		String startPriceSearch = (String)request.getAttribute("startPriceSearch");
//		String endPriceSearch = (String)request.getAttribute("endPriceSearch");
//		Date startDateSearch = (Date)request.getAttribute("startDateSearch");
//		Date endDateSearch = (Date)request.getAttribute("endDateSearch");
//		String sort = (String)request.getAttribute("sort");
//		String orderStatusFilter = (String)request.getAttribute("orderStatusFilter");
//		String restaurantTypeFilter = (String)request.getAttribute("restaurantTypeFilter");
//		
//		OrderDAO orderDAO = new OrderDAO();
//		ArrayList<Order> orders = new OrderDAO().searchOrders(search, startPriceSearch, endPriceSearch, startDateSearch, endDateSearch, orderStatusFilter, restaurantTypeFilter);
//			if(sort.equals("Restaurant")) {
//				orders = orderDAO.restaurantTypeSort(orders);
//			}else if(sort.equals("Price")){
//				orders = orderDAO.sortByPrice(orders);
//			}else {
//				orders = orderDAO.sortByDate(orders);
//			}
//			
//			request.setAttribute("orders", orders);
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showOrdersToDeliveryGuy.jsp");
//			dispatcher.forward(request, response);
//	}
//
//	
//}
