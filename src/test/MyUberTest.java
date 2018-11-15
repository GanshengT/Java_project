package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import firstPart.MyUber;
import firstPart.RideUberX;
import junit.framework.TestCase;

public class MyUberTest extends TestCase {
	
	/**
	 * first simulation
	 * set up
	 * customer make a request
	 * driver allocation
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
		assertTrue(myUber.getListOfCustomer().get(1).createANewRide(3, 44.1, 2.15 , 21, 7).getRideType()=="uberX");
		//assertTrue(myUber.getListOfCustomer().get(1).createANewRide(5, 44.1, 2.15 , 21, 7).getRideType()=="uberVan");
		for(int i=0; i<7;i++) {
			myUber.getListOfDriver().get(i).setStatus("on-duty");	
			}
		myUber.driverAllocation(myUber.getListOfCustomer().get(1).createANewRide(3, 44.1, 2.15 , 21, 7));
		assertTrue(myUber.getListOfRide().size()==1);
		assertTrue(myUber.getListOfRide().get(0).getRideType()=="uberX");
		assertTrue(myUber.getListOfRide().get(0).getPriceToPay()!=0);
		/**
		 * need to add driver information once accepted
		 */
		//System.out.println(myUber.getListOfRide().get(0).getDriver().getName());
		myUber.getListOfRide().get(0).getDriver().askMark(5);
		assertTrue(myUber.getListOfRide().get(0).getDriver().getListOfMark().get(0)==5);

	}

}
