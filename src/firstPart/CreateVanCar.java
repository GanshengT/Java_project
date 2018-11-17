package firstPart;

public class CreateVanCar extends CreateCar {
	/**
	 * the factoy pattern to generate vancar
	 */
	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new VanCar(areaUsed);
	}

}
