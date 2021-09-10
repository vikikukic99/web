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
import beans.OrderStatus;
import beans.Role;
import beans.TypeOfBuyer;
import beans.User;
import dao.TypeOfBuyerDAO;
import dao.UserDAO;

public class RegistationServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	      
		public RegistationServlet()
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
	    	
	    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/registration.jsp");
	    	disp.forward(request, response);
	    }
	    
	    @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
	   
	    	String username = (String)request.getParameter("username");
	    	String password = (String)request.getParameter("password");
	    	String name = (String)request.getParameter("name");
	    	String surname = (String)request.getParameter("surname");
	    	
	    	String genderString = (String)request.getParameter("gender");
	    	String birthdateString = (String)request.getParameter("birthDate");
	    	String roleString = (String)request.getParameter("role");
			
	    	Gender gender;
			
			if(genderString.equals("Male")) {
				gender = Gender.Male;
			}
			else if(genderString.equals("Female"))
			{
				gender = Gender.Female;
			}
			else
			{
				gender = Gender.Other;
			}
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			try {
				Date birthDate = simpleDateFormat.parse(birthdateString);
				Role role = Role.buyer;
				
				
		    	String nummberOfPoints = (String)request.getAttribute("nummberOfPoints");
		    	
		    	String typeOfBuyerString = (String)request.getAttribute("typeOfBuyer");
		    	
		    	
		    	UserDAO userDAO = new UserDAO();
		    	userDAO.saveUser(username, password,  name,surname, gender.toString(), birthdateString , role,  nummberOfPoints, typeOfBuyerString );
		    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/registration.jsp");
	        	disp.forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			
	    	
	    }
}
