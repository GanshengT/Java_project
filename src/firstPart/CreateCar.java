package firstPart;

import java.util.ArrayList;
import java.util.List;

public abstract class CreateCar {
	

	private final List<Car> cars = new ArrayList<>();
	
	abstract protected Car createCarMethod(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N); 

	public Car createCar(String idCar, int seatNum, double[] positionGps, int availableSeatNum, int N) {
		Car standardCar = createCarMethod(idCar, seatNum, positionGps,  availableSeatNum,  N);
		Car vanCar = createCarMethod( idCar, seatNum, positionGps, availableSeatNum, N);
		Car berlineCar = createCarMethod(idCar, seatNum, positionGps, availableSeatNum, N);
		cars.add(standardCar);
		cars.add(berlineCar);
		cars.add(vanCar);
		return null;
	}
}
