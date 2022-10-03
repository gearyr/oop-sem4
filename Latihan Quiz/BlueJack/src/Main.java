import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static ArrayList<Data> DataList = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);
	
	public static void garis() {
		for(int i = 0 ; i< 55; i ++) {
			System.out.print("=");
		}System.out.println();
	}

	public Main() {
		int choice = 0;
		do {
			System.out.println("\nBlueJack Station");
			System.out.println("================");
			System.out.println("1. Insert route");
			System.out.println("2. View routes");
			System.out.println("3. Update route");
			System.out.println("4. Exit");
			System.out.print(">>");
			choice = scan.nextInt();
					
			switch(choice) {
			case 1:
				Input.input();
				scan.nextLine(); scan.nextLine();
				break;
			case 2:
				View.view();
				System.out.print("Press Enter to continue...");
				scan.nextLine(); scan.nextLine();
				break;
			case 3:
				Update.update();
				System.out.println("Press Enter to continue..");
				scan.nextLine(); scan.nextLine();
			default:
				break;
			}
		}while(choice !=4);
		
	}

	public static void main(String[] args) {
		new Main();
		}

}
