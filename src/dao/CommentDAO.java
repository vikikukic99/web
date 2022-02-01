package dao;

import java.util.ArrayList;

import beans.Artical;
import beans.Comment;
import beans.CommentStatus;
import beans.Grade;
import beans.Restaurant;
import beans.User;
import beans.WebContext;

public class CommentDAO {
	
	public Comment findByID(String id) {
		for(Comment comment : WebContext.getInstance().getComments()) {			
		if(comment.getCommentID().equals(id)) {
				return comment;
			}
		}
	return null;
	}
	
	public void getAverageGrade()
	{
		ArrayList<Comment> grades = new ArrayList<Comment>();
	}
	
	public String generateID() {
		int id = 1;
		
		for(Comment comment : WebContext.getInstance().getComments()) {
			int IDToCompare = Integer.parseInt(comment.getCommentID());
			
			if(IDToCompare > id) {
				id = IDToCompare;
			}
		}
		return Integer.toString(id+1);
	}
	
	public ArrayList<Comment> ApprovedComment(String id) {
		
		ArrayList<Comment> result = new ArrayList<Comment>();
		
		for(Comment comment : WebContext.getInstance().getComments()) {
			if(comment.getRestaurant().getRestaurantID().equals(id) && comment.getCommentStatus().equals("Approved") ) {
					result.add(comment);
			}
		}	
		return result;
	}
	
	public ArrayList<Comment> NotApprovedComment(String id) {
		
		ArrayList<Comment> result = new ArrayList<Comment>();
		
		for(Comment comment : WebContext.getInstance().getComments()) {
				if(comment.getCommentStatus().equals("Not_approved")) {
					result.add(comment);
				}
			}	
		return result;
	}

	public void saveComment(String id, String text, String grade, User user, Restaurant restaurant) {
		Grade gradee;
		if(grade.equals("1")) {
			gradee = Grade.one;
		}else if(grade.equals("2")) {
			gradee = Grade.two;
		}else if(grade.equals("3")){
			gradee = Grade.three;
		}else if(grade.equals("4")) {
			gradee = Grade.four;
		}else {
			gradee = Grade.five;
		}
			
		Comment comment = new Comment(id, text, gradee, user, restaurant,CommentStatus.On_review);
				
		WebContext.getInstance().getComments().add(comment);
		WebContext.getInstance().save();
		return;
		
	}
	
}
