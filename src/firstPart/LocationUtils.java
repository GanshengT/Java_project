package firstPart;
import java.util.Random;

/**
 * We use this class for some necessary GPS location calculates.
 * @author gaelle
 *
 */
public class LocationUtils {
	static final double EARTH_RADIUS  = 6372.796924;
	static final double PI = 3.1415926535898;
 
	/**
	 * We use this static method in order to get a random GPS location 
	 * within a certain range of the center position.
	 * @param center
	 * @param distance
	 * @return
	 */
	public static GPSLocation GetRandomLocation(GPSLocation center, double distance) {
		if (distance <= 0) distance = 50;
		double lat, lon, brg;
		double dist = 0;
		double rad360 = 2 * PI;
		distance = distance / 1000;
		GPSLocation location = new GPSLocation();
		double maxdist = distance;
		maxdist = maxdist / EARTH_RADIUS;
		double startlat = rad(center.getLatitude());
		double startlon = rad(center.getLongitude());
		double cosdif = Math.cos(maxdist) - 1;
		double sinstartlat = Math.sin(startlat);
		double cosstartlat = Math.cos(startlat);
		dist = Math.acos((new Random().nextDouble() * cosdif + 1));
		brg = rad360 * new Random().nextDouble();
		lat = Math.asin(sinstartlat * Math.cos(dist) + cosstartlat * Math.sin(dist) * Math.cos(brg));
		lon = deg(normalizeLongitude(startlon * 1 + Math.atan2(Math.sin(brg) * Math.sin(dist) * cosstartlat, Math.cos(dist) - sinstartlat * Math.sin(lat))));
		lat = deg(lat);
		location.setLatitude(padZeroRight(lat));
		location.setLongitude(padZeroRight(lon));
		return location;
	}
 
    /**
     * We use this static method to calculate the distance between two GPS locations.
     * @param start
     * @param end
     * @return
     */
	public static int GetDistance(GPSLocation start, GPSLocation end) {
		double radLat1 = rad(start.getLatitude());
		double radLat2 = rad(end.getLatitude());
		double a = radLat1 - radLat2;
		double b = rad(start.getLongitude()) - rad(end.getLongitude());
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = (int) (s * 10000000) / 10000;
		return (int)s;
	}
 
	/**
	 * Transformed calculate from degree to rad
	 * @param d
	 * @return
	 */
	static double rad(double d) {
		return d * PI / 180.0;
	}
 
	/**
	 * Transformed calculate from rad to degree
	 * @param rd
	 * @return
	 */
	static double deg(double rd) {
		return (rd * 180 / Math.PI);
	}
 
	static double normalizeLongitude(double lon) {
		double n = PI;
		if (lon > n) {
			lon = lon - 2 * n;
		} else if (lon < -n) {
			lon = lon + 2 * n;
		}
		return lon;
	}
 
	static double padZeroRight(double s) {
		double sigDigits = 8;
		s = Math.round(s * Math.pow(10, sigDigits)) / Math.pow(10, sigDigits);
		return s;
	}
}


