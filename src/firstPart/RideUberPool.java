package firstPart;

import java.util.List;

public class RideUberPool extends Ride {

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0;
	}

	public RideUberPool(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition) {
		super(customers, passengerNum, startPosition, endPosition);
		this.setPricePerKmLessThanFive(2.4);
		this.setPricePerKmFiveToTen(3);
		this.setPricePerKmTenToTwenty(1.3);
		this.setPricePerKmMoreThanTwenty(1.1);
		// TODO Auto-generated constructor stub
	}

}
