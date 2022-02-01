package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Comment;
import beans.CommentStatus;
import beans.WebContext;
import dao.CommentDAO;


public class CommentIsApprovedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentIsApprovedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/managerCommentsList.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commentID = (String)request.getParameter("commentID");
		CommentDAO commentDAO = new CommentDAO();
		
		Comment comment = commentDAO.findByID(commentID);
		
		comment.setCommentStatus(CommentStatus.Approved);
		WebContext.getInstance().save();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/homePage.jsp");
		dispatcher.forward(request, response);
		return;
	}

}
