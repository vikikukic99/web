package dao;

import beans.Location;
import beans.WebContext;

public class LocationDAO {
	public Location findByID(String id) {
		for(Location l : WebContext.getInstance().getLocations()) {
			if(l.getLocationID().equals(id)) {
			return l;
			}		
		}
		return null;
	}
	
	public String generateID() {
		int id = 1;
		
		for(Location location : WebContext.getInstance().getLocations()) {
			int IDToCompare = Integer.parseInt(location.getLocationID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
public Location addLocation(String geographicalLength, String geographicalWidth, String address) {
		
		String id = generateID();
		
		Double newGeographicalLenght = Double.parseDouble(geographicalLength);
		Double newGeographicalWidth = Double.parseDouble(geographicalWidth);
		
		Location location = new Location(id, newGeographicalLenght, newGeographicalWidth, address);
		
		WebContext.getInstance().getLocations().add(location);
		WebContext.getInstance().save();
		
		return location;
	}
}
