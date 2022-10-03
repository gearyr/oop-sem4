
public class Customer {
	private String name;
	private String gender;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Customer(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

}
