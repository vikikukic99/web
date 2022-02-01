package beans;

public class Location
{
	private String locationID;
	private double geographicalLength;
   	private double geographicalWidth;
   	private String address;
   
   	
   	
public Location(String locationID, double geographicalLength, double geographicalWidth, String adress) {
		super();
		this.locationID = locationID;
		this.geographicalLength = geographicalLength;
		this.geographicalWidth = geographicalWidth;
		this.address = adress;
	}

public double getGeographicalLength() {
	return geographicalLength;
}
public void setGeographicalLength(double geographicalLength) {
	this.geographicalLength = geographicalLength;
}
public double getGeographicalWidth() {
	return geographicalWidth;
}
public String getLocationID() {
	return locationID;
}

public void setLocationID(String locationID) {
	this.locationID = locationID;
}

public void setGeographicalWidth(double geographicalWidth) {
	this.geographicalWidth = geographicalWidth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String ExportString() 
{
	return locationID + "|" + geographicalLength + "|" + geographicalWidth + "|" + address;
}

}
