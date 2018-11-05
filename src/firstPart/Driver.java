package firstPart;


import java.util.*;

public class Driver {
	private String name;
	private String surName;
	private int driverId;
	private String status;
	private Boolean ownership;
	private int rideNum;
	private double moneyCashed;
	private List<Integer> markList = new ArrayList<>();
	/**
	 * accept method change status to on a ride
	 */
	
	public void accept() {
		this.status = "on duty";
	}
	
	/**
	 * if ownership is True, we will add a new car in the list in main method of test class
	 * @param name
	 * @param surName
	 * @param driverId
	 * @param status
	 * @param owneship
	 */
	public Driver(String name, String surName, int driverId, String status, Boolean owneship) {
		super();
		this.name = name;
		this.surName = surName;
		this.driverId = driverId;
		this.status = status;
		this.ownership = owneship;
		Random r = new Random();
		int randomNum = r.nextInt(1);
		if (randomNum == 1) {
			this.ownership = true; 
		}
		else this.ownership = false;
			
	}
	

}
