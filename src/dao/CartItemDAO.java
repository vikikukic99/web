package dao;

import beans.ApplicationContext;
import beans.CartItem;

public class CartItemDAO {
	
	public CartItem findById(String id)
	{
		for(CartItem c: ApplicationContext.getInstane().getCartItems())
		{
			if(c.getiD().equals(id))
			{
				return c;
			}
		}
		return null;
	}

}
