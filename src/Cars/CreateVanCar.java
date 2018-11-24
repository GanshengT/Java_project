package Cars;

import myUberSystem.AreaUsed;

public class CreateVanCar extends CreateCar {
	/**
	 * the factoy pattern to generate vancar
	 */
	@Override
	public VanCar createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new VanCar(areaUsed);
	}

}
