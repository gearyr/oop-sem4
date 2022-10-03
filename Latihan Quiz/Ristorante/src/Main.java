import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	Restaurant ristorante = new Restaurant();
	public Main() {
		int inp;
		do {
			System.out.println("1. View all restaurant data.");
			System.out.println("2. Input new customer.");
			System.out.println("3. Input rates");
			System.out.println("4. Exit");
			System.out.print(">> ");
			inp = scan.nextInt();
			
			switch (inp) {
			case 1:
				viewRestaurantData();
				break;
			case 2:
				inputNewCustomer();
				break;
			case 3:
				inputRates();
				break;
			}
		}while(inp != 4);
		
	}

	private void inputRates() {
		String inputComment = null;
		int inputRate;
		do {
			System.out.println("Input the rating of the restaurant");
			System.out.print(">> ");
			inputRate = scan.nextInt();
			} while (inputRate < 1 || inputRate > 10);
		do {
			System.out.println("Input the comment of the restaurant");
			System.out.print(">> ");
			inputComment = scan.next();
		} while(inputComment.isEmpty());
		ristorante.addRating(inputComment, inputRate);
		System.out.println("Success input review's data, press enter to back...");
		scan.nextLine(); scan.nextLine();
	}

	private void inputNewCustomer() {
		String inputName, inputGender;
		do {
			System.out.println("Input the name of the customer");
			System.out.print(">> ");
			inputName = scan.next();
			} while(inputName.isEmpty());
		do {
			System.out.println("Input the gender of the customer");
			System.out.print(">> ");
			inputGender = scan.next(); scan.nextLine();
		} while (!inputGender.equalsIgnoreCase("Female") && !inputGender.equalsIgnoreCase("Male"));
		ristorante.addCustomer(inputName, inputGender);
		System.out.println("Success input user's data, press enter to back...");
		scan.nextLine();
	}

	private void viewRestaurantData() {
		int inputMenu;
		do {
			System.out.println("Ristorante Gustoso");
			System.out.println("1. View menus");
			System.out.println("2. View customers");
			System.out.println("3. View Ratings");
			System.out.println("4. Back");
			System.out.print(">> ");
			inputMenu = scan.nextInt();
			
			switch (inputMenu) {
			case 1:
				ristorante.viewMenus();
				scan.nextLine(); scan.nextLine();
				break;
			case 2:
				ristorante.viewCustomers();
				scan.nextLine(); scan.nextLine();
				break;
			case 3:
				ristorante.viewRatings();
				scan.nextLine(); scan.nextLine();
				break;
			}
		}while(inputMenu != 4);
	}

	public static void main(String[] args) {
		new Main();
	}

}
