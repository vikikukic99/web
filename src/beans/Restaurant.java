package beans;

public class Restaurant 
{
	private String restaurantID;
	private String name;
	private String restaurantType;
	private Status restaurantStatus;
	private User manager;
	private Location location;
	private String restaurantLogo;
	private Double averageGrade;
	
	public Restaurant(String restaurantID, String name, String restaurantType, Status restaurantStatus, User manager, Location location, String restaurantLogo, Double averageGrade) {
		super();
		this.restaurantID = restaurantID;
		this.name = name;
		this.restaurantType = restaurantType;
		this.restaurantStatus = restaurantStatus;
		this.manager = manager;
		this.location = location;
		this.restaurantLogo = restaurantLogo;
		this.averageGrade = averageGrade;
	}
	
	public Restaurant() {}
	
	public String getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(String restaurantID) {
		this.restaurantID = restaurantID;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	
	public Double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	public Status getRestaurantStatus() {
		return restaurantStatus;
	}
	public void setRestaurantStatus(Status restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}
	public String getRestaurantLogo() {
		return restaurantLogo;
	}
	public void setRestaurantLogo(String restaurantLogo) {
		this.restaurantLogo = restaurantLogo;
	}
	

	public String ExportString() 
	{
		return restaurantID + "|" + name + "|" + restaurantType + "|" + restaurantStatus.toString() + "|" + manager.getUserID() + "|" + location.getLocationID() + "|" + restaurantLogo + "|" + averageGrade.toString();
	}
}
