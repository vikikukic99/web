package beans;

public class CartItem {

	private String iD;
	private Cart bin;
	private Artical artical;
	private String quantity;
	
	
	public String exportToString()
	{
		return iD + '|' + bin.getiD() + '|' + artical.toString() + '|' + quantity; 
	}
	
	
	public CartItem(String iD, Cart bin, Artical artical, String quantity) {
		super();
		this.iD = iD;
		this.bin = bin;
		this.artical = artical;
		this.quantity = quantity;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public Cart getBin() {
		return bin;
	}
	public void setBin(Cart bin) {
		this.bin = bin;
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
	
	
}
