package firstPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideUberBlack extends Ride {
	
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9037172862240003605L;

		{put("lowTraffic",  1.0);
		put("mediumTraffic",1.3);
		put("heavyTraffic", 1.6);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
			/**
		 * 
		 */
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
		//this.setPricePerKmLessThanFive(6.2);
		//this.setPricePerKmFiveToTen(5.5);
		//this.setPricePerKmTenToTwenty(3.25);
		//this.setPricePerKmMoreThanTwenty(2.6);
		// TODO Auto-generated constructor stub
	}

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
