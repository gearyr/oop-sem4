import java.util.ArrayList;

public class Restaurant {
	private ArrayList<Food> foodList = new ArrayList<>();
	private ArrayList<Rating> ratingList = new ArrayList<>();
	private ArrayList<Customer> customerList = new ArrayList<>();
	
	public Restaurant() {
		foodList.add(new Food("gelato",85000));
		foodList.add(new Food("agliata",65000));
		foodList.add(new Food("pesto",35000));
	}
	
	public void addCustomer(String name, String gender) {
		customerList.add(new Customer(name,gender));
	}
	
	public void addRating(String comment, int rate) {
		ratingList.add(new Rating(comment,rate));
	}
	
	public void viewMenus() {
		int i = 1;
		for (Food food : foodList) {
			System.out.println(i+". " + food.getName() + " - " + food.getPrice());
			i++;
		}
	}
	
	public void viewCustomers() {
		if(customerList.isEmpty()) {
			System.out.println("No data");
		}else {
			int i = 1;
			for (Customer customer : customerList) {
				System.out.println(i+". " + customer.getName() + " - " + customer.getGender());
				i++;
			}
		}
		
	}
	
	public void viewRatings() {
		if(ratingList.isEmpty()) {
			System.out.println("No data");
		}else {
			int i = 1;
			for (Rating rate : ratingList) {
				System.out.println(i+". " + rate.getRate() + " - " + rate.getComment());
				i++;
			}
		}
	}
	
}
