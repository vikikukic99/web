package beans;

public class Restaurant {

	private String id;
	private String restaurantName;
	private String restaurantType;
	private Status status;
	private String logoOfRestaurant;
	private User menager;
	private Location location;
	
	public String exportToString()
	{
		return id + '|' + restaurantName + '|' + restaurantType + '|' + status.toString() + logoOfRestaurant + menager.getID() + location.toString() ; 
	}
	
	
	public Restaurant(String id, String restaurantName, String restaurantType, Status status, String logoOfRestaurant, Location location, User menager) {
		super();
		this.id = id;
		this.restaurantName = restaurantName;
		this.restaurantType = restaurantType;
		this.status = status;
		this.logoOfRestaurant = logoOfRestaurant;
		this.menager = menager;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getLogoOfRestaurant() {
		return logoOfRestaurant;
	}
	public void setLogoOfRestaurant(String logoOfRestaurant) {
		this.logoOfRestaurant = logoOfRestaurant;
	}
	public User getMenager() {
		return menager;
	}
	public void setMenager(User menager) {
		this.menager = menager;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
}
