import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	private ArrayList<Game> gameList = new ArrayList<>();
	private ArrayList<Review> reviewList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);
	public void addGameList(String title, String genre, int price) {
		gameList.add(new Game(title, genre, price));
	}
	
	public void addReviewList(String comment, int rating) {
		reviewList.add(new Review(comment, rating));
	}
	
	public void viewGameList() {
		int i = 1;
		if(gameList.isEmpty()) {
			System.out.println("No game available.");
		}
		else {
			garis();
			System.out.printf("| %-3s| %-25s| %-19s| %-9s|\n","No.", "Game Title", "Genre", "Price");
			garis();
			for (Game game : gameList) {
				System.out.printf("| %-3d| %-25s| %-19s| %-9s|\n",i, game.getTitle(), game.getGenre(), game.getPrice());
				i++;
			}
			garis();
//			viewReview();
//			int inputNo;
//			do {
//				System.out.print("Choose game No. to view reviews ['0' to return]: ");
//				inputNo = scan.nextInt();
//				if(inputNo == 0) {
//					return;
//				}
//			} while (inputNo > gameList.size() || inputNo < gameList.size());
//			if(reviewList.isEmpty() || reviewList.get(inputNo - 1).equals(null)) {
//				System.out.println("No review for '" + gameList.get(inputNo - 1).getTitle() + "'");
//			}else {
//				System.out.println(reviewList.get(inputNo-1));
//			}
//			
		}
		
	}
	public void viewReview() {
		int inputNo;
		do {
			System.out.print("Choose game No. to view reviews ['0' to return]: ");
			inputNo = scan.nextInt();
			if(inputNo == 0) {
				return;
			}
		} while (inputNo > gameList.size() || inputNo < gameList.size());
		if(reviewList.isEmpty() || reviewList.get(inputNo - 1).equals(null)) {
			System.out.println("No review for '" + gameList.get(inputNo - 1).getTitle() + "'");
		}else {
			System.out.println(reviewList.get(inputNo-1).getComment() + " - " + reviewList.get(inputNo-1).getRating());
		}
		
	}
	
	public void garis() {
		for(int i = 0 ; i< 65 ; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}
	public void inputReview() {
		String inputComment;
		int inputRating, inputId = -1;
		if(gameList.isEmpty()) {
			return;
		}
		else {
			do {
				System.out.print("Choose game No. to add review ['0' to cancel]: ");
				inputId = scan.nextInt();
				if(inputId == 0) {
					break;
				}
				else {
						System.out.print("Input review: ");
						inputComment = scan.next();
						scan.nextLine();
					do {
						System.out.print("Set your rating [1-5] stars: ");
						inputRating = scan.nextInt();
					} while (inputRating < 1 || inputRating > 5);
					addReviewList(inputComment, inputRating);
					System.out.println("Review successfully added!");
				}
			}while(inputId == -1);
		}
		
	}
	
	public void removeGameList() {
		int inputId2;
		if(gameList.isEmpty()) {
			return;
		}
		else {
			System.out.print("Choose game No. to be removed ['0' to cancel]: ");
			inputId2 = scan.nextInt();
			if(inputId2 == 0) {
				return;
			}
			else {
				gameList.remove(inputId2-1);
				reviewList.remove(inputId2-1);

				
			}
			System.out.println("Game successfully removed!!");
		}

	}
	

	
	
}
