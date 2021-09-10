package dao;

import java.util.ArrayList;

import beans.ApplicationContext;
import beans.Artical;
import beans.ArticalType;
import beans.Comment;
import beans.Grade;
import beans.Restaurant;
import beans.User;

public class CommentDAO {
	
public String nextId() {
		
		int id = 0;
		
		for(Comment comment: ApplicationContext.getInstane().getComments()) {
			
			int idToCompare = Integer.parseInt(comment.getiD());
			
			if(idToCompare > id) {
				id = idToCompare;
			}
			
		}
		
		return Integer.toString(id + 1);
	}
	
	
	
	public void saveComment (User user, Restaurant restaurant, String commentText, Grade grade)
	{
		
		Grade gradesOfRestaurant;
		if(grade.equals("one"))
		{
			gradesOfRestaurant = Grade.one;
		}
		else if(grade.equals("two"))
		{
			gradesOfRestaurant = Grade.two;
		}
		else if(grade.equals("three"))
		{
			gradesOfRestaurant = Grade.three;
		}
		else if(grade.equals("Four"))
		{
			gradesOfRestaurant = Grade.four;
		}
		else
		{
			gradesOfRestaurant = Grade.five;
		}
		
		
		try {
		
		Comment comment = new Comment(nextId(), user, restaurant, commentText, grade);
			
			
			ApplicationContext.getInstane().getComments();
			ApplicationContext.getInstane().Save();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

