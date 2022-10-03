
public class Rating {
	private String comment;
	private int rate;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Rating(String comment, int rate) {
		super();
		this.comment = comment;
		this.rate = rate;
	}

}
