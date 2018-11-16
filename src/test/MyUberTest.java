package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import firstPart.Car;
import firstPart.Driver;
import firstPart.MyUber;
import firstPart.RideUberX;
import junit.framework.TestCase;

public class MyUberTest extends TestCase {
	
	/**
	 * first simulation
	 * set up
	 * customer make a request
	 * driver allocation
	 * ride finish and price added
	 * @throws InvalidFileFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	/**
	 * @throws InvalidFileFormatException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testMyUber() throws InvalidFileFormatException, FileNotFoundException, IOException { 
		MyUber myUber = new MyUber("my_uber.ini");
		assertTrue(myUber.getNumBerlineCar() == 2);
		//assertTrue(myUber.getListOfCustomer().get(1).createANewRide(3, 44.1, 2.15 , 21, 7).getRideType()=="uberX");
		//assertTrue(myUber.getListOfCustomer().get(1).createANewRide(5, 44.1, 2.15 , 21, 7).getRideType()=="uberVan");
		for(int i=0; i<7;i++) {
			myUber.getListOfDriver().get(i).setStatus("on-duty");	
			}
		myUber.driverAllocation(myUber.getListOfCustomer().get(1).createANewRide(3, 44.1, 2.17 , 21, 7,"ubervan"));
		//System.out.println(myUber.getListOfRide().get(0).getLength() + "the length");
		assertTrue(myUber.getListOfRide().size()==1); 
		assertTrue(myUber.getListOfRide().get(0).getRideType()=="uberVan");
		assertTrue(myUber.getListOfRide().get(0).getPriceToPay()!=0);
		/**
		 * need to add driver information once accepted
		 * test if every car has owners
		 */
		//System.out.println(myUber.getListOfRide().get(0).getDriver().getName());

		myUber.getListOfRide().get(0).getDriver().askMark(5);
		assertTrue(myUber.getListOfRide().get(0).getDriver().getListOfMark().get(0)==5);
		
		/***
		for(Car car: myUber.getListOfCar()) {
			System.out.println(car.getIdCar()+"car name");
			for (Driver driver : car.getOwners()) {
				System.out.println(driver.getName());
				System.out.println(driver.getDriverId());
			}
		}
		*/
		
		myUber.RideFinished(myUber.getListOfRide().get(0));
		System.out.println(myUber.getListOfCustomer().get(1).getRideNum()+"the first ride done");
		assertTrue(myUber.getListOfRide().get(0).getPriceToPay()>3);
		myUber.driverAllocation(myUber.getListOfCustomer().get(0).createANewRide(3, 44.1, 2.17 , 22, 7,"uberpool"));
		myUber.driverAllocation(myUber.getListOfCustomer().get(1).createANewRide(1, 44.1, 2.17 , 22, 15,"uberpool"));
		assertTrue(myUber.getListOfRide().size()==2); 
		assertTrue(myUber.getListOfRide().get(1).getRideType()=="uberPool");
		myUber.RideFinished(myUber.getListOfRide().get(1));
		assertTrue(myUber.getListOfCustomer().get(1).getRideNum() == 2);
		assertTrue(myUber.getListOfCustomer().get(0).getRideNum() == 1);
		}

}
