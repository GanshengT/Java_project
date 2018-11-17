package firstPart;


import java.util.ArrayList;
import java.util.List;

public class CreateStandardCar extends CreateCar {
	/**
	 * the factoy pattern to generate Standardcar
	 */

	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		return new StandardCar(areaUsed);
	}



}
