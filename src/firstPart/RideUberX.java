package firstPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideUberX extends Ride {
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 1);
		put("mediumTraffic",(double)1.1);
		put("heavyTraffic",(double)1.5);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
			{
				put("LessThanFive",3.3);
				put("FiveToTen",4.2);
				put("TenToTwenty",1.91);
				put("MoreThanTwenty",1.5);
			}
		};
	public RideUberX(Customer customer, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customer, passengerNum, startPosition, endPosition, startTime);
		this.setRideType("uberX");
		//this.setPricePerKmLessThanFive(3.3);
		//this.setPricePerKmFiveToTen(4.2);
		//this.setPricePerKmTenToTwenty(1.91);
		//this.setPricePerKmMoreThanTwenty(1.5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double price() {
		this.setPriceToPay(this.getLength()*lengthTypeMap.get(this.getLengthType())*trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}

	

}
