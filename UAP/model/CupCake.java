package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class CupCake extends Pastry{
	private String toppingName;
	Connect con = Connect.getConnection();
	public String getToppingName() {
		return toppingName;
	}

	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}

	public CupCake(String id, String name, String type, int price, String toppingName) {
		super(id, name, type, price);
		this.toppingName = toppingName;
	}

	public CupCake(String id, String name, int price, String toppingName) {
		super(id, name, "Cup Cake", price);
		this.toppingName = toppingName;
	}

	
	public CupCake() {
		// TODO Auto-generated constructor stub
	}

	public CupCake map(ResultSet rs) {
		String id, name, type, topName;
		int  price;
		
		try {
			id = rs.getString("PastryID");
			name = rs.getString("PastryName");
			type = rs.getString("PastryType");
			price = rs.getInt("PastryPrice");
			topName = rs.getString("ToppingName");
			return new CupCake(id, name, type, price, topName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<CupCake> getAll(){
		ArrayList<CupCake> cupcakes = new ArrayList<>();
		String query = "SELECT * FROM cup_cake";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				cupcakes.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cupcakes;
 	}

	@Override
	public int getTotalPrice(int quantity) {
		int totalPrice = (this.getPrice() * quantity) - 15000;
		return totalPrice;
	}

	
}
