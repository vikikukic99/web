package dao;
import beans.Artical;
import beans.Cart;
import beans.CartItem;
import beans.Restaurant;
import beans.WebContext;

public class CartItemDAO {

	public CartItem findByID(String id) {
			for(CartItem cartItem : WebContext.getInstance().getCartItems()) {
				if(cartItem.getCartItemID().equals(id)) {
				return cartItem;
		}		
	}
	return null;
	
}
	
	public String generateID() {
		int id = 1;
		
		for(CartItem cartItem : WebContext.getInstance().getCartItems()) {
			int IDToCompare = Integer.parseInt(cartItem.getCartItemID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	public Restaurant getRestaurantOfArtical(String id)
	{
		Restaurant restaurant= new Restaurant();
		for(Artical artical : WebContext.getInstance().getArticals()) {
			if(artical.getArticalID().equals(id))
			{
				restaurant=artical.getRestaurant();
			}
		}
		return restaurant;
	}
	
}
