package Cars;

import myUberSystem.AreaUsed;

public class StandardCar extends Car{
	/**
	 * standardcar is the subclass of Car and specify its attributes
	 */

	private String idCar;
	private static int counter = 0;

	public StandardCar(AreaUsed areaUsed) {
		super(areaUsed);
		StandardCar.counter++;
		this.idCar = "Standard"+ StandardCar.counter;
		this.setSeatNum(4);
	}
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		StandardCar.counter = counter;
	}
	


	

}
