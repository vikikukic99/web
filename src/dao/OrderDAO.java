package dao;

import beans.ApplicationContext;
import beans.Order;

public class OrderDAO {

	public Order findById(String id)
	{
		for(Order o: ApplicationContext.getInstane().getOrders())
		{
			if(o.getIdOrder().equals(id))
			{
				return o;
			}
		}
		return null;
	}
	
}
