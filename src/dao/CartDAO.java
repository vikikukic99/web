package dao;

import beans.Cart;
import beans.User;
import beans.WebContext;

public class CartDAO {

	public Cart findByID(String id) {
			for(Cart cart : WebContext.getInstance().getCarts()) {
				if(cart.getCartID().equals(id)) {
				return cart;
		}		
	}
	return null;
	
}
	
	public String generateID() {
		int id = 1;
		
		for(Cart cart : WebContext.getInstance().getCarts()) {
			int IDToCompare = Integer.parseInt(cart.getCartID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
}
