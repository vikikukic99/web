package beans;

public class TypeOfCostumer 
{
	private String typeOfCostumerID;
	private NameType nameType;
	private double discount;
	private String requestedPoints;
  
	
	
	
public TypeOfCostumer(String typeOfCostumerID, NameType nameType, double discount, String requestedPoints) {
		super();
		this.typeOfCostumerID = typeOfCostumerID;
		this.nameType = nameType;
		this.discount = discount;
		this.requestedPoints = requestedPoints;
	}


public TypeOfCostumer() {
	// TODO Auto-generated constructor stub
}


public String getTypeOfCostumerID() {
	return typeOfCostumerID;
}


public void setTypeOfCostumerID(String typeOfCostumerID) {
	this.typeOfCostumerID = typeOfCostumerID;
}


public NameType getNameType() {
	return nameType;
}
public void setNameType(NameType nameType) {
	this.nameType = nameType;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public String getRequestedPoints() {
	return requestedPoints;
}
public void setRequestedPoints(String requestedPoints) {
	this.requestedPoints = requestedPoints;
}
 
	public String ExportString() 
	{
		return typeOfCostumerID + "|" + nameType.toString() + "|" + discount + "|" + requestedPoints;
	}

}
