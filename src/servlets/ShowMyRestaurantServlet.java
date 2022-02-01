package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class ShowMyRestaurantServlet
 */
public class ShowMyRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyRestaurantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		 Restaurant restaurant = new Restaurant();
		 
		 for(Restaurant restaurant2 : WebContext.getInstance().getRestaurants()) {
			 if(restaurant2.getManager().getUserID()==user.getUserID()) {
				 restaurant = restaurant2;
			 }
		 }
		
		ArticalDAO articalDAO = new ArticalDAO();
		
		
		ArrayList<Artical> articles = articalDAO.getArticalsForRestorants(restaurant.getRestaurantID());
		
		if(articles.isEmpty()) {
			articles= new ArrayList<Artical>();
		}
		
		request.setAttribute("restaurantID", restaurant.getRestaurantID());
		request.setAttribute("restaurant",restaurant);
		request.setAttribute("articles", articles);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/showMyRestaurant.jsp");
		dispatcher.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
