package firstPart;

public class Customer {
	
	private static int counter = 0;
	private String name;
	private String surName;
	private int idNum;
	private int rideNum = 0;
	private double onCarTime = 0;
	private double onCarMoney = 0;
	private GPSLocation gpsStart;
	
	public Customer(String name, String surName){
		counter++;
		this.name = name;
		this.surName = surName;
		this.idNum = counter;
	}

	
	/* whaterver */
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

	public int getRideNum() {
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

	public double getOnCarMoney() {
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
	
	/* get the amount of the customers registered*/
	public int getCounter() {
		return counter;
	}
	
	public Ride createANewRide(int passengerNumRequested, double desLongtude, double desLatitude, int startHH, int startMM) {
		MyTime startTime = new MyTime(startHH, startMM, 0);
		System.out.println("one request is sent");
		String rideType = "";
		GPSLocation gpsEnd = new GPSLocation(desLongtude, desLatitude);
		Ride rideX = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride rideBlack = new RideUberX(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride rideVan = new RideUberVan(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
		Ride ridePool = new RideUberPool(this, passengerNumRequested, this.gpsStart,gpsEnd, startTime);
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
			rideType = "uberx";
		}else {
			System.out.println("You have input a wrong passenger number.");
		}
	
		if(rideType == "uberx") {
			return rideX;
		}else if(rideType == "uberblack") {
			return rideBlack;
		}else if(rideType == "ubervan") {
			return rideVan;
		}else if (rideType == "uberpool") {
			return ridePool;
		}else {
			return rideError;
		}
		
		}
}
