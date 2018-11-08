package firstPart;

import java.util.List;

public class RideUberX extends Ride {

	public RideUberX(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition) {
		super(customers, passengerNum, startPosition, endPosition);
		this.setPricePerKmLessThanFive(3.3);
		this.setPricePerKmFiveToTen(4.2);
		this.setPricePerKmTenToTwenty(1.91);
		this.setPricePerKmMoreThanTwenty(1.5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0;
	}

}
