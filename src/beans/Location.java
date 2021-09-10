package beans;

public class Location {

	private String iD;
	private double geograficalLenght;
	private double geograficalWidth;
	private String adress;
	private String city;
	private String country;
	
	public String exportToString()
	{
		return iD + '|' + geograficalLenght + '|' + geograficalWidth + '|' + adress + '|' + city + '|' + country; 
	}
	
	public Location()
	{
		
	}
	public Location(String iD, double geograficalLenght, double geograficalWidth, String adress, String city, String country) {
		super();
		this.iD = iD;
		this.geograficalLenght = geograficalLenght;
		this.geograficalWidth = geograficalWidth;
		this.adress = adress;
		this.city = city;
		this.country = country;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public double getGeograficalLenght() {
		return geograficalLenght;
	}
	public void setGeograficalLenght(double geograficalLenght) {
		this.geograficalLenght = geograficalLenght;
	}
	public double getGeograficalWidth() {
		return geograficalWidth;
	}
	public void setGeograficalWidth(double geograficalWidth) {
		this.geograficalWidth = geograficalWidth;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
	
}
