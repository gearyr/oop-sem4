package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.Connect;

public class User {
	private Integer id;
	private String name;
	private String email;
	private int age;
	Connect con = Connect.getConnection();
	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(Integer id, String name, String email, int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert() {
		String query = "INSERT INTO users VALUES(null,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, age);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getUserIdByEmail() {
		String query = "SELECT * FROM users WHERE UserEmail = ?";
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public User map(ResultSet rs) {
		int id, age;
		String name, email;
		
		try {
			id = rs.getInt("TransactionId");
			name = rs.getString("UserName");
			email = rs.getString("UserEmail");
			age = rs.getInt("UserAge");
			return new User(id, name, email, age);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<User> getAll() {
		ArrayList<User> users = new ArrayList<>();
		String query = "SELECT * FROM transactions";
		ResultSet rs = con.executeQuery(query);
	
		try {
			while(rs.next()) {
				users.add(map(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}
	
}
