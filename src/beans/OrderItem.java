package beans;

public class OrderItem {

	private String orderItemID;
	private Artical artical;
	private Restaurant restaurant;
	private Order order;
	

	public OrderItem(String generateId, Restaurant restaurant2, Artical artical2, Order order) {
		this.orderItemID=generateId;
		this.restaurant=restaurant2;
		this.artical= artical2;
		this.order=order;
	}
	public String getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(String orderItemID) {
		this.orderItemID = orderItemID;
	}
	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String ExportString() 
	{
		return orderItemID + "|" + artical.getArticalID() + "|" + restaurant.getRestaurantID() + "|" + order.getOrderId() ;
	}
	
}
