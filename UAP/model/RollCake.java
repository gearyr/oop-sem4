package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class RollCake extends Pastry{
	public String fillingName;
	Connect con = Connect.getConnection();
	public RollCake(String id, String name, String type, int price, String fillingName) {
		super(id, name, type, price);
		this.fillingName = fillingName;
	}

	public String getFillingName() {
		return fillingName;
	}

	public void setFillingName(String fillingName) {
		this.fillingName = fillingName;
	}

	public RollCake(String id, String name, int price, String fillingName) {
		super(id, name, "Roll Cake", price);
		this.fillingName = fillingName;
	}
	
	public RollCake(int price) {
		super.setPrice(price);
	}
	
	public RollCake() {
		// TODO Auto-generated constructor stub
	}

	public RollCake map(ResultSet rs) {
		String id, name, type, topName;
		int  price;
		
		try {
			id = rs.getString("PastryID");
			name = rs.getString("PastryName");
			type = rs.getString("PastryType");
			price = rs.getInt("PastryPrice");
			topName = rs.getString("FillingName");
			return new RollCake(id, name, type, price, topName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<RollCake> getAll(){
		ArrayList<RollCake> rollcakes = new ArrayList<>();
		String query = "SELECT * FROM roll_cake";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				rollcakes.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rollcakes;
 	}

	@Override
	public int getTotalPrice(int quantity) {
		int totalPrice = (this.getPrice() * quantity) - 25000;
		return totalPrice;
	}
	
}
