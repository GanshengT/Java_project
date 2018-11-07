package firstPart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Car {
	
	/**
	 * StandardN will calculate automatically
	 */
	private String idCar;
	private int seatNum;
	private AreaUsed areaUsed;
	private int availableSeatNum;
	private List<Driver> owners = new ArrayList<>();
	private int currentDriver;
	private GPSLocation carLocation;
	private static List<Driver> nonAssignedDrivers = new ArrayList<>();
	
	/**
	 * from resource
	 * @return
	 */
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	
	}
	public int getAvailableSeatNum() {
		return availableSeatNum;
	}
	public void setAvailableSeatNum(int availableSeatNum) {
		this.availableSeatNum = availableSeatNum;
	}
	public AreaUsed getAreaUsed() {
		return areaUsed;
	}
	public void setAreaUsed(AreaUsed areaUsed) {
		this.areaUsed = areaUsed;
	}
	public GPSLocation getCarLocation() {
		return carLocation;
	}
	public void setCarLocation(GPSLocation carLocation) {
		this.carLocation = carLocation;
	}
	
	/**another way to construct
	 * public Car(AreaUsed areaUsed, List<Driver> listOfDriver) {
	 
		this.areaUsed = areaUsed;
		this.carLocation = LocationUtils.GetRandomLocation(areaUsed.getCenter(), areaUsed.getRadius());
		this.nonAssignedDrivers = listOfDriver;
	}
	*/
	
	public Car(AreaUsed areaUsed) {
		this.areaUsed = areaUsed;
		this.carLocation = LocationUtils.GetRandomLocation(areaUsed.getCenter(), areaUsed.getRadius());
	}
	
	
	public static List<Driver> getNonAssignedDrivers() {
		return nonAssignedDrivers;
	}
	public static void setNonAssignedDrivers(List<Driver> nonAssignedDrivers) {
		Car.nonAssignedDrivers = nonAssignedDrivers;
	}
	public void AssignDriver(List<Driver> listOfDriver) {
		owners.add(Car.nonAssignedDrivers.get(0));
		for(Driver driver : nonAssignedDrivers) {
			if (driver.getOwnership() == false) {
				owners.add(driver);
				nonAssignedDrivers.remove(driver);
			}
			else {
				System.out.println("assignment for this car is done");;
			}
		}
		
	}
	



	

}
