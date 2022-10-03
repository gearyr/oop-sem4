
public class Rating {
	private int rate;
	private String comment;

	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Rating(int rate, String comment) {
		super();
		this.rate = rate;
		this.comment = comment;
	}

}
