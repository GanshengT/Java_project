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
	private MyTime coStartTime;
	private double cost;
	
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
	
	public double calculateLowestRideCost(Car car) {
		double c_p1 = 99999;
		double p1_p2 = 99999;
		double p2_d1 = 999999;
		double d1_d2 = 999999;
		if(LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition())<LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2())) {
			if(LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition())< LocationUtils.GetDistance(this.getStartPosition2(),this.getEndPosition2())) {
				this.cost = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition())
						+ LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2());
				this.setLength(LocationUtils.GetDistance(this.getStartPosition(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition()));
				this.setLength2(LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition())
						+ LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2()));
				return this.cost;		
			}else {
				this.cost = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition2())
						+ LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2());
				this.setLength(LocationUtils.GetDistance(this.getStartPosition(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition2())
						+LocationUtils.GetDistance(this.getEndPosition2(), this.getEndPosition()));
				return this.cost;
			}
				
		}else {
			if(LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2())< LocationUtils.GetDistance(this.getStartPosition(),this.getEndPosition())) {
				this.cost = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2())
						+ LocationUtils.GetDistance(this.getEndPosition2(), this.getEndPosition());
				this.setLength(LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2())
						+ LocationUtils.GetDistance(this.getEndPosition2(), this.getEndPosition()));
				this.setLength2(LocationUtils.GetDistance(this.getStartPosition2(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2()));
				return this.cost;		
			}else {
				this.cost = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2())
						+ LocationUtils.GetDistance(this.getStartPosition2(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition())
						+ LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2());
				this.setLength2(LocationUtils.GetDistance(this.getStartPosition2(), this.getStartPosition())
						+ LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition())
						+LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2()));
				return this.cost;
			}
		}
		
	}
	

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
		
	}

}
