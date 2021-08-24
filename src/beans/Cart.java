package beans;

public class Cart {
	
	private String iD;
	private double binPrice;
	private User buyer;
	private CartItem cartItem;
	
	public String exportToString()
	{
		return iD + '|' + binPrice + '|' + buyer.getID() + '|' + cartItem.getiD(); 
	}
	
	public Cart(String iD, double binPrice, User buyer, CartItem cartItem) {
		super();
		this.iD = iD;
		this.binPrice = binPrice;
		this.buyer = buyer;
		this.cartItem = cartItem;
	}
	public double getBinPrice() {
		return binPrice;
	}
	public void setBinPrice(double binPrice) {
		this.binPrice = binPrice;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public CartItem getCartItem() {
		return cartItem;
	}
	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}
	

}
