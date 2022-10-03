public class HDD extends Drive {
	private int rpm;
	private int plate;

	public int getRpm() {
		return rpm;
	}


	public void setRpm(int rpm) {
		this.rpm = rpm;
	}


	public int getPlate() {
		return plate;
	}


	public void setPlate(int plate) {
		this.plate = plate;
	}


	public HDD(String type, String manufacturer, int size, int rpm, int plate) {
		super(type, manufacturer, size);
		this.rpm = rpm;
		this.plate = plate;
		
	}

	@Override
	public double getTotalPrice() {
		return (this.rpm / 10000 * 1.5) + (this.plate + 25) + (this.getSize()/4); 
	}

}
