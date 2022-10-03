import java.util.Random;

public abstract class Drive {
	Random rand = new Random();
	private String type;
	private String manufacturer;
	private int size;
	private String id;
	
	public abstract double getTotalPrice();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public Drive(String type, String manufacturer, int size) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.size = size;
		this.id = manufacturer.substring(0, 3).toUpperCase() + type + (rand.nextInt(100)+ 1) + size;
	}
	
	
	
}
