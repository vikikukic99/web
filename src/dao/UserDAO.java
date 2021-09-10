package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.ApplicationContext;
import beans.Gender;
import beans.Role;
import beans.TypeOfBuyer;
import beans.User;

public class UserDAO {
	
	public ArrayList<User> getMenagers() {
		
		ArrayList<User> users = new ArrayList<User>();
		
		for(User user: ApplicationContext.getInstane().getUsers()) 
		{
			if(user.getRole().equals(Role.menager)) {
				users.add(user);
			}
		}
		
		return users;
	}
	
	public String nextId() {
		
		int id = 0;
		
		for(User user: ApplicationContext.getInstane().getUsers()) {
			
			int idToCompare = Integer.parseInt(user.getID());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
			
		}
		
		return Integer.toString(id + 1);
	}

	public User findById(String id)
	{
		for(User u: ApplicationContext.getInstane().getUsers())
		{
			if(u.getID().equals(id))
			{
				return u;
			}
		}
		return null;
	}

	public User getByUsernameAndPassword(String username, String password)
	{
		for(User user: ApplicationContext.getInstane().getUsers())
		{
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				return user;
			}
		}
		
		return null;
	}
	
	public void saveUser (String username, String password, String name, String surname, String gender, String dateOfBirth, Role role, String nummberOfPoints, String typeOfBuyerID )
	{
		Gender userGender;
		if(gender.equals("Male"))
		{
			userGender = Gender.Male;
		}
		else
		{
			userGender = Gender.Female;
		}
		
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date;
		try {
			date = simpleDateFormat.parse(dateOfBirth);
			TypeOfBuyerDAO typeOfBuyerDAO = new TypeOfBuyerDAO();
			TypeOfBuyer typeOfBuyer = typeOfBuyerDAO.findById(typeOfBuyerID);
			
			User user = new User(nextId(), username, password, name, surname, userGender, date,
					 role, nummberOfPoints, typeOfBuyer);
			
			
			ApplicationContext.getInstane().getUsers().add(user);
			ApplicationContext.getInstane().Save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}
