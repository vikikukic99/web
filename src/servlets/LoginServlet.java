package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import beans.WebContext;
import dao.UserDAO;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();

    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
    	String contextPath = context.getRealPath("");
   		WebContext.getInstance().setContextPath(contextPath);
    }
  
    /***
     * Preusmerava korisnika na login stranicu.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/login.jsp");
    	disp.forward(request, response);
    }
    
    /***
     * Prihvata korisnièko ime i lozinku iz forme i pokušava da uloguje korisnika. 
     * Pri neuspešnom loginu preusmerava korisnika nazad na login stranicu, sa porukom greške.
     */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String username = (String)request.getParameter("username");
    	String password = (String)request.getParameter("password");
    	
    	UserDAO userDAO = new UserDAO();
    	
    	User user = userDAO.getByUsernameAndPassword(username, password);
    	
    	
    	if(user == null) {
    		RequestDispatcher disp = request.getRequestDispatcher("/JSP/login.jsp");
    		request.setAttribute("error", "Wrong username or password");
        	disp.forward(request, response);
        	return;
    	}
    	
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("user", user);
    	
    	RequestDispatcher disp = request.getRequestDispatcher("/JSP/homePage.jsp");
		disp.forward(request, response);
    	return;
    	
	}
    

}
