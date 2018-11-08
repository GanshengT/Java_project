package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.junit.Test;

import firstPart.MyUber;

public class MyUberTest extends MyUber {

	public MyUberTest(String iniFileName) throws InvalidFileFormatException, FileNotFoundException, IOException {
		super(iniFileName);
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testMyUber() throws InvalidFileFormatException, FileNotFoundException, IOException {
		MyUber myUber = new MyUber("my_uber.ini");
		assertTrue(myUber.getNumBerlineCar() == 2) ;
		fail("Not yet implemented");
	}

}
