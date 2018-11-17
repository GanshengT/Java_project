package firstPart;

public class VanCar extends Car {
	
	/**
	 * Vancar is the subclass of Car and specify its attributes
	 */
	
	private static int seatNum = 6;
	private String idCar;
	private static int counter = 0;


	public VanCar(AreaUsed areaUsed) {
		super(areaUsed);
		VanCar.counter++;
		idCar = "Van"+VanCar.counter;
		// TODO Auto-generated constructor stub
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		VanCar.seatNum = seatNum;
	}
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}

}
