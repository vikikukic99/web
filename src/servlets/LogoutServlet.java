package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.WebContext;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutServlet() {
        super();
    }
    
    
    
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
   	String contextPath = context.getRealPath("");
   	
   	WebContext.getInstance().setContextPath(contextPath);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 4: Implementirati logout
	}

}
