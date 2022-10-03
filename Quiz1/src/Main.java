import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	Data data = new Data();
	public Main() {
		int inp;
		do {
			System.out.println("AD Game Stop");
			System.out.println("============\n");
			System.out.println("1. Add Game");
			System.out.println("2. View Game List");
			System.out.println("3. Add Review");
			System.out.println("4. Remove Game");
			System.out.println("5. Exit");
			System.out.print(">> ");
			inp = scan.nextInt(); scan.nextLine();
			
			switch (inp) {
			case 1:
				String inputTitle, inputGenre;
				int price;
				System.out.println("Adding new game");
				System.out.println("===============\n");
				do {
					System.out.print("Input game title [3..25 characters]: ");
					inputTitle = scan.nextLine();
				}while(inputTitle.length() < 3 || inputTitle.length() > 25);
				do {
					System.out.print("Input game genre [3..20 characters]: ");
					inputGenre = scan.next();
				} while (inputGenre.length() < 3 || inputGenre.length() > 20);

				price = (int)(Math.random()*10 + 9);
				
				data.addGameList(inputTitle, inputGenre, price);
				System.out.println("Game successfully added!");
				System.out.println("Press enter to continue...");
				scan.nextLine(); scan.nextLine();

				break;
			case 2:
				System.out.println("List of games:");
				System.out.println("==============\n");
				data.viewGameList();
				data.viewReview();
				System.out.println("Press enter to continue...");
				scan.nextLine(); scan.nextLine();

				break;
			case 3:
				System.out.println("Add new review");
				System.out.println("==============\n");
				data.viewGameList();
				data.inputReview();
				
				System.out.println("Press enter to continue...");
				scan.nextLine(); scan.nextLine();
				break;
			case 4:
				System.out.println("Remove Game");
				System.out.println("===========\n");
				data.viewGameList();
				data.removeGameList();
				System.out.println("Press enter to continue...");
				scan.nextLine(); scan.nextLine();
				break;
			}
		} while (inp != 5);
		
		
	}

	public static void main(String[] args) {
		
		new Main();
	}

}
