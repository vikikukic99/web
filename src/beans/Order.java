package beans;

import java.util.Date;

public class Order {
	
	private String idOrder;
	private Date orderDate;
	private double priceOrder;
	private OrderStatus orderStatus;
	private User buyer;
	private User deliverGuy;
	private Cart cart;
	private OrderItem orderItem;
	
	public String exportToString()
	{
		return idOrder + '|' + orderDate.toString() + '|' + priceOrder + '|' + orderStatus.toString() + '|' + buyer.getID() + '|' + deliverGuy.getID() + '|' + cart.toString() + '|' + orderItem.toString(); 
	}
	
	
	public Order(String idOrder, Date orderDate, double priceOrder, OrderStatus orderStatus, User buyer, User deliveryGuy, Cart cart, OrderItem orderItem) {
		super();
		this.idOrder = idOrder;
		this.orderDate = orderDate;
		this.priceOrder = priceOrder;
		this.orderStatus = orderStatus;
		this.buyer = buyer;
		this.deliverGuy = deliveryGuy;
		this.cart = cart;
		this.orderItem = orderItem;
	}
	public User getBuyer() {
		return buyer;
	}
	public User getDeliverGuy() {
		return deliverGuy;
	}
	public void setDeliverGuy(User deliverGuy) {
		this.deliverGuy = deliverGuy;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getPriceOrder() {
		return priceOrder;
	}
	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
