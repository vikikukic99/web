package dao;

import beans.TypeOfCostumer;
import beans.User;
import beans.WebContext;

public class TypeOfCostumerDAO {
	
	public TypeOfCostumer findByID(String id) {
		for(TypeOfCostumer typeOfCostumer : WebContext.getInstance().getTypeOfCostumers()) {
			if(typeOfCostumer.getTypeOfCostumerID().equals(id)) {
			return typeOfCostumer;
			}		
		}
		return null;
	}
	public void setDiscount(TypeOfCostumer typeOfCostumer) {
		if(typeOfCostumer.getNameType().equals("Bronze")) {
			typeOfCostumer.setDiscount(10);
		} else if(typeOfCostumer.getNameType().equals("Silver")) {
			typeOfCostumer.setDiscount(20);
		} else {
			typeOfCostumer.setDiscount(35);
		}
	}
	
	public void setRequestedPoints(TypeOfCostumer typeOfCostumer) {
		if(typeOfCostumer.getNameType().equals("Bronze")) {
			typeOfCostumer.setRequestedPoints("50");
		} else if(typeOfCostumer.getNameType().equals("Silver")) {
			typeOfCostumer.setRequestedPoints("100");
		} else {
			typeOfCostumer.setRequestedPoints("0");
;
		}
	}
	
	public String generateID() {
		int id = 1;
		
		for(TypeOfCostumer typeOfCostumer : WebContext.getInstance().getTypeOfCostumers()) {
			int IDToCompare = Integer.parseInt(typeOfCostumer.getTypeOfCostumerID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}

}
