package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.CupCake;
import model.Pastry;
import model.RollCake;
import model.Transaction;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Pastry> buyList = new ArrayList<>();
	public Main() {
		
		int input;
		do {
			System.out.println("Bakeroo");
			System.out.println("=======");
			System.out.println("1. Insert Transaction");
			System.out.println("2. View Transaction");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Exit");
			System.out.print(">> ");
			input = scan.nextInt();
			scan.nextLine();
			
			switch (input) {
			case 1:
				insertTransaction();
				break;
			case 2:
				viewTransaction();
				break;
			case 3:
				deleteTransaction();
				break;
			}
			
		} while (input != 4);
		
	}

	private void deleteTransaction() {
		Transaction t = new Transaction();
		ArrayList<Transaction> trList = new ArrayList<>();
		trList.addAll(t.getAll());
		if(trList.size() == 0) {
			System.out.println("There is no transaction...");
			enter();
		}else {
//			viewTransaction();
			String inputId;
			do {
				System.out.println("Input Transaction ID[must exist](Case insensitive): ");
				inputId = scan.next();
				scan.nextLine();
			} while (validateId(inputId.toUpperCase()));
		}
	}

	private boolean validateId(String id) {
		Transaction t = new Transaction();
		ArrayList<Transaction> trList = new ArrayList<>();
		trList.addAll(t.getAll());
		for (Transaction tr : trList) {
			if(tr.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}

	private void viewTransaction() {
		CupCake cc = new CupCake();
		RollCake rc =  new RollCake();
		ArrayList<Pastry> pa = new ArrayList<>();
		pa.addAll(cc.getAll());
		pa.addAll(rc.getAll());
		
		Transaction t = new Transaction();
		ArrayList<Transaction> trList = new ArrayList<>();
		trList.addAll(t.getAll());
		if(trList.size() == 0) {
			System.out.println("There is no transaction...");
			enter();
		}else {
			System.out.println("================================================================================================");
			System.out.println("|Transaction ID | Pastry Name | Pastry Type | Pastry Price | Quantity | Discount | Total Price |");
			System.out.println("================================================================================================");
			int i = 1;
			
			for (Transaction tr : trList) {
				System.out.printf("|%s |%s |%s |%d |%d |%d |%d |",
						tr.getId(), buyList.get(i).getName(), buyList.get(i).getType(), buyList.get(i).getPrice(),tr.getQuantity(),
						(buyList.get(i).getType().equals("Cup Cake")) ? "15000" : "25000"
						,buyList.get(i).getTotalPrice(tr.getQuantity()));
			}
		}
	}

	private void enter() {
		System.out.println("Press Enter to Continue...");
		scan.nextLine();
	}

	private void insertTransaction() {
		CupCake cc = new CupCake();
		RollCake rc =  new RollCake();
		ArrayList<Pastry> pa = new ArrayList<>();
		pa.addAll(cc.getAll());
		pa.addAll(rc.getAll());
		
		
		System.out.println("================================================");
		System.out.println("|No |ID |Name |Type |Price |Cream Name |");
		System.out.println("================================================");
		int i = 1;
		for (Pastry c : pa) {
			System.out.printf("|%d |%s |%s |%s |%d |%s |\n",
					i, c.getId(), c.getName(), c.getType(), c.getPrice(), (c instanceof CupCake)?((CupCake)c).getToppingName(): ((RollCake)c).getFillingName());
			i++;
		}
		int inputIndex;
		do {
			System.out.print("Input the number of index you want to buy[1..10]: ");
			inputIndex = scan.nextInt();
			scan.nextLine();
		} while (inputIndex < 1 || inputIndex > pa.size());
		int inputQuantity;
		do {
			System.out.print("Input quantity [>0]: ");
			inputQuantity = scan.nextInt(); scan.nextLine();
		} while(inputQuantity < 1);
		Pastry buy;
		if(pa.get(inputIndex-1).getType().equals("Cup Cake")) {
			buy = new CupCake(pa.get(inputIndex-1).getId(),pa.get(inputIndex-1).getName(),
					pa.get(inputIndex-1).getPrice(), ((CupCake)pa.get(inputIndex-1)).getToppingName());
		} else {
			buy = new RollCake(pa.get(inputIndex-1).getId(),pa.get(inputIndex-1).getName(),
					pa.get(inputIndex-1).getPrice(), ((RollCake)pa.get(inputIndex-1)).getFillingName());
		}
		buyList.add(buy);
		Transaction t = new Transaction();
		ArrayList<Transaction> trList = new ArrayList<>();
		trList.addAll(t.getAll());
		
		int transCtr = trList.size() + 1;
		String trId = String.format("PI%03d", transCtr);
		transCtr++;
		Transaction tr = new Transaction(trId, pa.get(inputIndex-1).getId(), inputQuantity);
		tr.insert();
		
		System.out.println("==========================");
		System.out.println("Detail Transaction");
		System.out.println("==========================");
		System.out.println("Transaction ID  : " + tr.getId() );
		System.out.println("Cake Name       : " + buy.getName());
		System.out.println("Cake Price      : " + buy.getPrice());
		System.out.println("Cake Quantity   : " + inputQuantity);
		System.out.print("Discount        : ");
		if(pa.get(inputIndex-1).getType().equals("Cup Cake")) {
			System.out.println("15000");
		} else {
			System.out.println("25000");
		}
		System.out.print("Total Price     : ");
		if(pa.get(inputIndex-1).getType().equals("Cup Cake")) {
			System.out.println(buy.getTotalPrice(inputQuantity));
		} else {
			System.out.println(buy.getTotalPrice(inputQuantity));
		}
		System.out.println("============================");
		enter();
	}

	public static void main(String[] args) {
		new Main();
	}
}
