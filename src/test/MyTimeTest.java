package test;

import org.junit.Test;

import junit.framework.TestCase;
import otherTools.MyTime;

public class MyTimeTest extends TestCase {

	@Test
	public void testGetDayInterval() {
		MyTime myTime = new MyTime(20,50,30);
		System.out.println(myTime.toString());
		myTime.addTime(10);
		System.out.println(myTime.toString());
		assertTrue(myTime.getSs() == 40);
	}

}
