package dao;

import beans.ApplicationContext;
import beans.Restaurant;

public class RestaurantDAO {

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
	
}
