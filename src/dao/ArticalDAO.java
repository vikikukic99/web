package dao;

import java.util.ArrayList;

import beans.Artical;
import beans.Restaurant;
import beans.Type;
import beans.WebContext;

public class ArticalDAO {
	
	public Artical findByID(String id) {
		for(Artical a : WebContext.getInstance().getArticals()) {
			if(a.getArticalID().equals(id)) {
			return a;
			}		
		}
		return null;
	}
	
	public String generateID() {
		int id = 1;
		
		for(Artical artical : WebContext.getInstance().getArticals()) {
			int IDToCompare = Integer.parseInt(artical.getArticalID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	
	
	public void addArtical(String articalName, double price, Type type, String articalImage, String description, double quantity, Restaurant restaurant)
	{
		String id = generateID();
		
		Artical artical = new Artical(id, articalName, price, type, articalImage, description, quantity, restaurant);
		WebContext.getInstance().getArticals().add(artical);
		WebContext.getInstance().save();
	}
	
	public void changeArtical(String id,String articalName, double price, Type type, String articalImage, String description, double quantity)
	{
		ArticalDAO articalDAO = new ArticalDAO();
		Artical artical = articalDAO.findByID(id);
		
		artical.setArticalName(articalName);
		artical.setPrice(price);
		artical.setType(type);
		artical.setArticalImage(articalImage);
		artical.setDescription(description);
		artical.setQuantity(quantity);

		WebContext.getInstance().save();
	}
	
	public void changeArticalQuantity(String id, double quantity)
	{
		ArticalDAO articalDAO = new ArticalDAO();
		Artical artical = articalDAO.findByID(id);
		artical.setQuantity(quantity);
		WebContext.getInstance().save();
	}
	
	public ArrayList<Artical> getArticalsForRestorants(String id)
	{
		ArrayList<Artical> resultList = new ArrayList<Artical>();
		
		for(Artical artical : WebContext.getInstance().getArticals())
		{
			if(artical.getRestaurant().getRestaurantID().equals(id))
			{
				resultList.add(artical);
			}
		}
		
		return resultList;
	}
}
