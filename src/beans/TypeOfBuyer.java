package beans;

public class TypeOfBuyer {

	private String iD;
	private NameOfType nameOfType;
	private double discount;
	private String requestedPoints;
	
	public String exportToString()
	{
		return iD + '|' + nameOfType.toString() + '|' + discount + '|' + requestedPoints; 
	}
	
	public TypeOfBuyer(String iD, NameOfType nameOfType, double discount, String requestedPoints) {
		super();
		this.iD = iD;
		this.nameOfType = nameOfType;
		this.discount = discount;
		this.requestedPoints = requestedPoints;
	}
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public NameOfType getNameOfType() {
		return nameOfType;
	}
	public void setNameOfType(NameOfType nameOfType) {
		this.nameOfType = nameOfType;
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
	
}
