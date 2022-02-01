package dao;

import java.util.ArrayList;

import javax.servlet.jsp.jstl.sql.Result;

import beans.Location;
import beans.Restaurant;
import beans.Status;
import beans.Type;
import beans.User;
import beans.WebContext;

public class RestourantDAO {
	
	public Restaurant findByID(String id) {
		
		for(Restaurant r: WebContext.getInstance().getRestaurants()) {
			if(r.getRestaurantID().equals(id)) {
				return r;
			}
		}
		
		return null;
	}
	
	public String generateID() {
		int id = 1;
		
		for(Restaurant restaurant : WebContext.getInstance().getRestaurants()) {
			int IDToCompare = Integer.parseInt(restaurant.getRestaurantID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	public void addRestaurant(String name, String restaurantType, Location location, User restaurantManager,  String restaurantLogo) {
		
		String id = generateID();
		Status status = Status.not_working;
		
		Restaurant restaurant = new Restaurant(id, name, restaurantType, status, restaurantManager, location, restaurantLogo,0.0);
		WebContext.getInstance().getRestaurants().add(restaurant);
		WebContext.getInstance().save();
	}
	

	public ArrayList<Restaurant> searchAllRestourants(String search, String typeOfRestaurant, String restaurantStatus) {

		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
		
		String searchString = search == null ? "" : search.toLowerCase();
		String typeOfRestourantString = typeOfRestaurant == null ? "" : typeOfRestaurant.toLowerCase();
		String restaurantStatusString = restaurantStatus == null ? "" : restaurantStatus.toLowerCase();
		
	
		
		for(Restaurant restaurant : WebContext.getInstance().getRestaurants()) {
			

			if(!(restaurant.getName().toLowerCase().contains(searchString)
					|| restaurant.getLocation().getAddress().toLowerCase().contains(searchString))) {
				continue;
			}
			
			
			if((!typeOfRestaurant.equals("") &&
					!restaurant.getRestaurantType().toLowerCase().equals(typeOfRestourantString))) {
				continue;
			}
			
			if((!restaurantStatus.equals("") &&
					!restaurant.getRestaurantStatus().toString().toLowerCase().equals(restaurantStatusString))) {
				continue;
			}
			
			
			result.add(restaurant);
		}
		return result;
		}
	
	public ArrayList<Restaurant> sortByName(ArrayList<Restaurant> restaurants){
		restaurants.sort((o1,o2) -> o1.getName().compareTo(o2.getName()));
		return restaurants;
	}
	
	public ArrayList<Restaurant> sortByLocation(ArrayList<Restaurant> restaurants){
		restaurants.sort((o1,o2) -> o1.getLocation().getAddress().compareTo(o2.getLocation().getAddress()));
		return restaurants;
	}
	
	
	public ArrayList<Restaurant> getRestaurantForManager(String managerId) {
	
		ArrayList<Restaurant> result = new ArrayList<Restaurant>();
	
		for(Restaurant restauran: WebContext.getInstance().getRestaurants()) {
		
			if(restauran.getManager().getUserID().equals(managerId)) {
				result.add(restauran);
			}
			
		}
		
		return result;
	}
	
}
