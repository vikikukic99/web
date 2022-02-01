package beans;

public class Artical
{
	private String articalID;
	private String articalName;
	private double price;
	private Type type;
	private Restaurant restaurant;
	private double quantity;
	private String description;
	private String articalImage;

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
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArticalImage() {
		return articalImage;
	}
	public void setArticalImage(String articalImage) {
		this.articalImage = articalImage;
	}
	
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	
	public String getArticalID() {
		return articalID;
	}
	public void setArticalID(String articalID) {
		this.articalID = articalID;
	}
	public Artical(String articalID, String articalName, double price, Type type, Restaurant restaurant ,double quantity, String description,
			String articalImage) {
		super();
		this.articalID = articalID;
		this.articalName = articalName;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
		this.description = description;
		this.articalImage = articalImage;
		this.restaurant = restaurant;
		
	}
	
public Artical(String id, String articalName2, double price2, Type type2, String articalImage2, String description2,
			double quantity2, Restaurant restaurant) {
		articalID=id;
		articalName=articalName2;
		price=price2;
		type=type2;
		articalImage=articalImage2;
		description=description2;
		quantity=quantity2;
		this.restaurant = restaurant;
	}
public Artical() {
	// TODO Auto-generated constructor stub
}
public String ExportString() 
	{
		return articalID + "|" + articalName + "|" + price + "|" + type.toString() + "|" + restaurant.getRestaurantID() + "|" + quantity + "|" + description + "|" + articalImage;
	}
	

}
