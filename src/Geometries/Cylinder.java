package Geometries;

import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Geomtry
{
//*********properties*************
	double radius;
	Point3D centerPoint;
	Vector direction;
//*********Constructors***********
	public Cylinder() {
		super();
		 radius= 0;
		 centerPoint= new Point3D();
		 direction=new Vector();
		// TODO Auto-generated constructor stub
	}


	public Cylinder(Color color,Material m, double radius,Point3D centerPoint,Vector direction) {
		super(color, m);
		this.radius=radius;
		this.centerPoint= centerPoint;
		this.direction=direction;
		// TODO Auto-generated constructor stub
	}

	public Cylinder(Cylinder c) {
		super(c.color, c.material);
		this.radius=c.radius;
		this.centerPoint= c.centerPoint;
		this.direction=c.direction;
		// TODO Auto-generated constructor stub
	}
//basic function
		@Override
	public String toString() {
		return "Cylinder [radius=" + radius + ", centerPoint=" + centerPoint + ", direction=" + direction + "]";
	}




		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cylinder other = (Cylinder) obj;
			if (centerPoint == null) {
				if (other.centerPoint != null)
					return false;
			} else if (!centerPoint.equals(other.centerPoint))
				return false;
			if (direction == null) {
				if (other.direction != null)
					return false;
			} else if (!direction.equals(other.direction))
				return false;
			if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
				return false;
			return true;
		}


	//get and set
	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Point3D getCenterPoint() {
		return centerPoint;
	}
	public void setCenterPoint(Point3D centerPoint) {
		this.centerPoint = centerPoint;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
//*********Geometries function********
	@Override
	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Point3D> findIntersections(Ray p) {
		// TODO Auto-generated method stub
		return null;
	}
}
