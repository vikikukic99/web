package beans;

public class Artical {
	
	private String iD;
	private String articalName;
	private double price;
	private ArticalType articalType;
	private String quantity;
	private String description;
	private String picture;
	private Restaurant restaurant;
	
	public String exportToString()
	{
		return iD + '|' + articalName + '|' + price + '|' + articalType.toString() + '|' + quantity + '|' + description + '|' + picture + '|' + restaurant.getId(); 
	}
	
	
	public Artical(String iD, String articalName, double price, ArticalType articalType, String quantity,
			String description, String picture, Restaurant restaurant) {
		super();
		this.iD = iD;
		this.articalName = articalName;
		this.price = price;
		this.articalType = articalType;
		this.quantity = quantity;
		this.description = description;
		this.picture = picture;
		this.restaurant = restaurant;
	}
	public String getID() {
		return iD;
	}
	public void setID(String iD) {
		this.iD = iD;
	}
	public String getArticalName() {
		return articalName;
	}
	public void setArticalName(String articalName) {
		this.articalName = articalName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArticalType getArticalType() {
		return articalType;
	}
	public void setArticalType(ArticalType articalType) {
		this.articalType = articalType;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}


	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}
