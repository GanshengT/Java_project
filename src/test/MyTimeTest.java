package test;

import org.junit.Test;

import firstPart.MyTime;
import junit.framework.TestCase;

public class MyTimeTest extends TestCase {

	@Test
	public void testGetDayInterval() {
		MyTime myTime = new MyTime(20,50,30);
		myTime.addTime(10);
		System.out.println(myTime.getSs());
		assertTrue(myTime.getSs() == 40);
	}

}
