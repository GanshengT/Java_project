package firstPart;

public class GPSLocation {
	private double latitude;
	private double longitude;
	
	/**
	 * Constructor
	 * Class used for GPS location store
	 * @param longitude
	 * @param latitude
	 */
	public GPSLocation(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	/**
	 * Default constructor  
	 */
	public GPSLocation() {
		
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
}


