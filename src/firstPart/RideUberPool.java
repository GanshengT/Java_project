package firstPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author gaelle
 * rideuber
 */


public class RideUberPool extends Ride {
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
	@Override
	public double price() {
		this.setPriceToPay(this.getLength()*lengthTypeMap.get(this.getLengthType())*trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}

	public RideUberPool(List<Customer> customers, int passengerNum, GPSLocation startPosition, GPSLocation endPosition, MyTime startTime) {
		super(customers, passengerNum, startPosition, endPosition, startTime);
		//this.setPricePerKmLessThanFive(2.4);
		//this.setPricePerKmFiveToTen(3);
		//this.setPricePerKmTenToTwenty(1.3);
		//this.setPricePerKmMoreThanTwenty(1.1);
		// TODO Auto-generated constructor stub
	}

}
