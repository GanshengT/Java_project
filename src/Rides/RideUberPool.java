package Rides;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myUberSystem.Customer;
import otherTools.GPSLocation;
import otherTools.MyTime;




public class RideUberPool extends Ride {
	/**
	 * coStartTime is the beginning time of a two customers UberPool ride
	 * We use two hush map to store the coefficients about ride length and ride traffic states which will be used for calculation of the total ride price.
	 */
	private MyTime coStartTime;
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 1);
		put("mediumTraffic",(double)1.1);
		put("heavyTraffic",(double)1.2);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
			{
				put("LessThanFive",2.4);
				put("FiveToTen",3.0);
				put("TenToTwenty",1.3);
				put("MoreThanTwenty",1.1);
			}
		};
	
	/**
	 * We override price method by using class specific coefficients to calculate the total price of a UberPool ride for the first customer.
	 */
	@Override
	public double price() {
		this.setPriceToPay(this.getLength()*lengthTypeMap.get(this.getLengthType())*trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}
	
	/**
	 * We override price method by using class specific coefficients to calculate the total price of a UberPool ride for the second customer.
	 */
	@Override
	public double price2() {
		this.setPriceToPay2(this.getLength2()*lengthTypeMap.get(this.getLengthType2())*trafficRateMap.
				get(this.getTrafficState2()));
		return this.getPriceToPay2();
	};

	public RideUberPool(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customer, passengerNum, startPosition, endPosition, startTime);
		this.setRideType("uberPool");
		//this.setPricePerKmLessThanFive(2.4);
		//this.setPricePerKmFiveToTen(3);
		//this.setPricePerKmTenToTwenty(1.3);
		//this.setPricePerKmMoreThanTwenty(1.1);
		// TODO Auto-generated constructor stub
	}
	
	public RideUberPool(Ride ride1, Ride ride2) {
		super(ride1.getCustomer(), ride1.getPassengerNum(),ride1.getStartPosition(),ride1.getEndPosition(),ride1.getStartTime(),
				ride2.getCustomer(), ride2.getPassengerNum(),ride2.getStartPosition(),ride2.getEndPosition(),ride2.getStartTime());
		this.setRideType("uberPool");
		this.coStartTime = MyTime.getLaterTime(this.getStartTime(), this.getStartTime2());
		this.setStartTime(this.coStartTime);
		this.setStartTime2(this.coStartTime);
	}

	/**
	 * setter and getter
	 * @return
	 */
	public MyTime getCoStartTime() {
		return coStartTime;
	}

	public void setCoStartTime(MyTime coStartTime) {
		this.coStartTime = coStartTime;
	}

}
