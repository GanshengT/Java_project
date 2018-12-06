package Rides;
import java.util.*;

import Cars.Car;
import myUberSystem.Customer;
import myUberSystem.Driver;
import otherTools.GPSLocation;
import otherTools.LocationUtils;
import otherTools.MyTime;


public abstract class Ride {
	private String rideType;
	private Customer customer;
	private Car car;
	private Driver driver;
	private String state = "unconfirmed";
	private int passengerNum;
	private MyTime startTime;
	private MyTime endTime;
	private double durationMin;
	private GPSLocation startPosition;
	private GPSLocation endPosition;
	private double length;
	private double priceToPay;
	private String trafficState;
	private String lengthType;
	
	private Customer customer2;
	private int passengerNum2;
	private GPSLocation startPosition2;
	private GPSLocation endPosition2;
	private MyTime startTime2;
	private double length2;
	private String trafficState2;
	private String lengthType2;
	private double durationMin2;
	private MyTime endTime2;
	private double priceToPay2;
	private double cost;
	/**
	 * Some static attributes for calculation of traffic states.
	 */
	private static double[] midnightCoef = {0.95,0.04,0.01};
	private static double[] morningCoef = {0.05,0.20,0.75};
	private static double[] afternoonCoef = {0.15,0.70,0.15};
	private static double[] eveningCoef = {0.01,0.04,0.95};
	private static Map<String, Double> trafficSpeedMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 15);
		put("mediumTraffic",(double)7.5);
		put("heavyTraffic",(double)3);}};
		
	/**
	 * The first kind of constructor: to generate a simple rideX, a rideBlack, a rideVan or a ridePool for one customer.	
	 * @param customer
	 * @param passengerNum
	 * @param startPosition
	 * @param endPosition
	 * @param startTime
	 */
	public Ride(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
			super();
			this.customer = customer;
			this.passengerNum = passengerNum;
			this.startPosition = startPosition;
			this.endPosition = endPosition;
			this.startTime = startTime;
			this.length = LocationUtils.GetDistance(startPosition, endPosition);
			this.lengthType = Ride.returnLengthType(this.length);
			this.trafficState = returnTrafficInfo(startTime);
			this.durationMin = calculateDuration(length, trafficSpeedMap.get(trafficState));
			this.endTime = returnEndTime(this.startTime);
		}
	/**
	 * The second kind of constructor: especially for a ride pool of two customers.	
	 * @param customer
	 * @param passengerNum
	 * @param startPosition
	 * @param endPosition
	 * @param startTime
	 * @param customer2
	 * @param passengerNum2
	 * @param startPosition2
	 * @param endPosition2
	 * @param startTime2
	 */
	public Ride(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime,
				Customer customer2, int passengerNum2, GPSLocation startPosition2, GPSLocation endPosition2, MyTime startTime2) {
			super();
			this.customer = customer;
			this.passengerNum = passengerNum;
			this.startPosition = startPosition;
			this.endPosition = endPosition;
			this.startTime = startTime;
			this.length = LocationUtils.GetDistance(startPosition, endPosition);
			this.lengthType = Ride.returnLengthType(this.length);
			this.trafficState = returnTrafficInfo(startTime);
			this.durationMin = calculateDuration(length, trafficSpeedMap.get(trafficState));
			this.endTime = returnEndTime(this.startTime);
			this.customer2 = customer2;
			this.passengerNum2 = passengerNum2;
			this.startPosition2 = startPosition2;
			this.endPosition2 = endPosition2;
			this.startTime2 = startTime2;
			this.length2 = LocationUtils.GetDistance(startPosition2, endPosition2);
			this.lengthType2 = Ride.returnLengthType(this.length2);
			this.trafficState2 = this.trafficState;
			this.durationMin2 = calculateDuration(length2, trafficSpeedMap.get(trafficState2));
			this.endTime2 = returnEndTime2(this.startTime2);
			
		}
	/**
	 * Abstract method to calculate the total price for a ride considering the ride length and a traffic state		
	 * @return
	 */
	public abstract double price();
	
	/**
	 * Price calculation used for a UberPool ride of two customers
	 * @return
	 */
	public abstract double price2();	
	
	public static String returnLengthType(double length) {
		if(length>= 0 && length<= 5) {
			return "LessThanFive";
		}else if (length> 5 && length<= 10) {
		    return "FiveToTen";
		}else if (length> 10 && length<= 20) {
			return "TenToTwenty";
		}else if(length>20){
			return "MoreThanTwenty";
		}return "Error";																	
	}

	
	public static String returnTrafficInfo(MyTime startTime) {
		double[] currentCoef = new double[3];
		String m ;
		double randomNumber;
		
		if(startTime.getHH()>=7 && startTime.getHH()<= 10) {
			currentCoef =  morningCoef;
		}else if (startTime.getHH()>=11 && startTime.getHH()<= 16) {
			currentCoef = afternoonCoef;
		}else if (startTime.getHH()>=17 && startTime.getHH()<= 21) {
			currentCoef = eveningCoef;
		}else {
			currentCoef = midnightCoef;
		}
		  
	    randomNumber = Math.random();
	    if (randomNumber >= 0 && randomNumber <= currentCoef[0])  
	      {  
	       m = "lowTraffic";
	       return m;  
	      }  
	     else if (randomNumber >= currentCoef[0]  && randomNumber <= currentCoef[0] + currentCoef[1])  
	      {  
	    	 m = "mediumTraffic";
	    	 return m;  
	      }  
	     else if(randomNumber >= currentCoef[0] + currentCoef[1]  
	        && randomNumber <= currentCoef[0] + currentCoef[1]+ currentCoef[2])  
	      {  
	    	 m = "heavyTraffic";
	    	 return m;
	      }
		return m="error"; 
		
	}
	
	
	public MyTime returnEndTime(MyTime oneStartTime) {
		MyTime oneEndTime = new MyTime(oneStartTime.getHH(), oneStartTime.getMm(), oneStartTime.getSs());
		oneEndTime.addTime(this.durationMin*60);
		return oneEndTime;
	}
	
	public MyTime returnEndTime2(MyTime oneStartTime) {
		MyTime oneEndTime = new MyTime(oneStartTime.getHH(), oneStartTime.getMm(), oneStartTime.getSs());
		oneEndTime.addTime(this.durationMin2*60);
		return oneEndTime;
	}
	
	
	public static double calculateDuration(double length, double speed) {
		return length/speed*60;
	}
	
	/**
	 * Method used for seeking out the minimal pick-up/drop-off trajectory for a two customers UberPool ride
	 * @param car
	 */
	public void calculateLowestRideCost(Car car) {
		double c_p1 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition());
		double c_p2 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2());
		double p1_p2 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2());
		double d1_d2 = LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2());
		double p1_d1 = LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition());
		double p1_d2 = LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2());
		double p2_d1 = LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition());
		double p2_d2 = LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition2());;
		if(c_p1 < c_p2) {
			if(p2_d1< p2_d2) {
				this.setCost( c_p1 + p1_p2 + p2_d1 + d1_d2);
				this.setLength(p1_p2 + p2_d1);
				this.setLength2(p2_d1 + d1_d2);
				//return this.cost;		
			}else {
				this.setCost (c_p1 + p1_p2 + p2_d2 + d1_d2);
				this.setLength(p1_p2 + p2_d2 + d1_d2);
				//return this.cost;
			}
				
		}else {
			if(p1_d2<p1_d1) {
				this.setCost(c_p2 + p1_p2 + p1_d2 + d1_d2);
				this.setLength(p1_d2 + d1_d2);
				this.setLength2(p1_p2 + p1_d2);
				//return this.cost;		
			}else {
				this.setCost(c_p2 + p1_p2 + p1_d1 + d1_d2);
				this.setLength2(p1_p2 + p1_d1 + d1_d2);
				//return this.cost;
			}
		}
		this.trafficState = returnTrafficInfo( MyTime.getLaterTime(this.getStartTime(), this.getStartTime2()));	
	}
	
	
	/**
	 * getter and setter
	 * @return
	 */
	public static Map<String, Double> getTrafficSpeedMap() {
		return trafficSpeedMap;
	}

	public static void setTrafficSpeedMap(Map<String, Double> trafficSpeedMap) {
		Ride.trafficSpeedMap = trafficSpeedMap;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Customer getCustomer2() {
		return customer2;
	}

	public void setCustomer2(Customer customer2) {
		this.customer2 = customer2;
	}

	public int getPassengerNum2() {
		return passengerNum2;
	}

	public void setPassengerNum2(int passengerNum2) {
		this.passengerNum2 = passengerNum2;
	}

	public GPSLocation getStartPosition2() {
		return startPosition2;
	}

	public void setStartPosition2(GPSLocation startPosition2) {
		this.startPosition2 = startPosition2;
	}

	public GPSLocation getEndPosition2() {
		return endPosition2;
	}

	public void setEndPosition2(GPSLocation endPosition2) {
		this.endPosition2 = endPosition2;
	}

	public MyTime getStartTime2() {
		return startTime2;
	}

	public String getLengthType2() {
		return lengthType2;
	}

	public void setLengthType2(String lengthType2) {
		this.lengthType2 = lengthType2;
	}

	public void setStartTime2(MyTime startTime2) {
		this.startTime2 = startTime2;
	}

	public double getLength2() {
		return length2;
	}

	public void setLength2(double length2) {
		this.length2 = length2;
	}

	public String getTrafficState2() {
		return trafficState2;
	}

	public void setTrafficState2(String trafficState2) {
		this.trafficState2 = trafficState2;
	}

	public double getDurationMin2() {
		return durationMin2;
	}

	public void setDurationMin2(double durationMin2) {
		this.durationMin2 = durationMin2;
	}

	public MyTime getEndTime2() {
		return endTime2;
	}

	public void setEndTime2(MyTime endTime2) {
		this.endTime2 = endTime2;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getDuration() {
		return durationMin;
	}
	public void setDuration(double duration) {
		this.durationMin = duration;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
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
	public MyTime getStartTime() {
		return startTime;
	}
	public void setStartTime(MyTime startTime) {
		this.startTime = startTime;
	}
	public MyTime getEndTime() {
		return endTime;
	}
	public void setEndTime(MyTime endTime) {
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
	public double getDurationMin() {
		return durationMin;
	}

	public void setDurationMin(double durationMin) {
		this.durationMin = durationMin;
	}

	public double getPriceToPay() {
		return priceToPay;
	}

	public void setPriceToPay(double priceToPay) {
		this.priceToPay = priceToPay;
	}

	
	public double getPriceToPay2() {
		return priceToPay2;
	}

	public void setPriceToPay2(double priccToPay2) {
		this.priceToPay2 = priccToPay2;
	}

	public String getTrafficState() {
		return trafficState;
	}

	public void setTrafficState(String trafficState) {
		this.trafficState = trafficState;
	}
	public String getLengthType() {
		return lengthType;
	}

	public void setLengthType(String lengthType) {
		this.lengthType = lengthType;
	}
	public String getRideType() {
		return rideType;
	}
	public void setRideType(String rideType) {
		this.rideType = rideType;
	}
	

	
	
}
