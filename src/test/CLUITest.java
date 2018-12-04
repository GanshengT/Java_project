package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import myUberSystem.Driver;
import userInterface.CLUI;

public class CLUITest extends CLUI {

	CLUI myUberCLUI = new CLUI();
	
	
	@Before
	public void setup() {
		myUberCLUI.setup("3","4","2","5");
	}
	
	
	/**
	@throws IOException 
	 * @throws NoSuchFieldException 
	 * @Test
	public void testInit() throws NoSuchFieldException, IOException {
		myUberCLUI.init("test.ini");
		
		fail("Not yet implemented");
	}
	*/
	@Test
	public void testInit() throws NoSuchFieldException, IOException {
		myUberCLUI.init("eval/test.ini");
		assertTrue(myUberCLUI.getMyUber().getListOfCar().size()==20);
	}
	/*
	@Test
	public void testSetup() {
		myUberCLUI.setup("3","4","2","1");
		assertTrue(myUberCLUI.getMyUber().getCarMap().isEmpty()==false);

	}
	*/
	
	/*
	@Test
	public void testDisplayState() {
		myUberCLUI.setup("3","4","2","1");
		myUberCLUI.displayState();
		assertTrue(1==1);
		
	}
	*/
	/*
	@Test
	public void testAsk4Price() {
		myUberCLUI.setup("10","8","9","3");
		myUberCLUI.ask4price("2","48.8502745","23.32993407","4");
	}
	*/
	
	/**
	@Test
	public void testSimRide_i() {
		myUberCLUI.simRide_i("2","48.8502745","23.32993407", "3:12:22");
	}
	*/
	
	
	/*
	@Test
	public void testRuntest() {
		try {
			myUberCLUI.runtest("eval/testScenario1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

}
