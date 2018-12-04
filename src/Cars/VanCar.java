package Cars;

import myUberSystem.AreaUsed;

public class VanCar extends Car {
	
	/**
	 * Vancar is the subclass of Car and specify its attributes
	 */
	
	private String idCar;
	private static int counter = 0;


	public VanCar(AreaUsed areaUsed) {
		super(areaUsed);
		VanCar.counter++;
		idCar = "Van"+VanCar.counter;
		this.setSeatNum(6);
		// TODO Auto-generated constructor stub
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
		VanCar.counter = counter;
	}
	

}
