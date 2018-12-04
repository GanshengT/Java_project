package myUberSystem;

import java.io.BufferedWriter;

import Rides.Ride;
import Rides.RideUberBlack;
import Rides.RideUberPool;
import Rides.RideUberVan;
import Rides.RideUberX;
import otherTools.GPSLocation;
import otherTools.MyTime;

public class Customer {
	
	/**
	 * We use attribute "counter" to calculate automatically the total amount of customers.
	 */
	private static int counter = 0;
	private String name;
	private String surName;
	private int idNum;
	private GPSLocation gpsStart;
	private Ride currentRide;
	/**
	 * We use the followings attributes to store the information of all the rides that a customer object has ordered.
	 */
	private Integer rideNum = 0;
	private double onCarTime = 0;
	private Double onCarMoney = 0.0;
	
	/**
	 * Constructor
	 * @param name
	 * @param surName
	 */
	public Customer(String name, String surName){
		counter++;
		this.name = name;
		this.surName = surName;
		this.idNum = counter;
	}
   
	/**
	 * We use this method in CLUI class(method: ask4pricer), in order to return a list of prices for 4 types of ride.
	 * @param desLongtude Destination's longitude
	 * @param desLatitude Destination's latitude
	 * @param startHH Ride start hour. If startHH < 0, we consider the system time as the ride start time.
	 */
	public void askForPrice(double desLongtude, double desLatitude, int startHH) {
		if(startHH < 0) {
			MyTime startTime = new MyTime();
			int passengerNumRequested = 1;
			GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
			Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			rideBlack.setTrafficState(rideX.getTrafficState());
			rideVan.setTrafficState(rideX.getTrafficState());
			ridePool.setTrafficState(rideX.getTrafficState());
			//Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
			System.out.printf("An UberX price is: %geuros.\n"
						+ "An UberBlack price is: %geuros.\n"
						+ "An UberVan price is: %geuros.\n"
						+ "An UberPool price is: %geuros.\n", 
						rideX.price(),rideBlack.price(),rideVan.price(),ridePool.price());
		}else if(startHH <= 23 && startHH >=0 ) {
		    MyTime startTime = new MyTime(startHH, 0, 0);

		    int passengerNumRequested = 1;
			GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
			Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			rideBlack.setTrafficState(rideX.getTrafficState());
			rideVan.setTrafficState(rideX.getTrafficState());
			ridePool.setTrafficState(rideX.getTrafficState());
			//Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
			System.out.printf("An UberX price is: %geuros.\n"
						+ "An UberBlack price is: %geuros.\n"
						+ "An UberVan price is: %geuros.\n"
						+ "An UberPool price is: %geuros.\n", 
						rideX.price(),rideBlack.price(),rideVan.price(),ridePool.price());
		}else {
			System.out.println("You have input a wrong time which is over 24 hours.");
			return;
		}
	}
	
	public void askForPrice(double desLongtude, double desLatitude, int startHH, BufferedWriter bw) {
		try {
		if(startHH < 0) {
			MyTime startTime = new MyTime();
			int passengerNumRequested = 1;
			GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
			Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			rideBlack.setTrafficState(rideX.getTrafficState());
			rideVan.setTrafficState(rideX.getTrafficState());
			ridePool.setTrafficState(rideX.getTrafficState());
			//Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
			bw.write("\r\naskForPrice:\r\n"+"Customer"+this.idNum+" wants to leave now, "+"an UberX price is: "+rideX.price()
						+ ", an UberBlack price is: "+rideBlack.price()
						+ ", an UberVan price is: "+rideVan.price()
						+ ", an UberPool price is: "+ridePool.price()+".\r\n");
		}else if(startHH <= 23 && startHH >=0 ) {
		    MyTime startTime = new MyTime(startHH, 0, 0);
		    int passengerNumRequested = 1;
			GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
			Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			rideBlack.setTrafficState(rideX.getTrafficState());
			rideVan.setTrafficState(rideX.getTrafficState());
			ridePool.setTrafficState(rideX.getTrafficState());
			//Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
			bw.write("\r\naskForPrice:\r\n"+"Customer"+this.idNum+" wants to leave at "+startHH+":00, "+"an UberX price is: "+rideX.price()
			+ ", an UberBlack price is: "+rideBlack.price()
			+ ", an UberVan price is: "+rideVan.price()
			+ ", an UberPool price is: "+ridePool.price()+".\r\n");
		}else {
			bw.write("A wrong time which is over 24 hours has been input, askForPrice failed.\r\n");
			return;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method used for a automatic ride.
	 * @param passengerNumRequested Total number of passengers in a ride
	 * @param desLongitude The coordinate of longitude of destination.
	 * @param desLatitude The coordinate of latitude of destination.
	 * @param startHH Ride beginning hour, if <0, we regard it as system current time.
	 * @param type Ride type that the customer want to order.
	 * @return
	 */
	public Ride createANewRideAuto(int passengerNumRequested, double desLongtude, double desLatitude, int startHH, int startMM, String type) {
		if(this.currentRide == null) {
			MyTime startTime;
			if(startHH < 0) {startTime = new MyTime();}
			else { startTime = new MyTime(startHH, startMM, 0);}
			String rideType = type;
			double price = 0;
			GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
			Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
			Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
			if (passengerNumRequested>=5 && passengerNumRequested <= 6 && rideType != "ubervan" ) {
				System.out.printf("Your can only choose a Van car for this ride, the price is: %g.\n", rideVan.price());
				this.currentRide = rideVan;
				price = rideVan.price();
				return rideVan;
			}else if(passengerNumRequested >= 1 & passengerNumRequested <=4) {
				if(rideType.equals("uberx")) {
					this.currentRide = rideX;
					price = rideX.price();
					return rideX;
				}else if(rideType.equals("uberblack")) {
					this.currentRide = rideBlack;
					price = rideBlack.price();
					return rideBlack;
				}else if(rideType.equals("ubervan")) {
					this.currentRide = rideVan;
					price = rideVan.price();
					return rideVan;
				}else if (rideType.equals("uberpool")) {
					this.currentRide = ridePool;
					price = ridePool.price();
					return ridePool;
				}else {
					System.out.println("You have input a wrong ride type, please choose from uberx, uberblack, ubervan, uberpool");
					return rideError;
				}
			}else {
				System.out.println("You have input a wrong passenger number.");
				return rideError;
			}
		
			}else {
				System.out.println("You have already ordered one ride in our system.");
				return null;
			}
	}
	
	/**
	 * We use this method of a customer object to request a new ride, and it will return a requested ride.
	 * @param passengerNumRequested 
	 * @param desLongtude 
	 * @param desLatitude
	 * @param startHH
	 * @param startMM
	 * @param type
	 * @return
	 */
	public Ride createANewRide(int passengerNumRequested, double desLongtude, double desLatitude, int startHH, int startMM,String type) {
		//waiting for a good update to trait exception.
		if(this.currentRide == null) {
		MyTime startTime = new MyTime(startHH, startMM, 0);
		System.out.println("one request is sent");
		String rideType = "";
		GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
		Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride rideBlack = new RideUberBlack(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		rideBlack.setTrafficState(rideX.getTrafficState());
		rideVan.setTrafficState(rideX.getTrafficState());
		ridePool.setTrafficState(rideX.getTrafficState());
		Ride rideError = new RideUberX(this,0,this.gpsStart, new GPSLocation(0,0),startTime);
		if (passengerNumRequested>=5 && passengerNumRequested <= 6) {
			System.out.printf("Your can choose a Van car for this ride, the price is: %g.\n"
					+ "If you want to order, please input 'ubervan'.", rideVan.price());
			rideType = "ubervan";
		}else if(passengerNumRequested >= 1 && passengerNumRequested <=4) {
			System.out.printf("An UberX price is: %geuros.\n"
					+ "An UberBlack price is: %geuros.\n"
					+ "An UberVan price is: %geuros.\n"
					+ "An UberPool price is: %geuros.\n"
					+ "Please input your choice.(\"uberx\" or \"uberblack\" or \"ubervan\" or \"uberpool\")\n", 
					rideX.price(),rideBlack.price(),rideVan.price(),ridePool.price());
			rideType = type;
		}else {
			System.out.println("You have input a wrong passenger number.");
		}
	
		if(rideType.equals("uberx")) {
			this.currentRide = rideX;
			return rideX;
		}else if(rideType.equals("uberblack")) {
			this.currentRide = rideBlack;
			return rideBlack;
		}else if(rideType.equals("ubervan")) {
			this.currentRide = rideVan;
			return rideVan;
		}else if (rideType.equals("uberpool")) {
			this.currentRide = ridePool;
			return ridePool;
		}else {
			return rideError;
		}}else {
			System.out.println("You have already ordered one ride in our system.");
			return null;
		}
		}
	
	/**
	 * We use this method to cancel a ride which is already accepted by a driver but the customer has not yet been on aboard.
	 */
	public void cancelBook() {
		this.currentRide.setState("canceled");
		/**
		 * need to add reassign in car class
		 */
		//this.currentRide.getCar().reAssignDriver;
	}
	
	/**
	 * We use this method to declare that the customer is on aboard and to change the ride state.
	 */
	public void aboard() {
		this.currentRide.setState("ongoing");
	}
	
	/**
	 * setter and getter
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public Integer getRideNum() {
		return rideNum;
	}

	public void setRideNum(int rideNum) {
		this.rideNum = rideNum;
	}

	public double getOnCarTime() {
		return onCarTime;
	}

	public void setOnCarTime(double onCarTime) {
		this.onCarTime = onCarTime;
	}

	public Double getOnCarMoney() {
		return onCarMoney;
	}

	public void setOnCarMoney(double onCarMoney) {
		this.onCarMoney = onCarMoney;
	}

	public GPSLocation getGpsStart() {
		return gpsStart;
	}

	public void setGpsStart(GPSLocation gpsStart) {
		this.gpsStart = gpsStart;
	}
	
	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}

	public static int getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " " + this.surName;
	}
	
	
	
	
}
