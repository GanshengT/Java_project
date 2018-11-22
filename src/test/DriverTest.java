package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import myUberSystem.Driver;

public class DriverTest {
	protected Driver driverTest;
	protected String name;
	protected String surName;
	protected Boolean ownership;
	@Before
	public void setup() {
		name = "Lyam";
		surName = "Green";
		ownership = true;
		driverTest = new Driver(name,surName,ownership);
	}

	@Test
	public void testAskMark() {
		driverTest.askMark(5);
		assertTrue((driverTest.getAverageMark()-5)<0.001);
		
	}

	@Test
	public void testAcceptRequest() {
		Boolean result = driverTest.acceptRequest();
		if(result == true) {
			assertEquals(driverTest.getStatus(),"on-a-ride");
		}else {
			assertEquals(driverTest.getStatus(),"offline");
		}
	}

}
