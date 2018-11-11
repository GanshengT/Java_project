package firstPart;
import java.util.*;


public abstract class Ride {
	private static int counter = 0;
	private int rideId;
	private String rideType;
	public String getRideType() {
		return rideType;
	}

	public void setRideType(String rideType) {
		this.rideType = rideType;
	}


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
	//private double pricePerKmLessThanFive;
	//private double pricePerKmFiveToTen;
	//private double pricePerKmTenToTwenty;
	//private double pricePerKmMoreThanTwenty;
	private double priceToPay;
	private int rideQuality;
	private String trafficState;
	private String lengthType;
	private static double[] midnightCoef = {0.95,0.04,0.01};
	private static double[] morningCoef = {0.05,0.20,0.75};
	private static double[] afternoonCoef = {0.15,0.70,0.15};
	private static double[] eveningCoef = {0.01,0.04,0.95};
	private static Map<String, Double> trafficSpeedMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 15);
		put("mediumTraffic",(double)7.5);
		put("heavyTraffic",(double)3);}};
	
	//private static int[] midnightTime = {0,1,2,3,4,5,6,22,23};
	//private static int[] morningTime = {7,8,9,10};
	//private static int[] afternoonTime = {11,12,13,14,15,16};
	//private static int[] eveningTime = {17,18,19,20,21};
	//private double speed; speed = trafficSpeedMap.get(trafficState)
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
	
	public static double calculateDuration(double length, double speed) {
		return length/speed*60;
	}
	
	public MyTime returnEndTime(MyTime oneStartTime) {
		MyTime oneEndTime = startTime;
		oneEndTime.addTime(this.durationMin*60);
		return oneEndTime;
	}
	
	public Ride(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super();
		counter++;
		this.rideId =counter;
		this.customer = customer;
		this.passengerNum = passengerNum;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
		this.startTime = startTime;
		this.length = LocationUtils.GetDistance(startPosition, endPosition);
		this.trafficState = returnTrafficInfo(startTime);
		this.durationMin = calculateDuration(length, trafficSpeedMap.get(trafficState));
		this.endTime = returnEndTime(this.startTime);
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
	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	/**
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
	*/
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

	
	public abstract double price();
	
	
}
