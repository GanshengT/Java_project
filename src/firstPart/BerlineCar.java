package firstPart;

public class BerlineCar extends Car {
	
	private static int seatNum = 4;
	private String idCar;
	private static int counter = 0;

	public BerlineCar(AreaUsed areaUsed) {
		super(areaUsed);
		BerlineCar.counter++;
		this.idCar = "Berline"+counter;
		// TODO Auto-generated constructor stub
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		BerlineCar.seatNum = seatNum;
	}
	public String getIdCar() {
		return idCar;
	}
	public void setIdCar(String idCar) {
		this.idCar = idCar;
	}


	

}
