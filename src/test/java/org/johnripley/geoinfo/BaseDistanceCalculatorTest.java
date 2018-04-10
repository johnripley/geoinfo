package org.johnripley.geoinfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseDistanceCalculatorTest {

	@Test
	public void testZip() {
		DistanceCalculator lu = new BaseDistanceCalculator();
		Distance d = lu.getDistance("78681", "78729");
		System.out.println(d.getPointA());
		System.out.println(d.getPointB());
		System.out.println(d.getDistance());
		assertEquals(8.91,d.getDistance(),0.01);
	}

	@Test
	public void testCoords() {
		DistanceCalculator lu = new BaseDistanceCalculator();
		Distance d = lu.getDistance(new BaseCoordinate(30.534424,-97.725741), new BaseCoordinate(30.458396,-97.755344));
		System.out.println(d.getPointA());
		System.out.println(d.getPointB());
		System.out.println(d.getDistance());
		assertEquals(8.91,d.getDistance(),0.01);
	}
	
	@Test
	public void testRawCoords() {
		DistanceCalculator lu = new BaseDistanceCalculator();
		Distance d = lu.getDistance(30.534424,-97.725741,30.458396,-97.755344);
		System.out.println(d.getPointA());
		System.out.println(d.getPointB());
		System.out.println(d.getDistance());
		assertEquals(8.91,d.getDistance(),0.01);
	}

	
}
