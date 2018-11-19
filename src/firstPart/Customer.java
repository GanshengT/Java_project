package firstPart;

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
		if (passengerNumRequested>=5 & passengerNumRequested <= 6) {
			System.out.printf("Your can choose a Van car for this ride, the price is: %g.\n"
					+ "If you want to order, please input 'ubervan'.", rideVan.price());
			rideType = "ubervan";
		}else if(passengerNumRequested >= 1 & passengerNumRequested <=4) {
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
	
		if(rideType == "uberx") {
			this.currentRide = rideX;
			return rideX;
		}else if(rideType == "uberblack") {
			this.currentRide = rideBlack;
			return rideBlack;
		}else if(rideType == "ubervan") {
			this.currentRide = rideVan;
			return rideVan;
		}else if (rideType == "uberpool") {
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
	
	
	
}
