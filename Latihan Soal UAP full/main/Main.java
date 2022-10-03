package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connect.Connect;
import model.IceCream;
import model.Transaction;
import model.User;
import model.Yoghurt;

public class Main {
	Scanner scan = new Scanner(System.in);
	Connect con = Connect.getConnection();
	ArrayList<Transaction> transList = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	Arraylist<Dessert> desserList = new ArrayList<>();
	
	public Main() {
		int input;
		do {
			transList.clear();
			System.out.println("Binus Dessert Check");
			System.out.println("=========================");
			System.out.println("1. View All Transactions");
			System.out.println("2. Buy Dessert");
			System.out.println("3. Delete Transaction");
			System.out.println("4. Exit");
			System.out.print("Choose : ");
			input = scan.nextInt();
			scan.nextLine();
			switch (input) {
			case 1:
				viewTrans();
				break;
			case 2:
				buyDessert();
				break;
			case 3:

				break;
			}
		} while (input != 4);
	}

	private void buyDessert() {
		// TODO Auto-generated method stub
		System.out.println("Buy Dessert");
		System.out.println("============");
		String inputName;
		do {
			System.out.print("Input your name [must more than 5 characters]: ");
			inputName = scan.next(); scan.nextLine();
		} while (inputName.length() < 5);
		String inputEmail;
		do {
			System.out.print("Input your email [must contains '@' and ends with '.com']: ");
			inputEmail = scan.next(); scan.nextLine();
		} while(!inputEmail.contains("@") || !inputEmail.endsWith(".com"));
		int inputAge;
		do {
			System.out.print("Input your age [must greater than 0]: ");
			inputAge = scan.nextInt(); scan.nextLine();
		} while (inputAge < 1);
		
		User u = new User(null, inputName, inputEmail, inputAge);
		if(u.getUserIdByEmail() == 0) {
			userList.add(u);
			u.insert();
		}

		displayMenu();
		
		int inputDessert;
		do {
			System.out.print("Choose your dessert [1-10] : ");
			inputDessert = scan.nextInt();
			scan.nextLine();
		} while (inputDessert < 1 || inputDessert > 10);
		int inputQuantity;
		do {
			System.out.print("Input Quantity [must greater than 0]: ");
			inputQuantity = scan.nextInt(); scan.nextLine();
		} while(inputQuantity < 1);
		int transactionCtr = 1;
//		u.getAll();
		String trId = "TR" + String.format("%03d", transactionCtr);
		Transaction tr = new Transaction(trId, u.getId(), inputDessert, inputQuantity);
		System.out.println(u.getId());
		tr.insert();
		transactionCtr++;
		
		System.out.println("===================");
		System.out.println("Detail Transaction");
		System.out.println("===================");
		System.out.println("|Name | ");
	}

	private void displayMenu() {
		// TODO Auto-generated method stub
		IceCream icList = new IceCream();
		Yoghurt yogList = new Yoghurt();
		System.out.println("======================");
		System.out.println("List Dessert");
		System.out.println("======================");
		System.out.println("|ID| Name | Type | Price | Ingredients |");
		for (IceCream ic : icList.getAll()) {
			System.out.printf("|%d| %s| %s | %d | %s |\n",
					ic.getId(), ic.getName(), ic.getType(), ic.getPrice(), ic.getCreamName());
		}
		for (Yoghurt yog : yogList.getAll()) {
			System.out.printf("|%d| %s| %s | %d | %s |\n",
					yog.getId(), yog.getName(), yog.getType(), yog.getPrice(), yog.getProbioticName());
		}
		
	}

	private void viewTrans() {
		Transaction trans = new Transaction();
		transList = trans.loadTrans();
		System.out.println("========================");
		System.out.println("  All Transaction List  ");
		System.out.println("========================");
		if(transList.isEmpty()) {
			System.out.println("No Transaction");
		}
		else {
			int i = 1;
			for (Transaction tr : transList) {
				System.out.printf("| %d | %s | %d | %d | %d | totalPrice |\n",
						i, tr.getId(), tr.getUserId(), tr.getDessertId(), tr.getQuantity());
				i++;
			}
		}
		System.out.println("========================");
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	
	
}
