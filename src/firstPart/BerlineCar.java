package firstPart;

public class BerlineCar extends Car {
	
	private int seatNum;
	private String idCar;
	public BerlineCar(int N) {
		super();
		this.seatNum = 4;
		this.idCar = "Berline"+N;
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
