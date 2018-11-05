package firstPart;


import java.util.ArrayList;
import java.util.List;

public class CreateStandardCar extends CreateCar {

	@Override
	protected Car createCarMethod(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		return new StandardCar(idCar, seatNum, positionGps, availableSeatNum, N);
	}



}
