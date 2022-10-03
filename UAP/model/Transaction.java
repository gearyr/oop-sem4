package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class Transaction {
	private String id;
	private String pastryId;
	private int quantity;
	Connect con = Connect.getConnection();
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	public Transaction(String id, String pastryId, int quantity) {
		super();
		this.id = id;
		this.pastryId = pastryId;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPastryId() {
		return pastryId;
	}
	public void setPastryId(String pastryId) {
		this.pastryId = pastryId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void insert() {
		String query = "INSERT INTO transaction VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, id);
			ps.setString(2, pastryId);
			ps.setInt(3, quantity);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Transaction map(ResultSet rs) {
		String id, pastryId;
		int  quantity;
		
		try {
			id = rs.getString("TransactionID");
			pastryId = rs.getString("PastryID");
			quantity = rs.getInt("Quantity");
			return new Transaction(id, pastryId, quantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<Transaction> getAll(){
		ArrayList<Transaction> transactions = new ArrayList<>();
		String query = "SELECT * FROM transaction";
		ResultSet rs = con.executeQuery(query);
		
		try {
			while(rs.next()) {
				transactions.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactions;
 	}
	
	public void delete() {
		String query = "DELETE FROM transaction WHERE TransactionID = ?";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
