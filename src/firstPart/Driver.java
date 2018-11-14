package firstPart;


import java.util.*;

public class Driver {
	private String name;
	private String surName;
	private int driverId;
	private String status;
	private MyTime startOnduty;
	private MyTime endOnDuty;
	private List<Integer> listOfMark = new ArrayList<>();
	public MyTime getEndOnDuty() {
		return endOnDuty;
	}

	public void setEndOnDuty(MyTime endOnDuty) {
		this.endOnDuty = endOnDuty;
	}

	private double OndutyTime;
	public MyTime getStartOnduty() {
		return startOnduty;
	}

	public void setStartOnduty(MyTime startOnduty) {
		this.startOnduty = startOnduty;
	}

	public double getOndutyTime() {
		return OndutyTime;
	}

	public void setOndutyTime(double ondutyTime) {
		OndutyTime = ondutyTime;
	}

	/**
	 * ownership= true means it has its own car
	 */
	private Boolean ownership;
	private static int counter = 0;
	private int rideNum;
	private double moneyCashed;
	private List<Integer> markList = new ArrayList<>();
	/**
	 * accept method change status to on a ride
	 */
	

	
	/**
	 * if ownership is True, we will add a new car in the list in main method of test class
	 * @param name
	 * @param surName
	 * @param driverId
	 * @param status
	 * @param owneship
	 */
	
	public void getMark(int mark) {
		this.getListOfMark().add(mark);	}
	
	public Driver(String name, String surName, Boolean ownership) {
		super();
		this.name = name;
		this.surName = surName;
		this.ownership = ownership;
		counter++;
		this.driverId = counter;
		this.status = "offline";
		this.ownership = ownership;
		/*Random r = new Random();
		int randomNum = r.nextInt(1);
		if (randomNum == 1) {
			this.ownership = true; 
		}
		else this.ownership = false;
		*/
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

	public void setStatus(String status) {
		this.status = status;
		if (status=="on-duty") {
			this.startOnduty.systemTime();
		}
		else if(status == "off-duty" || status == "on-a-ride") {
			this.endOnDuty.systemTime();
			this.OndutyTime+=this.getStartOnduty().timeMinus(this.endOnDuty);		}
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

	public List<Integer> getMarkList() {
		return markList;
	}

	public void setMarkList(List<Integer> markList) {
		this.markList = markList;
	}
	
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

	public List<Integer> getListOfMark() {
		return listOfMark;
	}

	public void setListOfMark(List<Integer> listOfMark) {
		this.listOfMark = listOfMark;
	}
	


}
