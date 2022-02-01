package beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

	private String userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
	private Role role;
	private String pointsCollected;
	private TypeOfCostumer typeOfCostumer;
	private Restaurant restaurant;
	private ArrayList<Order> ordersForDeliveryMan;
	private ArrayList<Order> ordersForCostumer;
	private Cart cart;
	private Boolean isDelete;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPointsCollected() {
		return pointsCollected;
	}
	public void setPointsCollected(String pointsCollected) {
		this.pointsCollected = pointsCollected;
	}
	
	
	
	public Boolean getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public TypeOfCostumer getTypeOfCostumer() {
		return typeOfCostumer;
	}
	public void setTypeOfCostumer(TypeOfCostumer typeOfCostumer) {
		this.typeOfCostumer = typeOfCostumer;
	}
	public User(String userID, String username, String password, String firstName, String lastName, Gender gender,
			Date dateOfBirth, Role role, String pointsCollected, TypeOfCostumer typeOfCostumer) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
		this.pointsCollected = pointsCollected;
		this.typeOfCostumer = typeOfCostumer;
	}
	
	public User() {
		super();
	}
	
	public String ExportString() 
	{
		String costumerTypeString = "";
		if(typeOfCostumer!=null) {
			costumerTypeString = typeOfCostumer.getNameType().toString();
		}
		
		String convertDate = "yyyy-MM-dd";
		SimpleDateFormat simpleDateForm = new SimpleDateFormat(convertDate);
		
		String date = simpleDateForm.format(dateOfBirth);
		
		
		return userID + "|" + username + "|" + password + "|" + firstName + "|" + lastName + "|" + gender.toString() + "|" + date + "|" + role.toString() + "|" + pointsCollected + "|" + costumerTypeString;
	}
}
