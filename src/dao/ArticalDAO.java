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
	
		
		public void addArtical(String articalName, double price, ArticalType articalType, String picture, String description, double quantity, Restaurant restaurant)
		{
			String id = nextId();
			
			Artical artical = new Artical(articalName, price, articalType, picture, description, quantity, restaurant);
			ApplicationContext.getInstane().getArticals().add(artical);
			ApplicationContext.getInstane().Save();
		}
		
		public void changeArtical(String id,String articalName, double price, ArticalType articalType, String picture, String description, double quantity)
		{
			ArticalDAO articalDAO = new ArticalDAO();
			Artical artical = articalDAO.findById(id);
			
			artical.setArticalName(articalName);
			artical.setPrice(price);
			artical.setArticalType(articalType);
			artical.setPicture(picture);
			artical.setDescription(description);
			artical.setQuantity(quantity);

			ApplicationContext.getInstane().Save();
		}
		
		public void changeArticalQuantity(String id, double quantity)
		{
			ArticalDAO articalDAO = new ArticalDAO();
			Artical artical = articalDAO.findById(id);
			artical.setQuantity(quantity);
			ApplicationContext.getInstane().Save();
		}
		
		public ArrayList<Artical> getArticalsForRestorants(String id)
		{
			ArrayList<Artical> resultList = new ArrayList<Artical>();
			
			for(Artical artical : ApplicationContext.getInstane().getArticals())
			{
				if(artical.getRestaurant().getId().equals(id))
				{
					resultList.add(artical);
				}
			}
			
			return resultList;
		}

}
