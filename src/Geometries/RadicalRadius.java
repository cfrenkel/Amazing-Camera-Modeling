package Geometries;

public class RadicalRadius 
{
  protected double radius;

  
public RadicalRadius() {
	radius=0;
}

public double getRadius() {
	return radius;
}

public void setRadius(double radius) {
	this.radius = radius;
}

public RadicalRadius(double radius) {
	this.radius = radius;
}

public RadicalRadius(RadicalRadius radius) {
	this.radius = radius.radius;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	RadicalRadius other = (RadicalRadius) obj;
	if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
		return false;
	return true;
}
  
  
  
}
