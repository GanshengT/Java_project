package firstPart;

import java.util.List;

public class RideUberBlack extends Ride {
	

	public RideUberBlack(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition) {
		super(customers, passengerNum, startPosition, endPosition);
		this.setPricePerKmLessThanFive(6.2);
		this.setPricePerKmFiveToTen(5.5);
		this.setPricePerKmTenToTwenty(3.25);
		this.setPricePerKmMoreThanTwenty(2.6);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		// TODO Auto-generated method stub
		return 0;
	}

}
