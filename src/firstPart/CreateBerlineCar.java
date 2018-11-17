package firstPart;

public class CreateBerlineCar extends CreateCar {

	/**
	 * the factoy pattern to generate berlinecar
	 */
	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new BerlineCar(areaUsed);
	}

}
