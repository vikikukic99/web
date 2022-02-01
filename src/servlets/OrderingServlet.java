package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cart;
import beans.NameType;
import beans.TypeOfCostumer;
import beans.User;
import beans.WebContext;
import dao.OrderDAO;
import dao.TypeOfCostumerDAO;

public class OrderingServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	ServletContext context = getServletContext();
   	    String contextPath = context.getRealPath("");
   	
      	WebContext.getInstance().setContextPath(contextPath);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		User buyer = (User)request.getSession().getAttribute("user");
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.createOrder(cart, buyer);
		
		Double numerOfPoints = cart.getPrice() / 1000 * 133;
		Double pointsOfBuyer = Double.parseDouble(buyer.getPointsCollected());
		Double points = pointsOfBuyer + numerOfPoints;
		String numberOfPointsString = String.valueOf(points);
		
		TypeOfCostumerDAO typeOfCostumerDAO = new TypeOfCostumerDAO();
		TypeOfCostumer silverCostumer = new TypeOfCostumer();
		silverCostumer.setDiscount(3);
		silverCostumer.setTypeOfCostumerID(typeOfCostumerDAO.generateID());
		silverCostumer.setNameType(NameType.Silver);
		silverCostumer.setRequestedPoints("1500");
		
		TypeOfCostumer goldenCostumer = new TypeOfCostumer();
		goldenCostumer.setDiscount(7);
		goldenCostumer.setTypeOfCostumerID(typeOfCostumerDAO.generateID());
		goldenCostumer.setNameType(NameType.Golden);
		goldenCostumer.setRequestedPoints("3000");
		
		if(points>=1500 && points<=3000) {
			buyer.setTypeOfCostumer(silverCostumer);
		}
		
		if(points>3000) {
			buyer.setTypeOfCostumer(goldenCostumer);
		}
		
		buyer.setPointsCollected(numberOfPointsString);
		WebContext.getInstance().save();
		
		request.getSession().setAttribute("cart", null);
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/homePage.jsp");
		disp.forward(request, response);
    	return;
	}

	
}
