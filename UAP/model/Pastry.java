package model;

public abstract class Pastry {
	private String id;
	private String name;
	private String type;
	private int price;
	public abstract int getTotalPrice(int quantity);
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Pastry(String id, String name, String type, int price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	public Pastry() {
		// TODO Auto-generated constructor stub
	}

	
}
