package firstPart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideUberX extends Ride {
	private static Map<String, Double> trafficRateMap = new HashMap<String, Double>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -2279656004986567889L;

		{put("lowTraffic",  1.0);
		put("mediumTraffic",1.1);
		put("heavyTraffic",1.5);}};
	private static Map<String, Double> lengthTypeMap = new HashMap<String, Double>(){
			/**
		 * 
		 */
		private static final long serialVersionUID = 3814171649951810234L;

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
		this.setPriceToPay(this.getLength()*RideUberX.lengthTypeMap.get(this.getLengthType())*RideUberX.trafficRateMap.
				get(this.getTrafficState()));
		return this.getPriceToPay();
	}

	@Override
	public double price2() {
		return 0.00;
	};

}
