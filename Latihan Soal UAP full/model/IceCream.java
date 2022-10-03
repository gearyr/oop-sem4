package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class IceCream extends Dessert{
	private String creamName;
	Connect con = Connect.getConnection();
	
	public IceCream(int id, String name, String type, int price, String creamName) {
		super(id, name, type, price);
		this.creamName = creamName;
	}

	public String getCreamName() {
		return creamName;
	}

	public void setCreamName(String creamName) {
		this.creamName = creamName;
	}

	public IceCream() {
		// TODO Auto-generated constructor stub
	}

	public IceCream map(ResultSet rs) {
		int id, price;
		String name, type, ingredient;
		
		try {
			id = rs.getInt("DessertId");
			name = rs.getString("DessertName");
			type = rs.getString("DessertType");
			price = rs.getInt("DessertPrice");
			ingredient = rs.getString("CreamName");
			return new IceCream(id,name,type,price,ingredient);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public ArrayList<IceCream> getAll(){
		ArrayList<IceCream> iceCreams = new ArrayList<>();
		String query = "SELECT * FROM icecreams";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				iceCreams.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return iceCreams;
	}
	
	
}
