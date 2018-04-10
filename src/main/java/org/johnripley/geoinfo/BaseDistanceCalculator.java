package org.johnripley.geoinfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseDistanceCalculator implements DistanceCalculator {

	Logger logger = LogManager.getLogger(BaseDistanceCalculator.class);

	private Map<String, Coordinate> coordinates = new HashMap<>();

	public BaseDistanceCalculator() {
		try {
			loadResource("zip-coords.txt");
			
		} catch (Exception exc) {
			logger.error("Unable to load resource " + "zip-coords.txt", exc);
		}
	}

	protected void loadResource(String fileName) throws Exception {
		fileName = "/" + fileName;
		logger.info("Loading zip coordinates: " + fileName);
		try (InputStream is = getClass().getResourceAsStream(fileName)) {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
				reader.readLine(); //skip fist line
				String line;
				while ((line = reader.readLine()) != null) {
					processLine(line);
				}
			}
		}
		logger.info("Loading " + coordinates.size() + " zip coordinates");
	}

	private void processLine(String line) {
		String[] parts = line.split(",");
		String zip = parts[0].toLowerCase().trim();
		String latitude = parts[1].toLowerCase().trim();
		String longitude = parts[2].toLowerCase().trim();
		Coordinate coord = new BaseCoordinate(Double.parseDouble(latitude),Double.parseDouble(longitude));
		coordinates.put(zip, coord);
	}


	/* (non-Javadoc)
	 * @see org.johnripley.geoinfo.DistanceCalculator#getDistance(java.lang.String, java.lang.String)
	 */
	@Override
	public Distance getDistance(String zipA, String zipB) {
		Coordinate a = coordinates.get(zipA);
		Coordinate b = coordinates.get(zipB);
		return getDistance(a,b);
	}
	
	/* (non-Javadoc)
	 * @see org.johnripley.geoinfo.DistanceCalculator#getDistance(org.johnripley.geoinfo.Coordinate, org.johnripley.geoinfo.Coordinate)
	 */
	@Override
	public Distance getDistance(Coordinate pointA, Coordinate pointB) {
		return new BaseDistance(pointA,pointB);
	}

	/* (non-Javadoc)
	 * @see org.johnripley.geoinfo.DistanceCalculator#getDistance(double, double, double, double)
	 */
	@Override
	public Distance getDistance(double pointALat, double pointALong, double pointBLat, double pointBLong) {
		return new BaseDistance(new BaseCoordinate(pointALat,pointALong),new BaseCoordinate(pointBLat,pointBLong));
	}
	
	
}
