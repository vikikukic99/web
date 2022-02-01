package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Artical;
import beans.User;
import beans.WebContext;
import dao.ArticalDAO;

public class ViewArticalServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ViewArticalServlet()
	{
		super();
		
	}
	
	 public void init() throws ServletException {
	    	super.init();
	    	ServletContext context = getServletContext();
	   	String contextPath = context.getRealPath("");
	   	
	   	WebContext.getInstance().setContextPath(contextPath);
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User)request.getSession().getAttribute("user");
		
        String articalID = (String)request.getParameter("articalID");
		
		ArticalDAO articalDAO = new ArticalDAO();
		Artical artical = articalDAO.findByID(articalID);
		
		request.setAttribute("user",user);
		request.setAttribute("artical", artical);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/viewArtical.jsp");
		dispatcher.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	User user = (User)request.getSession().getAttribute("user");
    	
    	
		request.setAttribute("user",user);

    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.html");
		requestDispatcher.forward(request, response);
		return;
	}
}
