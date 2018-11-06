package firstPart;

public class CreateBerlineCar extends CreateCar {

	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new BerlineCar(areaUsed);
	}

}
