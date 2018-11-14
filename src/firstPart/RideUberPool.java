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
	
	
	public MyTime getCoStartTime() {
		return coStartTime;
	}

	public void setCoStartTime(MyTime coStartTime) {
		this.coStartTime = coStartTime;
	}

	

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
	/***
	public void calculateLowestRideCost(Car car) {
		double c_p1 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition());
		double c_p2 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2());
		double p1_p2 = LocationUtils.GetDistance(car.getCarLocation(), this.getStartPosition2());
		double d1_d2 = LocationUtils.GetDistance(this.getEndPosition(), this.getEndPosition2());
		double p1_d1 = LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition());
		double p1_d2 = LocationUtils.GetDistance(this.getStartPosition(), this.getEndPosition2());
		double p2_d1 = LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition());
		double p2_d2 = LocationUtils.GetDistance(this.getStartPosition2(), this.getEndPosition2());;
		if(c_p1 < c_p2) {
			if(p2_d1< p2_d2) {
				this.setCost( c_p1 + p1_p2 + p2_d1 + d1_d2);
				this.setLength(p1_p2 + p2_d1);
				this.setLength2(p2_d1 + d1_d2);
				//return this.cost;		
			}else {
				this.setCost (c_p1 + p1_p2 + p2_d2 + d1_d2);
				this.setLength(p1_p2 + p2_d2 + d1_d2);
				//return this.cost;
			}
				
		}else {
			if(p1_d2<p1_d1) {
				this.setCost(c_p2 + p1_p2 + p1_d2 + d1_d2);
				this.setLength(p1_d2 + d1_d2);
				this.setLength2(p1_p2 + p1_d2);
				//return this.cost;		
			}else {
				this.setCost(c_p2 + p1_p2 + p1_d1 + d1_d2);
				this.setLength2(p1_p2 + p1_d1 + d1_d2);
				//return this.cost;
			}
		}
		
		
	}*/
	

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
