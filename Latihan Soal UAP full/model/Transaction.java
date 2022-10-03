package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class Transaction {
	private String id;
	private Integer userId;
	private int dessertId;
	private int quantity;
	Connect con = Connect.getConnection();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDessertId() {
		return dessertId;
	}

	public void setDessertId(int dessertId) {
		this.dessertId = dessertId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Transaction(String id, Integer userId, int dessertId, int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.dessertId = dessertId;
		this.quantity = quantity;
	}

	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert() {
		String query = "INSERT INTO transactions VALUE (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, id);
			ps.setInt(2, userId);
			ps.setInt(3, dessertId);
			ps.setInt(4, quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Transaction map(ResultSet rs) {
		String id;
		Integer userId;
		int dessertId, quantity;
		
		try {
			id = rs.getString("TransactionId");
			userId = rs.getInt("UserId");
			dessertId = rs.getInt("DessertId");
			quantity = rs.getInt("quantity");
			return new Transaction(id, userId, dessertId, quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Transaction> loadTrans() {
		ArrayList<Transaction> tr = new ArrayList<>();
		String query = "SELECT * FROM transactions";
		ResultSet rs = con.executeQuery(query);
	
		try {
			while(rs.next()) {
				tr.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tr;
	}
}
