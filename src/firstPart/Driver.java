package firstPart;


import java.util.*;

public class Driver {
	
	/**
	 * attributes field
	 * 	startOnduty endOnDuty averageMark occupiedRate;
	are used to calculate the statistics
	 */
	private String name;
	private String surName;
	private int driverId;
	private String status;
	private MyTime startOnduty;
	private MyTime endOnDuty;
	private List<Integer> listOfMark = new ArrayList<>();
	private Double averageMark = (double) 0;
	private Double OndutyTime=0.0;
	private double onARideTime = 0.0;
	private Double occupiedRate;
	
	/**
	 * ownership= true means it has its own car
	 */
	private Boolean ownership;
	private static int counter = 0;
	private int rideNum;
	private double moneyCashed;

	/**
	 * if ownership is True, we will add a new car in the list in main method of test class
	 * @param name
	 * @param surName
	 * @param driverId
	 * @param status
	 * @param owneship
	 */
	
	/**
	 * getters and setters
	 * @return
	 */
	public MyTime getEndOnDuty() {
		return endOnDuty;
	}

	public void setEndOnDuty(MyTime endOnDuty) {
		this.endOnDuty = endOnDuty;
	}

	public MyTime getStartOnduty() {
		return startOnduty;
	}

	public void setStartOnduty(MyTime startOnduty) {
		this.startOnduty = startOnduty;
	}

	public Double getOndutyTime() {
		return OndutyTime;
	}

	public void setOndutyTime(double ondutyTime) {
		OndutyTime = ondutyTime;
	}
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

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getStatus() {
		return status;
	}

	/**
	 * automatically calculate in duty time
	 * each time the driver switch to onduty
	 * startondutytime note the begining time
	 * when he switch to other status, the duration will be recorded in ondutytime
	 * @param status
	 */
	public void setStatus(String status) {

		if (status=="on-duty") {
			if(this.status == "on-duty" || this.status == "on-a-ride") {
				this.status = "on-duty";
			}else {
			this.status = "on-duty";
			this.startOnduty = new MyTime();
			}
		}
		else if(status == "off-duty" ) {
			if(this.status == "on-duty" || this.status == "on-a-ride") {
				this.status = "off-duty";
				this.endOnDuty= new MyTime();
				this.OndutyTime+=this.getStartOnduty().timeMinus(this.endOnDuty);
			}else {
			this.status = "off-duty";		
			}
		}
		else if(status == "offline"){
			if(this.status == "on-a-ride" || this.status == "on-duty") {
				this.status = "offline";
				this.endOnDuty= new MyTime();
				this.OndutyTime+=this.getStartOnduty().timeMinus(this.endOnDuty);	
			}else {
			this.status = "offline";
			}
		}else if(status == "on-a-ride") {
			this.status = "on-a-ride";
		}
	}

	public Boolean getOwnership() {
		return ownership;
	}

	public void setOwnership(Boolean ownership) {
		this.ownership = ownership;
	}

	public int getRideNum() {
		return rideNum;
	}

	public void setRideNum(int rideNum) {
		this.rideNum = rideNum;
	}

	public double getMoneyCashed() {
		return moneyCashed;
	}

	public void setMoneyCashed(double moneyCashed) {
		this.moneyCashed = moneyCashed;
	}
	public List<Integer> getListOfMark() {
		return listOfMark;
	}

	public void setListOfMark(List<Integer> listOfMark) {
		this.listOfMark = listOfMark;
	}

	public Double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	public double getOnARideTime() {
		return onARideTime;
	}

	public void setOnARideTime(double onARideTime) {
		this.onARideTime = onARideTime;
	}

	public Double getOccupiedRate() {
		return occupiedRate;
	}

	public void setOccupiedRate(double occupiedRate) {
		this.occupiedRate = occupiedRate;
	}
	



	
	/**
	 * when ride finish, driver ask the appreciation mark from customers
	 * @param mark
	 */
	public void askMark(int mark) {
		this.getListOfMark().add(mark);	
		double sum = 0;
		for (int m : this.getListOfMark()) {
			sum += m;
		}
		this.averageMark = sum/(this.getListOfMark().size());
	}
	
	/**
	 * driver constructor
	 * @param name
	 * @param surName
	 * @param ownership
	 */
	public Driver(String name, String surName, Boolean ownership) {
		super();
		this.name = name;
		this.surName = surName;
		this.ownership = ownership;
		counter++;
		this.driverId = counter;
		this.status = "offline";
		this.ownership = ownership;
		this.startOnduty = new MyTime();
	}


	/**
	 * accept method change status to on a ride
	 */
	public Boolean acceptRequest() {
		double i = Math.random();
		if (i>=0.5) {
			this.status = "on-a-ride";
			return true;
		}
		else {
			return false;
		}
	}


}
