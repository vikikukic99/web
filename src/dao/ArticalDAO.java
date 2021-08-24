package dao;

import beans.ApplicationContext;
import beans.Artical;

public class ArticalDAO {
	
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

}
