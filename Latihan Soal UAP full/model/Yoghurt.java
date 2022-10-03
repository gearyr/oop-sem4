package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class Yoghurt extends Dessert{
	private String probioticName;
	Connect con = Connect.getConnection();
	
	public Yoghurt(int id, String name, String type, int price, String probioticName) {
		super(id, name, type, price);
		this.probioticName = probioticName;
	}
	
	public String getProbioticName() {
		return probioticName;
	}

	public void setProbioticName(String probioticName) {
		this.probioticName = probioticName;
	}

	public Yoghurt() {
		// TODO Auto-generated constructor stub
	}
	
	public Yoghurt map(ResultSet rs) {
		int id, price;
		String name, type, ingredient;
		
		try {
			id = rs.getInt("DessertId");
			name = rs.getString("DessertName");
			type = rs.getString("DessertType");
			price = rs.getInt("DessertPrice");
			ingredient = rs.getString("ProbioticName");
			return new Yoghurt(id,name,type,price,ingredient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Yoghurt> getAll() {
		ArrayList<Yoghurt> yoghurts = new ArrayList<>();
 			
		String query = "SELECT * FROM yoghurts";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				yoghurts.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yoghurts;
	}

}
