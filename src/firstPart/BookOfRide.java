package firstPart;

public class BookOfRide {
	public int IdOfDriver;
	public String IdOfCar;
	public int IdOfCustomer;
	private GPSLocation startingPoint;
	private GPSLocation endingPoint;
	public double lengthOfRide;
	private MyTime pickupTime;
	private MyTime arrivalTime;
	public GPSLocation getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(GPSLocation startingPoint) {
		this.startingPoint = startingPoint;
	}
	public GPSLocation getEndingPoint() {
		return endingPoint;
	}
	public void setEndingPoint(GPSLocation endingPoint) {
		this.endingPoint = endingPoint;
	}
	public MyTime getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(MyTime pickupTime) {
		this.pickupTime = pickupTime;
	}
	public MyTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(MyTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	

}
