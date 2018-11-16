package firstPart;


import java.util.ArrayList;
import java.util.List;

public class CreateStandardCar extends CreateCar {
	//private static int counter = 0;
	@Override
	protected Car createCarMethod(AreaUsed areaUsed) {
		//counter++;
		return new StandardCar(areaUsed);
	}



}
