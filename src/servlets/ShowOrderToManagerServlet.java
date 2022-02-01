package servlets;

import java.io.IOException;
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
import dao.RestourantDAO;

public class ShowOrderToManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 5L;

    /**
     * Default constructor. 
     */
    public ShowOrderToManagerServlet() {
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
//		
//		if(!user.getRole().equals(Role.Manager)) {
//			RequestDispatcher rd = request.getRequestDispatcher("index.html");
//			rd.forward(request,response);
//			return;
//		}

		
		if(!user.getRole().equals(Role.Manager) && !user.getRole().equals(Role.DeliveryGuy)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);
	    	return;
		}	
		
		if(user.getRole().equals(Role.Manager)) {
			
		    RestourantDAO restourantDAO = new RestourantDAO();
			OrderDAO orderDAO = new OrderDAO();
			
			request.setAttribute("orders", orderDAO.getOrdersForResourants(restourantDAO.getRestaurantForManager(user.getUserID())));
			
		}else if(user.getRole().equals(Role.DeliveryGuy)) {
		   
			OrderDAO orderDAO = new OrderDAO();	
			orders = orderDAO.findByDeliveryGuy(id);
			request.setAttribute("orders",orders);
		}
   
	
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showOrderToManager.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
