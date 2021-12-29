package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.ApplicationContext;
import beans.Gender;
import beans.Location;
import beans.Restaurant;
import beans.Role;
import beans.Status;
import beans.TypeOfBuyer;
import beans.User;

public class RestaurantDAO {
	
	public ArrayList<Restaurant> getAll() 
	{
		return ApplicationContext.getInstane().getRestaurants();
	}
	
	public ArrayList<Restaurant> sortbyName(ArrayList<Restaurant> restaurants)
	{
		restaurants.sort((o1,o2) -> o1.getRestaurantName().compareTo(o2.getRestaurantName()));
		return restaurants;
	}
	
	public ArrayList<Restaurant> sortbyLocation(ArrayList<Restaurant> restaurants)
	{
		restaurants.sort((o1,o2) -> o1.getLocation().getAddress().compareTo(o2.getLocation().getAddress()));
		return restaurants; 
	}
	
	public String generateID() {
		int id = 1;
		
		for(Restaurant restaurant : ApplicationContext.getInstane().getRestaurants()) {
			int IDToCompare = Integer.parseInt(restaurant.getRestaurantName());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	public Restaurant findById(String id)
	{
		for(Restaurant r: ApplicationContext.getInstane().getRestaurants())
		{
			if(r.getId().equals(id))
			{
				return r;
			}
		}
		return null;
	}
	
	public String nextId() {
		
		int id = 0;
		
		for(Restaurant restaurant: ApplicationContext.getInstane().getRestaurants()) {
			
			int idToCompare = Integer.parseInt(restaurant.getId());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
			
		}
		
		return Integer.toString(id + 1);
	}
	
	public void addRestaurant(String id, String restaurantName, String restaurantType, Status status, String logoOfRestaurant, Location location, User menager) {
		
		String idd = generateID();
		Status statuss = Status.Close;

		Restaurant restaurant = new Restaurant( id,  restaurantName,  restaurantType,  status,  logoOfRestaurant,  location,  menager);
		ApplicationContext.getInstane().getRestaurants().add(restaurant);
		ApplicationContext.getInstane().Save();
	}
	

	public ArrayList<Restaurant> searchAllRestourants(String search, String typeOfRestaurant, String restaurantStatus) {

		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		
		String searchString = search == null ? "" : search.toLowerCase();
		String typeOfRestourantString = typeOfRestaurant == null ? "" : typeOfRestaurant.toLowerCase();
		String restaurantStatusString = restaurantStatus == null ? "" : restaurantStatus.toLowerCase();
		
	
		
		for(Restaurant restaurant : ApplicationContext.getInstane().getRestaurants()) {
			

			if(!(restaurant.getRestaurantName().toLowerCase().contains(searchString)
					|| restaurant.getLocation().getAddress().toLowerCase().contains(searchString))) {
				continue;
			}
			
			
			if((!typeOfRestaurant.equals("") &&
					!restaurant.getRestaurantType().toLowerCase().equals(typeOfRestourantString))) {
				continue;
			}
			
			if((!restaurantStatus.equals("") &&
					!restaurant.getStatus().toString().toLowerCase().equals(restaurantStatusString))) {
				continue;
			}
			
			
			result.add(restaurant);
		}
		return result;
		}
	
	public void saveRestaurant (String restaurantName, String restaurantType, Status status, String logoOfRestaurant, User menager, Location location)
	{
		Status restaurantStatus;
		if(status.equals("Open"))
		{
			restaurantStatus = Status.Open;
		}
		else
		{
			restaurantStatus = Status.Close;
		}
		
		
		try {
		
		Restaurant restaurant = new Restaurant( nextId(), restaurantName, restaurantType, restaurantStatus, logoOfRestaurant, location, menager);
			
			
			ApplicationContext.getInstane().getRestaurants().add(restaurant);
			ApplicationContext.getInstane().Save();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Restaurant> searchRestaurant (String search, String restaurantType, String restaurantStatus)
	{
		
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		
		for(Restaurant restaurant : ApplicationContext.getInstane().getRestaurants()) {
			
				if(restaurant.getRestaurantName().toLowerCase().contains(search.toLowerCase()) ||
					restaurant.getRestaurantType().toLowerCase().contains(search.toLowerCase()) ||
					restaurant.getLocation().getAddress().toLowerCase().contains(search.toLowerCase()) ||
					restaurant.getLocation().getCity().toLowerCase().contains(search.toLowerCase()) ||
					restaurant.getLocation().getCountry().toLowerCase().contains(search.toLowerCase()) ||
					restaurant.getRestaurantType().toLowerCase().equals(restaurantType) ||
					restaurant.getStatus().equals(restaurantStatus))
					
					{
						result.add(restaurant);
					}
		}
			return result;
	}

	public ArrayList<Restaurant> getRestaurantForManager(String managerId) {
		
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
	
		for(Restaurant restauran: ApplicationContext.getInstane().getRestaurants()) {
		
			if(restauran.getMenager().getID().equals(managerId)) {
				result.add(restauran);
			}
			
		}
		
		return result;
	}
}
