package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Rides.Ride;
import Rides.RideUberX;
import myUberSystem.Customer;
import otherTools.GPSLocation;
import otherTools.MyTime;

public class CustomerTest {
	protected String name;
	protected String surName;
	protected Customer testC;
	protected GPSLocation gpsStart;
	protected GPSLocation gpsEnd;
	protected MyTime startTime;
	
	@Before
	public void setup() {
		this.name = "Alice";
		this.surName = "Green";
		this.testC = new Customer(name,surName);
		this.gpsStart = new GPSLocation(48.8500001, 23.3301);
		this.gpsEnd = new GPSLocation(48.85000008,23.331);
		this.startTime = new MyTime(18,30,20);
	}
	

	@Test
	public void testCustomer() {
		//Customer testC = new Customer(this.name, this.surName);
		assertEquals(testC.getName(), this.name);
		assertEquals(testC.getSurName(), this.surName);
		//System.out.println(testC.getIdNum());
		//assertEquals(testC.getIdNum(),2);
		//assertTrue(Customer.getCounter() == 2);
		assertNull(testC.getGpsStart()); //customer's gpsStart is a null object, it will be defined in myUber initialization.
		//fail("Not yet implemented");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCreateANewRide() {
		//Customer testC = new Customer(name,surName);
		//System.out.println(testC.getIdNum());
		//assertEquals(testC.getIdNum(), 1);
		//fail("Not yet implemented");
		testC.setGpsStart(gpsStart);
		//Ride rideTest = new RideUberX(this.testC, 3, gpsStart, gpsEnd, startTime);
		Ride rideReturn = testC.createANewRide(3, gpsEnd.getLongitude(), gpsEnd.getLatitude(), startTime.getHH(), startTime.getMm(),"uberx");
		//System.out.println(rideReturn.getRideType());
		assertEquals("uberX", rideReturn.getRideType());
		assertEquals(null, rideReturn.getCar());
		Ride nullRide = testC.createANewRide(3, gpsEnd.getLongitude(), gpsEnd.getLatitude(), startTime.getHH(), startTime.getMm(),"ubervan");
		assertEquals(nullRide, null);
	}
	@After
	public void gpsStartRelease() {
		testC.setGpsStart(null) ;
	}
	

	@Test
	public void testCancelBook() {
		//fail("Not yet implemented");
		
	}

	@Test
	public void testAboard() {
		//fail("Not yet implemented");
	}

}
