package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplicationContext;
import beans.Artical;
import dao.ArticalDAO;

public class ViewArticalServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewArticalServlet() {
        super();
    }

    public void init() throws ServletException {
    	super.init();
    	
        ServletContext context = getServletContext();
		String contextPath = context.getRealPath("");
		
		ApplicationContext.getInstane().setContextPath(contextPath);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = (String)request.getAttribute("id");
		
		ArticalDAO articalDAO = new ArticalDAO();
		Artical artical = articalDAO.findById(id);
		
		request.setAttribute("artical",artical);
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/viewArtical.jsp");
		disp.forward(request, response);
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
