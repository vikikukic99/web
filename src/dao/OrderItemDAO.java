package dao;

import beans.Cart;
import beans.CartItem;
import beans.Order;
import beans.OrderItem;
import beans.Restaurant;
import beans.WebContext;

public class OrderItemDAO {
	
	public OrderItem findByID(String id) {
		for(OrderItem orderItem : WebContext.getInstance().getOrderItems()) {
			if(orderItem.getOrderItemID().equals(id)) {
				return orderItem;
			}
		}
		return null;
	}
	
	
	public String generateId()
	{
		int id = 0;
		
		
		for(OrderItem orderItem : WebContext.getInstance().getOrderItems()) {
			
			int idToCompare = Integer.parseInt(orderItem.getOrderItemID());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
		}
		
		return Integer.toString(id + 1);
	}
	
	public OrderItem creatingAnOrderItem(CartItem cartItem, Order order) {
		
		CartItemDAO cartItemDAO = new CartItemDAO();
		Restaurant restaurant = cartItemDAO.getRestaurantOfArtical(cartItem.getArtical().getArticalID());
		
		OrderItem orderItem = new OrderItem(generateId(), restaurant, cartItem.getArtical(),order);
		
		return orderItem;
	}
	
}