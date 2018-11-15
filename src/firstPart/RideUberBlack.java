package firstPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideUberBlack extends Ride {
	
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		{put("lowTraffic", (double) 1);
		put("mediumTraffic",(double)1.3);
		put("heavyTraffic",(double)1.6);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
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
		//this.setPricePerKmLessThanFive(6.2);
		//this.setPricePerKmFiveToTen(5.5);
		//this.setPricePerKmTenToTwenty(3.25);
		//this.setPricePerKmMoreThanTwenty(2.6);
		// TODO Auto-generated constructor stub
	}

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
