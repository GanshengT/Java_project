package firstPart;

public class CreateBerlineCar extends CreateCar {

	@Override
	protected Car createCarMethod(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		// TODO Auto-generated method stub
		return new BerlineCar(idCar, seatNum, positionGps, availableSeatNum, N);
	}

}
