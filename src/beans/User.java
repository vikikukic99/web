package beans;

import java.util.Date;

public class User {

	private String iD;
	private String username;
	private String password;
	private String name;
	private String surname;
	private Gender gender;
	private Date birthDate;
	private Role role;
	private String nummberOfPoints;
	private TypeOfBuyer typeOfBuyer;
	
	public String exportToString()
	{
		return iD + '|' + username + '|' + password + '|' + name + '|' + surname + gender.toString() + '|' + birthDate.toString() + '|' + role.toString() + '|' + nummberOfPoints + '|' + (typeOfBuyer == null ? "" : typeOfBuyer.toString()); 
	}
	
	public User(String iD, String username, String password, String name, String surname, Gender gender, Date birthDate,
			Role role, String nummberOfPoints, TypeOfBuyer typeOfBuyer) {
		super();
		this.iD = iD;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthDate = birthDate;
		this.role = role;
		this.nummberOfPoints = nummberOfPoints;
		this.typeOfBuyer = typeOfBuyer;
	}
	
	public String getID() {
		return iD;
	}
	public void setID(String iD) {
		this.iD = iD;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getNummberOfPoints() {
		return nummberOfPoints;
	}
	public void setNummberOfPoints(String nummberOfPoints) {
		this.nummberOfPoints = nummberOfPoints;
	}

	public TypeOfBuyer getTypeOfBuyer() {
		return typeOfBuyer;
	}

	public void setTypeOfBuyer(TypeOfBuyer typeOfBuyer) {
		this.typeOfBuyer = typeOfBuyer;
	}
	
}
