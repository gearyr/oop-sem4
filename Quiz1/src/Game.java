
public class Game {
	private String title;
	private String genre;
	private int price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Game(String title, String genre, int price) {
		super();
		this.title = title;
		this.genre = genre;
		this.price = price;
	}
	
}
