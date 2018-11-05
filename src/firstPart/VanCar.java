package firstPart;

public class VanCar extends Car {
	
	private int seatNum;
	private String idCar;


	public VanCar(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		super(idCar, seatNum, positionGps, availableSeatNum);
		seatNum = 6;
		idCar = "Van"+N;
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
