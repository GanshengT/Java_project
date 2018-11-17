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
	
	/**
	 * this class record all the information of a book 
	 * and it will be recorded in myuber system
	 * @param idOfDriver
	 * @param idOfCar
	 * @param idOfCustomer
	 * @param startingPoint
	 * @param endingPoint
	 * @param lengthOfRide
	 * @param pickupTime
	 * @param arrivalTime
	 */
	public BookOfRide(int idOfDriver, String idOfCar, int idOfCustomer, GPSLocation startingPoint,
			GPSLocation endingPoint, double lengthOfRide, MyTime pickupTime, MyTime arrivalTime) {
		super();
		IdOfDriver = idOfDriver;
		IdOfCar = idOfCar;
		IdOfCustomer = idOfCustomer;
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.lengthOfRide = lengthOfRide;
		this.pickupTime = pickupTime;
		this.arrivalTime = arrivalTime;
	}
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
