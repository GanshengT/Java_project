package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Cars.Car;
import Cars.StandardCar;
import myUberSystem.AreaUsed;
import myUberSystem.Driver;
import otherTools.GPSLocation;

public class CarTest {
	protected Driver driver1;
	protected Driver driver2;
	protected Driver driver3;
	protected Driver driver4;
	protected AreaUsed area;
	protected Car car;
	
	@Before
	public void setup() {
		driver1 = new Driver(" "," ",true);
		driver2 = new Driver("  ","  ",false);
		driver3 = new Driver("   ", "   ", false);
		driver4 = new Driver("    ","    ", false);
		area = new AreaUsed(new GPSLocation(48.85,23.33),40);
		car = new StandardCar(area);
		car.getNonAssignedDrivers().add(driver1);
		car.getNonAssignedDrivers().add(driver2);
		car.getNonAssignedDrivers().add(driver3);
		car.getNonAssignedDrivers().add(driver4);
		
		
	}
	
	
	@Test
	public void testAssignDriver() {
		assertNull(car.getCurrentDirverObject());
		assertTrue(car.getOwners().size()==0);
		car.AssignDriver();
		assertNotNull(car.getCurrentDirverObject());
		assertTrue(car.getOwners().size() == 4);
		assertTrue(car.getCurrentDirverObject().getStatus() == "on-duty");
		System.out.println(car.getOwners().get(0).getStatus());
		System.out.println(car.getOwners().get(1).getStatus());
		System.out.println(car.getCurrentDriver());
	}
	
	/*
	@Test
	public void testRandomDriver() {
		//fail("Not yet implemented");
	}
	*/

	/*
	@Test
	public void testChangeDriver() {
		
	}
	*/

}
