package beans;

import java.util.ArrayList;

public class Cart 
{
	private String cartID;
	private double price;
	private User costumer;
	private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
	private Restaurant restaurant;
	
	public String getCartID() {
		return cartID;
	}
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getCostumer() {
		return costumer;
	}
	public void setCostumer(User costumer) {
		this.costumer = costumer;
	}
	public ArrayList<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(ArrayList<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	
	public void setRestarant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public Cart(String cartID, double price, User costumer) {
		super();
		this.cartID = cartID;
		this.price = price;
		this.costumer = costumer;
	
	}
	
	public Cart(String cartID, User costumer) {
		super();
		this.cartID = cartID;
		this.costumer = costumer;
	
	}
	
	public Cart(String cartID, User costumer, Restaurant restaurant) {
		super();
		this.cartID = cartID;
		this.costumer = costumer;
		this.restaurant = restaurant;
	
	}
	
	
	public Cart(String cartID, ArrayList<CartItem> cartItems) {
		super();
		this.cartID = cartID;
		this.cartItems = cartItems;
	
	}
	
	public Cart(String cartID, double price, User costumer, ArrayList<CartItem> cartItems)
	{
		super();
		this.cartID =cartID;
		this.price = price;
		this.costumer = costumer;
		this.cartItems = cartItems;
	}
	
	public Cart(String cartID, double price, User costumer, ArrayList<CartItem> cartItems, Restaurant restaurant) {
		super();
		this.cartID = cartID;
		this.price = price;
		this.costumer = costumer;
		this.cartItems = cartItems;
		this.restaurant = restaurant;
	}
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public String ExportString() 
	{
		return cartID + "|" + price + "|" + costumer.getUserID();
	}
	
}
