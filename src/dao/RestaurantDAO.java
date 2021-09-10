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
		restaurants.sort((o1,o2) -> o1.getLocation().getAdress().compareTo(o2.getLocation().getAdress()));
		return restaurants; 
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
			
				if(restaurant.getRestaurantName().toLowerCase().contains(search) ||
					restaurant.getRestaurantType().toLowerCase().contains(search) ||
					restaurant.getLocation().getAdress().toLowerCase().contains(search) ||
					restaurant.getLocation().getCity().toLowerCase().contains(search) ||
					restaurant.getLocation().getCountry().toLowerCase().contains(search) ||
					restaurant.getRestaurantType().toLowerCase().equals(restaurantType) ||
					restaurant.getStatus().equals(restaurantStatus))
					
					{
						result.add(restaurant);
					}
		}
			return result;
	}

}
