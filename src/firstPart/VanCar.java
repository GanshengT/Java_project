package firstPart;

public class VanCar extends Car {
	
	private static int seatNum = 6;
	private String idCar;
	private static int counter = 0;


	public VanCar(AreaUsed areaUsed) {
		super(areaUsed);
		VanCar.counter++;
		idCar = "Van"+counter;
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
