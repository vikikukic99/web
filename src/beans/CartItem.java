package beans;

public class CartItem {

	private String cartItemID;
	private Cart bucket;
	private Artical artical;
	private String quantity;
	
	public String getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(String cartItemID) {
		this.cartItemID = cartItemID;
	}
	public Cart getBucket() {
		return bucket;
	}
	public void setBucket(Cart bucket) {
		this.bucket = bucket;
	}
	public Artical getArtical() {
		return artical;
	}
	public void setArtical(Artical artical) {
		this.artical = artical;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public CartItem(String cartItemID, Cart bucket, Artical artical, String quantity) {
		super();
		this.cartItemID = cartItemID;
		this.bucket = bucket;
		this.artical = artical;
		this.quantity = quantity;
	}
	
	public String ExportString() 
	{
		return cartItemID + "|" + bucket.getCartID() + "|" + artical.getArticalID() + "|" + quantity;
	}
	
}
	
