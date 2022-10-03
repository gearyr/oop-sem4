import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Restaurant ristorante = new Restaurant();
	public Main() {
		int inp;
		do {
			System.out.println("ristorante gustoso");
			System.out.println("1. View all restaurant data");
			System.out.println("2. Input customer");
			System.out.println("3. Input rates");
			System.out.println("4. Exit");
			System.out.print(">> ");
			inp = scan.nextInt();
			
			switch (inp) {
			case 1:
				viewRestaurantData();
				break;
			case 2:
				String inputName;
				String inputGender;
				do {
					System.out.print("Input customer name: ");
					inputName = scan.next();
				}while(inputName.isEmpty());
				
				do {
					System.out.print("Input gender: ");
					inputGender = scan.next();
				}while(!inputGender.equalsIgnoreCase("Female") &&
						!inputGender.equalsIgnoreCase("Male"));
				
				
				ristorante.newCustomer(inputName, inputGender);
				break;
			case 3:
				int inputRate = 0;
				String inputComment;
				do {
					System.out.print("Input Rating: ");
					inputRate = scan.nextInt();
				}while(inputRate == 0);
				
				do {
					System.out.print("Input Comment: ");
					inputComment = scan.next();
				}while(inputComment.isEmpty());
				
				ristorante.newRating(inputRate, inputComment);
				break;
			}
		
		}while(inp != 4);
	}

	private void viewRestaurantData() {
		int input;
		do {
			System.out.println("ristorante gustoso");
			System.out.println("1. View menu");
			System.out.println("2. View Customer");
			System.out.println("3. View Rating");
			System.out.println("4. Back");
			System.out.print(">> ");
			input = scan.nextInt();
			
			switch (input) {
			case 1:
				ristorante.viewMenu();
				break;
			case 2:
				ristorante.viewCustomer();
				break;
			case 3:
				ristorante.viewRating();
				break;
			
			}
			
		} while (input != 4);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
