package beans;

public class Location {

	private String iD;
	private double geograficalLenght;
	private double geograficalWidth;
	private String adress;
	
	public String exportToString()
	{
		return iD + '|' + geograficalLenght + '|' + geograficalWidth + '|' + adress; 
	}
	
	public Location(String iD, double geograficalLenght, double geograficalWidth, String adress) {
		super();
		this.iD = iD;
		this.geograficalLenght = geograficalLenght;
		this.geograficalWidth = geograficalWidth;
		this.adress = adress;
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

	
	
}
