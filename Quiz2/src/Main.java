import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Drive> driveList = new ArrayList<>();
	public Main() {
		int input;
		do {

			input = menu();
			switch (input) {
			case 1:
				System.out.println("");
				System.out.println("Add Drive");
				System.out.println("==============");
				String inputType;
				do {
					System.out.print("Select drive type [HDD | SSD]: ");
					inputType = scan.nextLine();
				} while (!inputType.equals("HDD") && !inputType.equals("SSD"));
				String inputManuf;
				do {
					System.out.print("Input manufacturer name [5..25]: ");
					inputManuf = scan.nextLine();
				} while (inputManuf.length() < 5 || inputManuf.length() > 25);
				int inputSize;
				do {
					System.out.print("Input drive size [256 | 512 | 1024 | 2048] GB: ");
					inputSize = scan.nextInt(); scan.nextLine();
				} while (inputSize != 256 && inputSize != 512 && inputSize != 1024 && inputSize != 2048);
				
				if(inputType.equals("HDD")) {
					int inputRPM;
					do {
						System.out.print("Input drive's ration speed (RPM) [5200 - 10000]: ");
						inputRPM = scan.nextInt(); scan.nextLine();
					} while (inputRPM < 5200 || inputRPM > 10000);
					int inputPlate;
					do {
						System.out.print("Input no. of disk plate [5 - 12]: ");
						inputPlate = scan.nextInt(); scan.nextLine();
					} while (inputPlate < 5 || inputPlate > 12);
					driveList.add(new HDD(inputType, inputManuf, inputSize, inputRPM, inputPlate));
				} else if (inputType.equals("SSD")) {
					int inputNand;
					do {
						System.out.print("Input NAND type [1 - 4]: ");
						inputNand = scan.nextInt(); scan.nextLine();
					} while (inputNand < 1 || inputNand > 4);
					String inputCache;
					do {
						System.out.print("Input cache type [cache | cacheless]: ");
						inputCache = scan.nextLine();
					} while (!inputCache.equals("cache") && !inputCache.equals("cacheless"));
					driveList.add(new SSD(inputType, inputManuf, inputSize, inputNand, inputCache));
				}
				System.out.println("Drive successfully added!");
				System.out.print("Press enter to continue...");
				scan.nextLine();
				break;
			case 2:
				System.out.println("List of drives");
				System.out.println("==============");
				System.out.println("");
				if(driveList.isEmpty()) {
					System.out.println("No drive available");
				} else {
					System.out.println("(HDD)");
					for (Drive drive : driveList) {
						if(drive instanceof HDD) {
							int i = 1;
							garis();
							System.out.printf("| %-3s| %-19s| %-14s| %-14s| %-6s| %-14s|\n","No", "Manufacturer", "Part ID", "Drive Size", "RPM", "Disk Plates");
							garis();
							System.out.printf("| %-3d| %-19s| %-14s| %10d GB | %-6d| %14d|\n",i,drive.getManufacturer(),drive.getId(),drive.getSize(),((HDD)drive).getRpm(),((HDD)drive).getPlate());
							garis();
							i++;
						}
						System.out.println();
					}
					System.out.println("(SSD)");
					for (Drive drive : driveList) {
						if(drive instanceof SSD) {
							int i = 1;
							garis();
							System.out.printf("| %-3s| %-19s| %-14s| %-14s| %-6s| %-14s|\n","No", "Manufacturer", "Part ID", "Drive Size", "Cache", "NAND Type");
							garis();
							System.out.printf("| %-3d| %-19s| %-14s| %10d GB | %-6s| %14d|\n",i,drive.getManufacturer(),drive.getId(),drive.getSize(),((SSD)drive).getCache(),((SSD)drive).getNand());
							garis();
							i++;
						}
					}	
					System.out.println();
				}
				System.out.printf("\n\nPress Enter to continue...");
				scan.nextLine();
				break;
			case 3:
				System.out.println("Remove Drive");
				System.out.println("============");
				System.out.println("");
				if(driveList.isEmpty()) {
					System.out.println("No drive available.");
				}else {
					showList();
					int inputRemove;
					System.out.print("Choose drive No. to be removed: ");
					inputRemove = scan.nextInt(); scan.nextLine();
					driveList.remove(inputRemove-1);
					System.out.println("Drive successfully removed!!");
				}
				System.out.print("Press Enter to continue...");
				scan.nextLine();
				break;
			case 4:
				System.out.println("Buy Drive");
				System.out.println("=========");
				if(driveList.isEmpty()) {
					System.out.println("No drive available.");
				} else {
					showList();
					int inputBuy;
					System.out.print("Select drive No. : ");
					inputBuy = scan.nextInt(); scan.nextLine();
					System.out.println("");
					System.out.println("Drive price (USD): " + driveList.get(inputBuy-1).getTotalPrice());
					System.out.println("Thank you for the purchase!");
				}
				System.out.print("Press Enter to continue...");
				scan.nextLine();
				break;
			}			
		} while (input != 5);
	}

	private void showList() {
		System.out.println("List of drives");
		System.out.println("==============");
		garisRemove();
		System.out.printf("| %-3s| %-19s| %-14s| %-14s|\n","No", "Manufacturer", "Part ID", "Drive Size");
		garisRemove();
		for (Drive drive : driveList) {
			int i = 1;
			System.out.printf("| %-3d| %-19s| %-14s| %10d GB |\n",i, drive.getManufacturer(), drive.getId(), drive.getSize());
			i++;
		}
		garisRemove();
	}

	private void garisRemove() {
		for(int i = 0; i<59 ;i++) {
			System.out.print("=");
		}
		System.out.println("");
	}

	private void garis() {
		for(int i = 0 ; i < 83 ; i++) {
			System.out.print("=");
		}
		System.out.println("");
	}

	private int menu() {
		int input;
		System.out.println("AD Drive Store");
		System.out.println("==============");
		System.out.println("1. Add Drive");
		System.out.println("2. View Drives");
		System.out.println("3. Remove Drive");
		System.out.println("4. Buy");
		System.out.println("5. Exit");
		System.out.print("Choose [1-5]: ");
		input = scan.nextInt();
		scan.nextLine();
		return input;
	}

	public static void main(String[] args) {
		new Main();
	}

}
