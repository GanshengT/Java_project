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

	@Test
	public void testSetup() {
		myUberCLUI.setup("3","4","2","1");
		assertTrue(myUberCLUI.getMyUber().getCarMap().isEmpty()==false);

	}
	
	@Test
	public void testDisplayState() {
		myUberCLUI.displayState();
		assertTrue(1==1);
		
	}

}
