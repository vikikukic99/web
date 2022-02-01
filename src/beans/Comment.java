package beans;

public class Comment {

	private String commentID;
	private String text;
	private Grade grade;
	private User user;
	private Restaurant restaurant;
	private CommentStatus commentStatus;

	
	public CommentStatus getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Comment(String commentID, String text, Grade grade, User user, Restaurant restaurant) {
		super();
		this.commentID = commentID;
		this.text = text;
		this.grade = grade;
		this.user = user;
		this.restaurant = restaurant;
	}
	
	public Comment(String commentID, String text, Grade grade, User user, Restaurant restaurant, CommentStatus commentStatus) {
		super();
		this.commentID = commentID;
		this.text = text;
		this.grade = grade;
		this.user = user;
		this.restaurant = restaurant;
		this.commentStatus = commentStatus;
	
	}
	
	public String ExportString() 
	{
		return commentID + "|" + text + "|" + grade.toString() + "|" + user.getUserID() + "|" + restaurant.getRestaurantID() + "|" + commentStatus.toString();
	}
	
}
