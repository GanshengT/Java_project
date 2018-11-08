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
	private double pricePerKmLessThanFive;
	private double pricePerKmFiveToTen;
	private double pricePerKmTenToTwenty;
	private double pricePerKmMoreThanTwenty;
	private int rideQuality;

	
	
	public Ride(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition) {
		super();
		this.customers = customers;
		this.passengerNum = passengerNum;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getPricePerKmLessThanFive() {
		return pricePerKmLessThanFive;
	}
	public void setPricePerKmLessThanFive(double pricePerKmLessThanFive) {
		this.pricePerKmLessThanFive = pricePerKmLessThanFive;
	}
	public double getPricePerKmFiveToTen() {
		return pricePerKmFiveToTen;
	}
	public void setPricePerKmFiveToTen(double pricePerKmFiveToTen) {
		this.pricePerKmFiveToTen = pricePerKmFiveToTen;
	}
	public double getPricePerKmTenToTwenty() {
		return pricePerKmTenToTwenty;
	}
	public void setPricePerKmTenToTwenty(double pricePerKmTenToTwenty) {
		this.pricePerKmTenToTwenty = pricePerKmTenToTwenty;
	}
	public double getPricePerKmMoreThanTwenty() {
		return pricePerKmMoreThanTwenty;
	}
	public void setPricePerKmMoreThanTwenty(double pricePerKmMoreThanTwenty) {
		this.pricePerKmMoreThanTwenty = pricePerKmMoreThanTwenty;
	}
	public int getRideQuality() {
		return rideQuality;
	}
	public void setRideQuality(int rideQuality) {
		this.rideQuality = rideQuality;
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
