import java.util.ArrayList;

public class View {
	public static void view() {
		ArrayList<Data> DataList = Main.DataList;
		if(DataList.isEmpty()) {
			System.out.println("There are no routes available.");
			System.out.println("Press Enter to continue..");
		}else {
			Main.garis();
			System.out.printf("|  %-5s|   %-17s| %-9s|    %-9s|\n","ID","To","Distance","Price");
			Main.garis();
			for (Data data : DataList) {
			System.out.printf("| %-6s| %-19s",data.getID(),data.getDestination());
			System.out.printf("| %-9s| Rp. %-8s|\n",data.getDistance(),(data.getDistance()/2*1000 + 10000));
		} Main.garis();
		}
		
	}
}
