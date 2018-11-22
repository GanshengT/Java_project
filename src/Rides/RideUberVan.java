package Rides;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUberSystem.Customer;
import otherTools.GPSLocation;
import otherTools.MyTime;

public class RideUberVan extends Ride {
	/**
	 * We use two hush map to store the coefficients about ride length and ride traffic states which will be used for calculation of the total ride price.
	 */
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 1);
		put("mediumTraffic",(double)1.5);
		put("heavyTraffic",(double)1.8);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
			{
				put("LessThanFive",6.2);
				put("FiveToTen",7.7);
				put("TenToTwenty",3.25);
				put("MoreThanTwenty",2.6);
			}
		};
	
	public RideUberVan(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customer, passengerNum, startPosition,endPosition,startTime);
		this.setRideType("uberVan");
	}
	/**
	 * We override price method by using class specific coefficients to calculate the total price of a UberVan ride.
	 */
	@Override
	public double price() {
		this.setPriceToPay(this.getLength()*lengthTypeMap.get(this.getLengthType())*trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}
	
	@Override
	public double price2() {
		return 0.00;
	};

}
