package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import myUberSystem.AreaUsed;
import otherTools.GPSLocation;

class AreaUsedTest{
	protected GPSLocation gps;
	protected double r;
	
	@Before
	public void setup() {
		this.gps = new GPSLocation(44,22);
		this.r = 2.2;
	}
	
	@Test
	void testAreaUsed() {
		AreaUsed testArea = new AreaUsed(gps,r);
		assertEquals(testArea.getCenter(),gps);
		assertEquals(testArea.getRadius(),r);
	}

}
