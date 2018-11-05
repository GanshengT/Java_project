package firstPart;

public class CreateVanCar extends CreateCar {

	@Override
	protected Car createCarMethod(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		// TODO Auto-generated method stub
		return new VanCar(idCar, seatNum, positionGps, availableSeatNum);
	}

}
