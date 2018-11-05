package firstPart;

public class BerlineCar extends Car {
	
	private int seatNum;
	private String idCar;

	public BerlineCar(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		super(idCar, seatNum, positionGps, availableSeatNum);
		this.seatNum = 4;
		this.idCar = "Berline"+N;
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
