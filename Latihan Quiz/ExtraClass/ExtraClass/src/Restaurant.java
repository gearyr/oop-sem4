import java.util.Vector;

public class Restaurant {
	private Vector<Food> listFood = new Vector<>();
	private Vector<Customer> listCustomer = new Vector<>();
	private Vector<Rating> listRating = new Vector<>();
	public Restaurant() {
		listFood.add(new Food("Gelato", 85000));
		listFood.add(new Food("Pasta", 50000));
		listFood.add(new Food("Pizza", 100000));
	}
	
	public void viewMenu() {
		for (Food food : listFood) {
			System.out.println(food.getName()+ " - "+ food.getPrice());
		}
	}

	public void viewCustomer() {
		for (Customer cust : listCustomer) {
			System.out.println(cust.getName()+ " - "+ cust.getGender());
		}
	}
	
	public void newCustomer(String name, String gender) {
		listCustomer.add(new Customer(name, gender));
	}
	
	public void viewRating() {
		for (Rating rate : listRating) {
			System.out.println(rate.getRate()+ " - "+ rate.getComment());
		}
	}
	public void newRating(int rate, String comment) {
		listRating.add(new Rating(rate, comment));
	}
	
}
