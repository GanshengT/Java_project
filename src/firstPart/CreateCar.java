package firstPart;

import java.util.ArrayList;
import java.util.List;

public abstract class CreateCar {
	

	private final List<Car> cars = new ArrayList<>();
	
	abstract protected Car createCarMethod(AreaUsed areaUsed); 


		/**
		 * 		
		 * 	public CreateCar(AreaUsed areaUsed) {
		 * Car standardCar = createCarMethod(areaUsed);
		Car vanCar = createCarMethod(areaUsed);
		Car berlineCar = createCarMethod(areaUsed);
		cars.add(standardCar);
		cars.add(berlineCar);
		cars.add(vanCar);}
		 */

		
	
}
