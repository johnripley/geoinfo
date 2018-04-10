package org.johnripley.geoinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseDistanceCalculatorTest {

	@Test
	public void testLoad() {
		DistanceCalculator lu = new BaseDistanceCalculator();
		Distance d = lu.getDistance("78681", "78729");
		System.out.println(d.getPointA());
		System.out.println(d.getPointB());
		System.out.println(d.getDistance());
		assertEquals(21.1,d.getDistance(),0.1);
	}

}
