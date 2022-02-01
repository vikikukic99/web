package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Comment;
import beans.Grade;
import beans.Order;
import beans.Restaurant;
import beans.User;
import beans.WebContext;
import dao.CommentDAO;
import dao.OrderDAO;
import dao.RestourantDAO;

public class CommentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
	//	Restaurant restaurant = (Restaurant)request.getSession().getAttribute("restaurant");
		String orderID =(String)request.getParameter("orderID");
		
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.findById(orderID);
		
		Restaurant restaurant = new Restaurant();
		
		for(Restaurant r : WebContext.getInstance().getRestaurants() ) {
			if(order.getRestourant().getRestaurantID().equals(r.getRestaurantID())) {
				restaurant=r;
			}
		}
		
		 request.setAttribute("restaurantID", restaurant.getRestaurantID());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/comment.jsp");
		dispatcher.forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String comment =request.getParameter("comment");
		String grade = request.getParameter("grade");
		String restaurantID = (String)request.getParameter("restaurantID");
		User user = (User)request.getSession().getAttribute("user");
		
		RestourantDAO restourantDAO = new RestourantDAO();
		Restaurant restaurant = restourantDAO.findByID(restaurantID);
		
		CommentDAO commentDAO = new CommentDAO();
		Double averageGrade = 0.0;
		Double sum = 0.0;
		Double gr = 0.0;
		int brojac = 0;
		
		
		commentDAO.saveComment(commentDAO.generateID(), comment, grade, user, restaurant);
		
		for(Comment commentt : WebContext.getInstance().getComments()) {
			if(commentt.getRestaurant().equals(restaurantID)) {
				if(commentt.getGrade().toString().equals("one")) {
					gr=1.0;
				}else if(commentt.getGrade().toString().equals("two")) {
					gr=2.0;
				}else if(commentt.getGrade().toString().equals("three")) {
					gr=3.0;
				}else if(commentt.getGrade().toString().equals("four")) {
					gr=4.0;
				}else {
					gr=5.0;
				}
				sum += gr;
				brojac++;
				averageGrade=sum/brojac;
			}
		}
		
		restaurant.setAverageGrade(averageGrade);
		WebContext.getInstance().save();
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
