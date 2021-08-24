package dao;

import beans.ApplicationContext;
import beans.OrderItem;

public class OrderItemDAO {

	public OrderItem findById(String id)
	{
		for(OrderItem o: ApplicationContext.getInstane().getOrderItems())
		{
			if(o.getId().equals(id))
			{
				return o;
			}
		}
		return null;
	}
	
}
