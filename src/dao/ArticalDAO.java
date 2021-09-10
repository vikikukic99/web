package dao;

import java.util.ArrayList;

import beans.ApplicationContext;
import beans.Artical;
import beans.ArticalType;
import beans.Location;
import beans.Restaurant;
import beans.Status;
import beans.User;

public class ArticalDAO {
	
	
	
	public ArrayList<Artical> getAllForRestoaurant(String id) {
		
		ArrayList<Artical> result = new ArrayList<Artical>();
		
		for(Artical artical: ApplicationContext.getInstane().getArticals())
		{
			if(artical.getRestaurant().getId().equals(id))
			{
				result.add(artical);
			}
			
		}
		
		return result;
	}
	
	public ArrayList<Artical> getAll() {
		return ApplicationContext.getInstane().getArticals();
	}

	
	public Artical findById(String id)
	{
		for(Artical a: ApplicationContext.getInstane().getArticals())
		{
			if(a.getID().equals(id))
			{
				return a;
			}
		}
		return null;
	}
	
public String nextId() {
		
		int id = 0;
		
		for(Artical artical: ApplicationContext.getInstane().getArticals()) {
			
			int idToCompare = Integer.parseInt(artical.getID());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
			
		}
		
		return Integer.toString(id + 1);
	}
	
	public void saveArtical (String articalName, String price, ArticalType articalType, String quantity, String description, String picture,Restaurant restaurant)
	{
		ArticalType articalTypeOfRestaurant;
		if(articalType.equals("Drink"))
		{
			articalTypeOfRestaurant = ArticalType.Drink;
		}
		else
		{
			articalTypeOfRestaurant = ArticalType.Food;
		}
		
		
		try {
		
		Artical artical = new Artical(nextId(), articalName, Double.parseDouble(price), articalTypeOfRestaurant, quantity, description, picture, restaurant);
			
			
			ApplicationContext.getInstane().getArticals().add(artical);
			ApplicationContext.getInstane().Save();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
