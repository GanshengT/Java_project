package firstPart;

public class StandardCar extends Car{
	/**
	 * standardcar is the subclass of Car and specify its attributes
	 */

	private static int seatNum = 4;
	private String idCar;
	private static int counter = 0;

	public StandardCar(AreaUsed areaUsed) {
		super(areaUsed);
		StandardCar.counter++;
		this.idCar = "Standard"+ StandardCar.counter;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		StandardCar.seatNum = seatNum;
	}
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}



	

}
