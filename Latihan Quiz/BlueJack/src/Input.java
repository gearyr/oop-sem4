import java.util.ArrayList;
import java.util.Scanner;

public class Input {
	public static Scanner scan = new Scanner(System.in);
	
	public static String inputDestination() {
		String inputDestination;
		do {
			System.out.print("Input route destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive):");
			inputDestination = scan.nextLine();
		}while(inputDestination.compareTo("Jakarta") != 0 &&
				inputDestination.compareTo("Bogor") != 0 &&
				inputDestination.compareTo("Depok") != 0 &&
				inputDestination.compareTo("Tangerang") != 0 &&
				inputDestination.compareTo("Bekasi") != 0);
		return inputDestination;
	}
	
	public static int inputDistance() {
		int inputDistance;
		do {
			System.out.print("Input route distance [1...1000]:");
			inputDistance = scan.nextInt();
		}while(inputDistance < 1 || inputDistance > 1000);
		return inputDistance;
	}
	
	public static void input() {
		String inputDestination;
		ArrayList<Data> DataList = Main.DataList;
		inputDestination = inputDestination();
		
		int inputDistance;
		inputDistance = inputDistance();
		
		String ID = "BJ" + (int)(Math.random()*10) +(int)(Math.random()*10) + (int)(Math.random()*10);
		Data d = new Data(inputDestination, inputDistance, ID);
		
		DataList.add(d);
		System.out.println("\nSuccessfully added new route!");
		System.out.print("Press Enter to continue...");

	}
}
