import java.util.ArrayList;
import java.util.Scanner;

public class Update {
	public static Scanner scan = new Scanner(System.in);
	
	public static String inputNewDestination() {
		String inputDestination;
		do {
			System.out.print("Input new destination [Jakarta | Bogor | Depok | Tangerang | Bekasi] (case sensitive):");
			inputDestination = scan.nextLine();
		}while(inputDestination.compareTo("Jakarta") != 0 &&
				inputDestination.compareTo("Bogor") != 0 &&
				inputDestination.compareTo("Depok") != 0 &&
				inputDestination.compareTo("Tangerang") != 0 &&
				inputDestination.compareTo("Bekasi") != 0);
		return inputDestination;
	}
	
	public static int inputNewDistance() {
		int inputDistance;
		do {
			System.out.print("Input new distance [1...1000]:");
			inputDistance = scan.nextInt();
		}while(inputDistance < 1 || inputDistance > 1000);
		return inputDistance;
	}
	
	public static void update() {
		ArrayList<Data> DataList = Main.DataList;
		if(DataList.isEmpty()) {
			System.out.println("There are no routes available.");

		}else {
			View.view();
			String inputUpdate, newDestination;
			int dataFound = 0, newDistance;
			System.out.print("Input Route ID to update: ");
			inputUpdate = scan.nextLine();
			for (Data data : DataList) {
				if(data.getID().equals(inputUpdate)) {
					newDestination = inputNewDestination();					
					newDistance = inputNewDistance();
					dataFound = 1;
					data.setDestination(newDestination);
					data.setDistance(newDistance);
					System.out.println("Successfully updated Route "+ data.getID()+ "!");
					break;
				}					
			}
			if(dataFound == 0) {
				System.out.println("Route ID is invalid!");
			}
		}
		
	}
}
