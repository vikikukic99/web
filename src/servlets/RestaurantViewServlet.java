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

import beans.Artical;
import beans.Comment;
import beans.Restaurant;
import beans.User;
import beans.WebContext;
import dao.ArticalDAO;
import dao.CommentDAO;
import dao.RestourantDAO;


public class RestaurantViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RestaurantViewServlet() {
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
		String idRestaurant = (String)request.getParameter("restaurantID"); 
		RestourantDAO restourantDAO = new RestourantDAO();
		ArticalDAO articalDAO = new ArticalDAO();
		Restaurant restaurant = restourantDAO.findByID(idRestaurant);
		
		//String restaurantID = restaurant.getRestaurantID();
		ArrayList<Artical> articles = articalDAO.getArticalsForRestorants(idRestaurant);
		
		ArrayList<Comment> comment = new ArrayList<Comment>();
		CommentDAO commentDAO = new CommentDAO();
		if(!comment.isEmpty()) {
			
			comment = commentDAO.ApprovedComment(idRestaurant);
		}
		
		request.setAttribute("restaurant",restaurant);
		request.setAttribute("articals", articles);
		request.setAttribute("approvedComment", comment);
		request.setAttribute("user", user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/restaurantView.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
