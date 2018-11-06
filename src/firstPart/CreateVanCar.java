package firstPart;

public class CreateVanCar extends CreateCar {

	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		// TODO Auto-generated method stub
		return new VanCar(areaUsed);
	}

}
