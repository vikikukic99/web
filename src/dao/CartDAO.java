package dao;

import beans.ApplicationContext;
import beans.Cart;

public class CartDAO {

	public Cart findById(String id)
	{
		for(Cart c: ApplicationContext.getInstane().getCarts())
		{
			if(c.getiD().equals(id))
			{
				return c;
			}
		}
		return null;
	}
	
}
