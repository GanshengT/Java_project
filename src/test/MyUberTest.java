package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import firstPart.MyUber;
import junit.framework.TestCase;

public class MyUberTest extends TestCase {
	
	@Test
	public void testMyUber() throws InvalidFileFormatException, FileNotFoundException, IOException { 
		MyUber myUber = new MyUber("my_uber.ini");
		assertTrue(myUber.getNumBerlineCar() == 2);
	}

}
