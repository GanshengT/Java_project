package firstPart;

import java.util.ArrayList;
import java.util.List;

/**
 * the superclass of create specified car class
 * it define a create method and will be override afterwards
 *  cars : might not be used
 * @author aegea
 *
 */
public abstract class CreateCar {
	
	private final List<Car> cars = new ArrayList<>();	
	abstract protected Car createCarMethod(AreaUsed areaUsed); 

	
}
