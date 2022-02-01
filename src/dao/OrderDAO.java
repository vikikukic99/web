package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.Cart;
import beans.CartItem;
import beans.Order;
import beans.OrderItem;
import beans.OrderStatus;
import beans.Restaurant;
import beans.User;
import beans.WebContext;
import java.text.ParseException;


public class OrderDAO {
	
	public Order findById(String id)
	{
		for(Order o: WebContext.getInstance().getOrders())
		{
			if(o.getOrderId().equals(id))
			{
				return o;
			}
		}
		return null;
	}
	
	public ArrayList<Order> findOrdersForUser(String id) {
		ArrayList<Order> orders = new ArrayList<Order>();
		for(Order order : WebContext.getInstance().getOrders()) {
			if(order.getCostumer().getUserID().equals(id)) {
				orders.add(order);
			}
		}
		return orders;
	}
	
	public ArrayList<Order> findByDeliveryGuy(String id){
		ArrayList<Order> orders = new ArrayList<Order>();
		for(Order order : WebContext.getInstance().getOrders()) {
			if(order.getDeliveryGuy()!=null) {				
				if((order.getOrderStatus().equals(OrderStatus.Transport)  || order.getOrderStatus().equals(OrderStatus.ManagerRequest))&& order.getDeliveryGuy().getUserID().equals(id)) {
					orders.add(order);
				}
			} else if(order.getOrderStatus().equals(OrderStatus.PendingDelivery)) {
				orders.add(order);
			}
		}
		return orders;
	}

	public ArrayList<Order> getOrdersForResourants(ArrayList<Restaurant> restourants) {
		
		ArrayList<Order> result = new ArrayList<Order>();
		
		for(Order order: WebContext.getInstance().getOrders()) {
			
			for(Restaurant restaurant: restourants) {
				if(order.getRestourant().getRestaurantID().equals(restaurant.getRestaurantID())) {
					result.add(order);
				}
			}
			
		}	
		return result;
	}
	
	public ArrayList<Order> searchOrders(String search,String searchByPriceFrom,String searchByPriceTo, String searchByDateFrom, String searchByDateTo, String filteringByOrderStatus, String filteringRestaurantType) {
		ArrayList<Order>  orders = new ArrayList<Order>();

		Double priceFrom = 0.0;
		Double priceTo= 0.0;
		
		if(!searchByPriceFrom.equals("") && !searchByPriceTo.equals("")) {
			
			priceFrom = Double.parseDouble(searchByPriceFrom);
			priceTo = Double.parseDouble(searchByPriceTo);
		}
		String searchString = search == null ? "" : search.toLowerCase();
		String filteringByOrderStatusString = filteringByOrderStatus == null ? "" : filteringByOrderStatus.toLowerCase();
		String filteringRestaurantTypeString = filteringRestaurantType == null ? "" : filteringRestaurantType.toLowerCase();
	
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		Date dateFrom = new Date();
		try {
			dateFrom = simpleDateFormat.parse(searchByDateFrom);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateTo = new Date();
		try {
			dateTo = simpleDateFormat.parse(searchByDateTo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(Order order : WebContext.getInstance().getOrders()) {
			

			if(!(order.getRestourant().getName().toLowerCase().contains(searchString))) {
				continue;
			}
			
			
			if((!filteringRestaurantType.equals("") &&
					!order.getRestourant().getRestaurantType().toLowerCase().equals(filteringRestaurantTypeString))) {
				continue;
			}
			
			if((!filteringByOrderStatus.equals("") &&
					!order.getOrderStatus().toString().toLowerCase().equals(filteringByOrderStatusString))) {
				continue;
			}
			
			
			if(  !searchByPriceFrom.equals("") && !searchByPriceTo.equals("")
					&& (order.getCost() < priceFrom || order.getCost() > priceTo)) {
				continue;
			}
			
			if(!searchByDateFrom.equals("") &&  !searchByDateTo.equals("") &&
					(order.getOrderDate().before(dateFrom) || order.getOrderDate().after(dateTo))) {
				continue;
			}
			
			orders.add(order);
		}		
		return orders;
	}
	
	public ArrayList<Order> restaurantTypeSort(ArrayList<Order> orders){
		orders.sort((o1,o2) -> o1.getRestourant().getRestaurantType().compareTo(o2.getRestourant().getRestaurantType()));
		return orders;
	}
	
	public ArrayList<Order> sortByPrice(ArrayList<Order> orders){
		orders.sort((o1,o2) -> Double.compare(o1.getCost(), o2.getCost()));
		return orders;
	}
	
	public ArrayList<Order> sortByDate(ArrayList<Order> orders){
		orders.sort((o1,o2) -> o1.getOrderDate().compareTo(o2.getOrderDate()));
		return orders;
	}
	
	public ArrayList<Order> getAllOrderByState(OrderStatus orderStatus){
		
		ArrayList<Order> result = new ArrayList<Order>();
		
		for(Order order : WebContext.getInstance().getOrders()) {
			if(order.getOrderStatus().equals(orderStatus)) {
				result.add(order);
			}
		}
		
		return result;
	}
	
	public ArrayList<Order> getAllOrdersWaiting() {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		for(Order order :WebContext.getInstance().getOrders()) {
			if(order.getOrderStatus().toString().equals("WaitingForSuppliers"))
			{
				orders.add(order);
			}
		}
		return orders;
	}
	
	public ArrayList<Order> getMyOrders(String userId) {
		ArrayList<Order> orders = new ArrayList<Order>();
		
		for(Order order :WebContext.getInstance().getOrders()) {
			if(order.getDeliveryGuy().getUserID().equals(userId))
			{
				orders.add(order);
			}
		}
		return orders;
	}
	
	
	public String generateId()
	{
		int id = 0;
		
		
		for(Order order : WebContext.getInstance().getOrders()) {
			
			int idToCompare = Integer.parseInt(order.getOrderId());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
		}
		
		return Integer.toString(id + 1);
	}
	
	public void createOrder(Cart cart, User buyer)
	{
		Date orderDate = new Date();

		Restaurant restaurant = cart.getRestaurant();
		
		
		Order order = new Order(generateId(),orderDate,cart.getPrice(), OrderStatus.Processing,buyer,restaurant);
	    WebContext.getInstance().getOrders().add(order);	
	    WebContext.getInstance().save();
	    
	    for(CartItem cartItem : cart.getCartItems()) {
			OrderItemDAO orderItemDAO = new OrderItemDAO();
			OrderItem orderItem = orderItemDAO.creatingAnOrderItem(cartItem,order);	
			WebContext.getInstance().getOrderItems().add(orderItem);
			WebContext.getInstance().save();
			}
	}

	public ArrayList<Order> getAllOrdersByUsers(String userId)
	{
		ArrayList<Order> orders = new ArrayList<Order>();
		
		for(Order order :WebContext.getInstance().getOrders()) {
			if(order.getCostumer().getUserID().equals(userId))
			{
				orders.add(order);
			}
		}
		return orders;
	}
}
