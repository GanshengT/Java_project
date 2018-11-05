package firstPart;

public class BerlineCar extends Car {
	
	private int seatNum;
	private String idCar;
	private static int counter = 0;

	public BerlineCar(String idCar, int seatNum, double[] positionGps, int availableSeatNum) {
		super(idCar, seatNum, positionGps, availableSeatNum);
		this.seatNum = 4;
		BerlineCar.counter++;
		this.idCar = "Berline"+counter;
		// TODO Auto-generated constructor stub
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}


	

}
