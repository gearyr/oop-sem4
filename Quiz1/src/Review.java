
public class Review {
	private String comment;
	private int rating;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Review(String comment, int rating) {
		super();
		this.comment = comment;
		this.rating = rating;
	}
	
}
