package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import firstPart.Customer;

public class CustomerTest {
	protected String name;
	protected String surName;
	protected Customer testC = new Customer(name,surName);
	
	@Before
	public void setup() {
		this.name = "Alice";
		this.surName = "Green";
		
	}
	

	@Test
	public void testCustomer() {
		//Customer testCustomer = new Customer(this.name, this.surName);
		assertEquals(testC.getName(), this.name);
		assertEquals(testC.getSurName(), this.surName);
		//System.out.println(testC.getIdNum());
		assertEquals(testC.getIdNum(),1);
		assertTrue(Customer.getCounter() == 1);
		assertNull(testC.getGpsStart()); //customer's gpsStart is a null object, it will be defined in myUber initialization.
		//fail("Not yet implemented");
	}

	@Test
	public void testCreateANewRide() {
		Customer testC = new Customer(name,surName);
		//System.out.println(testC.getIdNum());
		assertEquals(testC.getIdNum(), 1);
		//fail("Not yet implemented");
		
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
