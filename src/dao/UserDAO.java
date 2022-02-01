package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.Gender;
import beans.NameType;
import beans.Restaurant;
import beans.Role;
import beans.TypeOfCostumer;
import beans.User;
import beans.WebContext;

public class UserDAO {
	
	public ArrayList<User> getFreeManagers() {
		
		ArrayList<User> managers = new ArrayList<User>();
		
		for(User user: getUsersByRole(Role.Manager)) {
			if(isManagerFree(user)) {
				managers.add(user);
			}
		}
		
		return managers;
	}
	
	public ArrayList<User> getUsersByRole(Role role) {
		
		ArrayList<User> result = new ArrayList<User>();
		
		for(User user: WebContext.getInstance().getUsers()) {
			if(user.getRole().equals(role)) {
				result.add(user);
			}
		}
		
		
		return result;
	}
	
	public ArrayList<User> getAllUsers() {
		
		return WebContext.getInstance().getUsers();
		
	}
	
	public boolean isManagerFree(User user) {
		
		
		for(Restaurant restaurant: WebContext.getInstance().getRestaurants()) {
			
			if(restaurant.getManager() != null && restaurant.getManager().getUserID().equals(user.getUserID())) {
				return false;
			}
		}
		
		return true;
	}
	
	public User findByID(String id)
	{
		for(User u: WebContext.getInstance().getUsers())
		{
			if(u.getUserID().equals(id))
			{
				return u;
			}
		}
		return null;
	}
	
	public User getByUsernameAndPassword(String username, String password) {
		
		for(User user: WebContext.getInstance().getUsers()) {
			
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}	
		return null;
	}
	
	public String generateID() {
		int id = 1;
		
		for(User user : WebContext.getInstance().getUsers()) {
			int IDToCompare = Integer.parseInt(user.getUserID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	public void addNewUser(String username, String password, String fristName, String lastName, String gender, String date) throws ParseException {
		Gender usersGender;
		if(gender.equals("Male")) {
			usersGender=Gender.Male;
		}else {
			usersGender=Gender.Female;
		}
		
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		
		Date dateOfBirth = simpleDateFormat.parse(date);	
		Role role = Role.Buyer;
		String ID = generateID();
		
		TypeOfCostumerDAO typeOfCostumerDAO = new TypeOfCostumerDAO();
		
		
		TypeOfCostumer typeOfCostumer = new TypeOfCostumer();
		typeOfCostumer.setNameType(NameType.Bronze);
		typeOfCostumer.setRequestedPoints("0");
		typeOfCostumer.setDiscount(0.0);
		typeOfCostumer.setTypeOfCostumerID(typeOfCostumerDAO.generateID());
		
		User user = new User(ID, username,password,fristName,lastName,usersGender,dateOfBirth,role,"0",typeOfCostumer);
		WebContext.getInstance().getUsers().add(user);
		WebContext.getInstance().save();
	}
	
	public void addNewManagerOrDeliveryGuy(String username, String password, String fristName, String lastName, String gender, String date, String roleString) throws ParseException
	{
		String pointsCollected = "0";
		TypeOfCostumerDAO typeOfCostumerDAO = new TypeOfCostumerDAO();
		TypeOfCostumer typeOfCostumer = new TypeOfCostumer();
		typeOfCostumer.setNameType(NameType.Bronze);
		typeOfCostumer.setRequestedPoints("0");
		typeOfCostumer.setDiscount(0.0);
		typeOfCostumer.setTypeOfCostumerID(typeOfCostumerDAO.generateID());
		String ID = generateID();

		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
		
		Date dateOfBirth = simpleDateFormat.parse(date);	
	
		Role role = Role.Manager;
		
		if(roleString.equals("DeliveryGuy")) {
			role = Role.DeliveryGuy;
		}
		
		Gender usersGender;
		if(gender.equals("Male")) {
			usersGender=Gender.Male;
		}else {
			usersGender=Gender.Female;
		}
		
		
		User user = new User(ID, username,password,fristName,lastName,usersGender,dateOfBirth,role,pointsCollected,typeOfCostumer);
		
		WebContext.getInstance().getUsers().add(user);
		
		WebContext.getInstance().save();
		
	}
	
	public ArrayList<User> searchAllUsers(String search,String role,String typeOfBuyer) {
		ArrayList<User> result = new ArrayList<User>();
		
		String searchString = search == null ? "" : search.toLowerCase();
		String roleString = role == null ? "" : role.toLowerCase();
		String typeOfBuyerString = typeOfBuyer == null ? "" : typeOfBuyer.toLowerCase();
		
	
		
		for(User user : WebContext.getInstance().getUsers()) {
			

			if(!(user.getFirstName().toLowerCase().contains(searchString)
					|| user.getLastName().toLowerCase().contains(searchString)
					|| user.getUsername().toLowerCase().contains(searchString))) {
				continue;
			}
			
			
			if((!role.equals("") &&
					!user.getRole().toString().toLowerCase().equals(roleString))) {
				continue;
			}
			
			if((!typeOfBuyer.equals("") &&
					!user.getTypeOfCostumer().getNameType().toString().toLowerCase().equals(typeOfBuyerString))) {
				continue;
			}
			
			
			result.add(user);
		}
		return result;
	}

	public ArrayList<User> sortByFirstName(ArrayList<User> users) {
		users.sort((o1,o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
		return users;
	}

	public ArrayList<User> sortByLastName(ArrayList<User> users) {
		users.sort((o1,o2) -> o1.getLastName().compareTo(o2.getLastName()));
		return users;
	}
	
	public ArrayList<User> sortByUserName(ArrayList<User> users) {
		users.sort((o1,o2) -> o1.getUsername().compareTo(o2.getUsername()));
		return users;
	}
	
	public ArrayList<User> sortByPointsCollected(ArrayList<User> users) {
		users.sort((o1,o2) -> o1.getPointsCollected().compareTo(o2.getPointsCollected()));
		return users;
	}
}

