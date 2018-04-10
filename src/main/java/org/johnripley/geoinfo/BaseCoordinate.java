package org.johnripley.geoinfo;

public class BaseCoordinate implements Coordinate {
	private double latitude = 0.0;
	private double longitude = 0.0;

	public BaseCoordinate(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public String toString()
	{
		return "(" + latitude + "," + longitude + ")";
	}
	
}
