package firstPart;
import java.util.*;

public abstract class Ride {
	private List<Customer> customers = new ArrayList<>();
	private Car car;
	private Driver driver;
	private String state;
	private int passengerNum;
	private double startTime;
	private double endTime;
	private double duration;
	private GPSLocation startPosition;
	private GPSLocation endPosition;
	private double length;
	private int rideQuality;
	
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPassengerNum() {
		return passengerNum;
	}
	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getEndTime() {
		return endTime;
	}
	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
	public GPSLocation getStartPosition() {
		return startPosition;
	}
	public void setStartPosition(GPSLocation startPosition) {
		this.startPosition = startPosition;
	}
	public GPSLocation getEndPosition() {
		return endPosition;
	}
	public void setEndPosition(GPSLocation endPosition) {
		this.endPosition = endPosition;
	}
	
	public abstract double price();
	
	
}
