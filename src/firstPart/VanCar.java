package firstPart;

public class VanCar extends Car {
	
	private int seatNum;
	private String idCar;
	public VanCar(int N) {
		super();
		seatNum = 6;
		idCar = "Van"+N;
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
