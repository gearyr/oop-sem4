

public class SSD extends Drive {
	private int nand;
	private String cache;
	
	public int getNand() {
		return nand;
	}

	public void setNand(int nand) {
		this.nand = nand;
	}


	public String getCache() {
		return cache;
	}


	public void setCache(String cache) {
		this.cache = cache;
	}

	public SSD(String type, String manufacturer, int size, int nand, String cache) {
		super(type, manufacturer, size);
		this.nand = nand;
		if(cache.equals("cache")) {
			this.cache = "True";
		}
		if(cache.equals("cacheless")) {
			this.cache = "False";
		}
	}

	@Override
	public double getTotalPrice() {
		double totalPrice = (this.nand * 3.75) + (this.getSize()/2);
		if(this.cache.equals("True")) {
			totalPrice += 20;
		}
		return totalPrice;
	}

}
