package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import userInterface.CLUI;

public class CLUITest extends CLUI {

	CLUI myUberCLUI = new CLUI();
	/**
	@Test
	public void testInit() throws NoSuchFieldException, IOException {
		myUberCLUI.init("test.ini");
		
		fail("Not yet implemented");
	}
	*/

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
	
	@Test
	public void testSimRide_i() {
		myUberCLUI.setup("10","9","8","3");
		myUberCLUI.simRide_i("2","48.8502745","23.32993407", "3:12:22");
	}
	
	
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
