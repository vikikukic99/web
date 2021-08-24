package beans;

public class OrderItem {

	private String id;
	private Artical artical;
	private Restaurant restaurant;
	
	
	public String exportToString()
	{
		return id + '|' + artical.toString() + '|' + restaurant.toString();
	}
	
	public OrderItem(String id, Artical artical, Restaurant restaurant) {
		super();
		this.id = id;
		this.artical = artical;
		this.restaurant = restaurant;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
}
