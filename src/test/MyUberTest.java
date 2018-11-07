package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.junit.Test;

import firstPart.MyUber;

public class MyUberTest extends MyUber {

	@Test
	public void testMyUber() throws InvalidFileFormatException, FileNotFoundException, IOException {
		MyUber myUber = new MyUber("my_uber.ini");
		fail("Not yet implemented");
	}

}
