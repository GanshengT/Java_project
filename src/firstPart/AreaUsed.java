package firstPart;

public class AreaUsed {
	private GPSLocation center;
	private double radius;
	
	public AreaUsed(GPSLocation center, double radius) {
		this.center = center;
		this.radius = radius;
	}
	
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
