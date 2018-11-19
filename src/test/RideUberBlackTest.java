package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import firstPart.Customer;
import firstPart.GPSLocation;
import firstPart.MyTime;
import firstPart.Ride;
import firstPart.RideUberBlack;

public class RideUberBlackTest {
	
		protected int passengerNum;
		protected Customer customer;
		protected GPSLocation gpsStart;
		protected GPSLocation gpsEnd;
		protected MyTime startTime;
		protected RideUberBlack rideTest;
		
		@Before
		public void setup() {
			this.customer = new Customer("Gezheng","Xu");
			this.passengerNum = 3;
			this.gpsStart = new GPSLocation(48.8500001, 23.3301);
			this.gpsEnd = new GPSLocation(48.85000008,23.331);
			this.startTime = new MyTime(18,30,20);
			this.rideTest = new RideUberBlack(customer,passengerNum,gpsStart,gpsEnd,startTime);
		}


	@Test
	public void testRideUberBlack() {
		assertTrue(rideTest.getRideType()=="uberBlack");
		
	}

	@Test
	public void testReturnLengthType() {
		rideTest.setLength(9);
		assertTrue(Ride.returnLengthType(rideTest.getLength())=="FiveToTen");
	}
	
	@Test
	public void testReturnTrafficInfo() {
		assertTrue(Ride.returnTrafficInfo(startTime)=="lowTraffic"||Ride.returnTrafficInfo(startTime)=="mediumTraffic"||Ride.returnTrafficInfo(startTime)=="heavyTraffic");
	}
	
	

}
