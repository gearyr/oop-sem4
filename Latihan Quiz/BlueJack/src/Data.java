public class Data{
	private String destination;
	private int Distance;
	private String ID;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return Distance;
	}
	public void setDistance(int distance) {
		Distance = distance;
	}
	
	public Data(String destination, int distance, String ID) {
		super();
		this.destination = destination;
		Distance = distance;
		this.ID = ID;
	}
	
}
