package firstPart;

import java.util.Arrays;

public abstract class Car {
	
	/**
	 * StandardN how to generate N is a trchnical question
	 */
	private String idCar;
	private int seatNum;
	private double []positionGps;
	private int availableSeatNum;
	
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

	public Car(String idCar2, int seatNum2, double[] positionGps2, int availableSeatNum2) {
		// TODO Auto-generated constructor stub
	}



	

}
