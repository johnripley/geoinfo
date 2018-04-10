package org.johnripley.geoinfo;

public class BaseDistance implements Distance {
	private static final int EARTH_RADIUS = 6371;

	private Coordinate pointA;
	private Coordinate pointB;

	public BaseDistance(Coordinate pointA, Coordinate pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}

	@Override
	public Coordinate getPointA() {
		return pointA;
	}

	@Override
	public Coordinate getPointB() {
		return pointB;
	}

	@Override
	public double getDistance() {
		return distanceInKm(getPointA().getLatitude(), getPointA().getLongitude(), getPointB().getLatitude(), getPointB().getLongitude());
	}

	/*
	 * Havesine code below copied from:
	 * 
	 * https://github.com/macedoj/haversine-great-circle-distance-calculator/blob/master/HaversineAlgorithm/src/haversine/HaversineAlgorithm.java
	 * Reformatted and embedded for convenience License: MIT Copyright (c) 2017
	 * Juliano Macedo
	 */
	private double distanceInKm(double startLati, double startLong, double endLati, double endLong) {

		double diffLati = Math.toRadians(endLati - startLati);
		double diffLong = Math.toRadians(endLong - startLong);
		double radiusStartLati = Math.toRadians(startLati);
		double radiusEndLati = Math.toRadians(endLati);

		// A and C are the 'sides' from the spherical triangle.
		double a = Math.pow(Math.sin(diffLati / 2), 2) + Math.pow(Math.sin(diffLong / 2), 2) * Math.cos(radiusStartLati) * Math.cos(radiusEndLati);
		double c = 2 * Math.asin(Math.sqrt(a));

		return EARTH_RADIUS * c;
	}
}
