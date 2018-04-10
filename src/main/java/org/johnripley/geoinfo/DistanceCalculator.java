package org.johnripley.geoinfo;

public interface DistanceCalculator {

	Distance getDistance(String zipA, String zipB);

	Distance getDistance(Coordinate pointA, Coordinate pointB);

	Distance getDistance(double pointALat, double pointALong, double pointBLat, double pointBLong);

}