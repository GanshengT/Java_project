package myUberSystem;

import otherTools.GPSLocation;

public class AreaUsed {
	private GPSLocation center;
	private double radius;
	
	/**
	 * Constructor
	 * This class define an area where cars in our system run.
	 * @param center
	 * @param radius
	 */
	public AreaUsed(GPSLocation center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/**
	 * setter and getter
	 * @return
	 */
	public GPSLocation getCenter() {
		return center;
	}
	public void setCenter(GPSLocation center) {
		this.center = center;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
