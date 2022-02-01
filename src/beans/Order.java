package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {

	private String orderId;
	private Date orderDate;
	private Double cost;
	private OrderStatus orderStatus;
	private User costumer;
	private User deliveryGuy;
	private Restaurant restourant;
	
	/*public Order(String orderId, Date orderDate, String cost, OrderStatus orderStatus, User costumer, User deliveryGuy,
			OrderItem orderItem) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cost = cost;
		this.orderStatus = orderStatus;
		this.costumer = costumer;
		this.deliveryGuy = deliveryGuy;
		this.orderItem = orderItem;
	}
	*/
	

	public Order(String orderId, Date orderDate, Double cost, OrderStatus orderStatus, User costumer, User deliveryGuy, Restaurant restaurant) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cost = cost;
		this.orderStatus = orderStatus;
		this.costumer = costumer;
		this.deliveryGuy = deliveryGuy;
		this.restourant = restaurant;
	}
	
	public Order() {
		super();
		//this.orderId = orderId;
		//this.orderDate = orderDate;
		//this.cost = cost;
		//this.orderStatus = orderStatus;
		//this.costumer = costumer;
		//this.restourant = restourant;
	}



	

	public Order(String orderID, Date orderDate2, double price, OrderStatus orderStatus, User buyer,
			Restaurant restaurant) {
		this.orderId=orderID;
		this.orderDate=orderDate2;
		this.cost=price;
		this.orderStatus=orderStatus;
		this.costumer=buyer;
		this.restourant=restaurant;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Restaurant getRestourant() {
		return restourant;
	}



	public void setRestourant(Restaurant restourant) {
		this.restourant = restourant;
	}



	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public User getCostumer() {
		return costumer;
	}

	public void setCostumer(User costumer) {
		this.costumer = costumer;
	}

	public User getDeliveryGuy() {
		return deliveryGuy;
	}

	public void setDeliveryGuy(User deliveryGuy) {
		this.deliveryGuy = deliveryGuy;
	}
	
	public String ExportString() 
	{
		String convertDate = "yyyy-MM-dd";
		SimpleDateFormat simpleDateForm = new SimpleDateFormat(convertDate);
		
		String date = simpleDateForm.format(orderDate);
		
		return orderId + "|" + date + "|" + cost + "|" + orderStatus.toString() + "|" + costumer.getUserID() + "|" + (deliveryGuy == null ? " " : deliveryGuy.getUserID()) + "|" + restourant.getRestaurantID();
	}
}
