package Cars;


import java.util.ArrayList;
import java.util.List;

import myUberSystem.AreaUsed;

public class CreateStandardCar extends CreateCar {
	/**
	 * the factoy pattern to generate Standardcar
	 */

	@Override
	public StandardCar createCarMethod(AreaUsed areaUsed) {
		return new StandardCar(areaUsed);
	}



}
