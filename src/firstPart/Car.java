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
	private int cuurentDriver;
	
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

	
	
	public Car(AreaUsed areaUsed) {
		this.areaUsed = areaUsed;
	}
	



	

}
