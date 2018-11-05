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
	private double []positionGps;
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
	public double[] getPositionGps() {
		return positionGps;
	}
	public void setPositionGps(double[] positionGps) {
		this.positionGps = positionGps;
	}
	public int getAvailableSeatNum() {
		return availableSeatNum;
	}
	public void setAvailableSeatNum(int availableSeatNum) {
		this.availableSeatNum = availableSeatNum;
	}
	@Override
	public String toString() {
		return "Car [idCar=" + idCar + ", seatNum=" + seatNum + ", positionGps=" + Arrays.toString(positionGps)
				+ ", availableSeatNum=" + availableSeatNum + "]";
	}
	
	
	public Car(String idCar, int seatNum, double[] positionGps, int availableSeatNum) {
		super();
		this.idCar = idCar;
		this.seatNum = seatNum;
		this.positionGps = positionGps;
		this.availableSeatNum = availableSeatNum;
	}
	



	

}
