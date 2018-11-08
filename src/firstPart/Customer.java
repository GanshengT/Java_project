package firstPart;

public class Customer {
	
	private static int counter = 0;
	private String name;
	private String surName;
	private int numN;
	private int idNum;
	private int rideNum = 0;
	private double onCarTime = 0;
	private double onCarMoney = 0;
	private GPSLocation gpsStart;
	
	public Customer(String name, String surName){
		counter++;
		numN = counter;
		this.name = name;
		this.surName = surName;
		this.idNum = numN;
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

	public int getNumN() {
		return numN;
	}

	public void setNumN(int numN) {
		this.numN = numN;
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
	
	public void requestForNewRide(int passengerNumRequested, double desLongtude, double desLatitude, double startTime) {
		System.out.println("one request is sent");
		}
}
