package Rides;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUberSystem.Customer;
import otherTools.GPSLocation;
import otherTools.MyTime;

public class RideUberBlack extends Ride {
	/**
	 * We use two hush map to store the coefficients about ride length and ride traffic states which will be used for calculation of the total ride price.
	 */
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		private static final long serialVersionUID = 9037172862240003605L;

		{put("lowTraffic",  1.0);
		put("mediumTraffic",1.3);
		put("heavyTraffic", 1.6);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
		private static final long serialVersionUID = -1279100275807087297L;

			{
				put("LessThanFive",6.2);
				put("FiveToTen",5.5);
				put("TenToTwenty",3.25);
				put("MoreThanTwenty",2.6);
			}
		};
	
	public RideUberBlack(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customer, passengerNum, startPosition, endPosition, startTime);
		this.setRideType("uberBlack");
	
	}
	/**
	 * We override price method by using class specific coefficients to calculate the total price of a UberBlack ride.
	 */
	@Override
	public double price() {
		this.setPriceToPay(this.getLength()*RideUberBlack.lengthTypeMap.get(this.getLengthType())*RideUberBlack.trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}
	
	@Override
	public double price2() {
		return 0.00;
	};
}
