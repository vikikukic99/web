package beans;


public class Comment {
	
	private String iD;
	private User user;
	private Restaurant restaurant;
	private String commentText;
	private Grade grade;

	public String exportToString()
	{
		return iD + '|' + user.toString() + '|' + restaurant.toString() + '|' + commentText + '|' + grade.toString(); 
	}
	
	public Comment(String iD, User user , Restaurant restaurant , String commentText, Grade grade) {
		super();
		this.iD = iD;
		this.user = user;
		this.restaurant = restaurant;
		this.commentText = commentText;
		this.grade = grade;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
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
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
