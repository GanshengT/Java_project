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
	public RideUberBlack(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customers, passengerNum, startPosition, endPosition, startTime);
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

}
