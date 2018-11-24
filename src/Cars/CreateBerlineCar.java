package Cars;

import myUberSystem.AreaUsed;

public class CreateBerlineCar extends CreateCar {

	/**
	 * the factoy pattern to generate berlinecar
	 */
	@Override
	public BerlineCar createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new BerlineCar(areaUsed);
	}

}
