package dao;

import beans.ApplicationContext;
import beans.TypeOfBuyer;

public class TypeOfBuyerDAO {

	public TypeOfBuyer findById(String id)
	{
		if(id == null) {
			return null;
		}
		
		
		for(TypeOfBuyer t: ApplicationContext.getInstane().getTypeOfBuyers())
		{
			if(t.getiD().equals(id))
			{
				return t;
			}
		}
		return null;
	}
	
}
