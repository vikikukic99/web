package dao;

import beans.ApplicationContext;
import beans.Location;

public class LocationDAO {

	public Location findById(String id)
	{
		for(Location l: ApplicationContext.getInstane().getLocations())
		{
			if(l.getiD().equals(id))
			{
				return l;
			}
		}
		return null;
	}
	
}
