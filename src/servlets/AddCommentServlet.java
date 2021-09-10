package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplicationContext;
import beans.Gender;
import beans.Grade;
import beans.Restaurant;
import beans.Role;
import beans.User;
import dao.CommentDAO;
import dao.RestaurantDAO;
import dao.UserDAO;

public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public AddCommentServlet()
	{
		super();
		
		
	}
	
	public void init() throws ServletException {
    	super.init();
    	
        ServletContext context = getServletContext();
		String contextPath = context.getRealPath("");
		
		ApplicationContext.getInstane().setContextPath(contextPath);
    }
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	
    	Restaurant restaurantId = (Restaurant)request.getSession().getAttribute("restaurantId");
    	
    	request.setAttribute("id", restaurantId);
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/addComment.jsp");
    	disp.forward(request, response);
    	
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
   
    	User user = (User)request.getSession().getAttribute("user");
    	String restaurantId = (String)request.getAttribute("restaurantId");
    	String commentText = (String)request.getParameter("commentText");
    	String gradeString = (String)request.getParameter("grade");
		
    	Grade grade;
		
		if(gradeString.equals("one")) {
			grade = Grade.one;
		}
		else if(gradeString.equals("two"))
		{
			grade = Grade.two;
		}
		else if(gradeString.equals("three"))
		{
			grade = Grade.three;
		}
		else if(gradeString.equals("Four"))
		{
			grade = Grade.four;
		}
		else
		{
			grade = Grade.five;
		}
		
		try {

	    	RestaurantDAO restaurantDAO = new RestaurantDAO();
	    	Restaurant restaurant = restaurantDAO.findById(restaurantId); 
			
			CommentDAO commentDAO = new CommentDAO();
			
			
	    	commentDAO.saveComment(user, restaurant,  commentText,grade );
	    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/homePage.jsp");
        	disp.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 	
    }

}
