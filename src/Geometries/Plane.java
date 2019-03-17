package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Plane extends Geomtry implements FlatGeomtry
{
	//**************properties***************
   Point3D point;
   Vector normalToPlane;
   
   //************getters and setters*********
   public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
public Point3D getPoint() {
	return point;
}
public void setPoint(Point3D point) {
	this.point = point;
}
public Vector getNormalToPlane() {
	return normalToPlane;
}
public void setNormalToPlane(Vector normalToPlane) {
	this.normalToPlane = normalToPlane;
}
//*********Constructors*****************
public Plane() {
	color = new Color(0);
	material = new Material();
	point = new Point3D();
	normalToPlane = new Vector();
	// TODO Auto-generated constructor stub
}
public Plane(Color color, Material m, Point3D p,Vector v ) {
	material = m;
	this.color= color;
	point=p;
	normalToPlane = v;
	
}
public Plane(Plane p) {
	material = p.material;
	this.color = p.color;
	point=p.getPoint();
	normalToPlane = p.getNormalToPlane();

}
//***********basic function***********************


//**********Geometries function*********
public Vector getNormal(Point3D p) {
	
	return normalToPlane.move(point.distance(p)).normalize();
}
 public List<Point3D> findIntersections(Ray r)
    {
		Vector N = this.getNormal(point);
		Vector p = new Vector(new Point3D(r.getPOO().subtract(this.getPoint())));
    	double t = (N.dotProduct(p)*-1)/(N.dotProduct(r.getDirection()));
		List<Point3D> lst = new ArrayList<Point3D>();
		if(t>=0)
		{
			lst.add(r.getPOO().add(r.getDirection().multScalar(t)));
		return lst;
		}
		return null;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Plane other = (Plane) obj;
	if (normalToPlane == null) {
		if (other.normalToPlane != null)
			return false;
	} else if (!normalToPlane.equals(other.normalToPlane))
		return false;
	if (point == null) {
		if (other.point != null)
			return false;
	} else if (!point.equals(other.point))
		return false;
	return true;
}  

}
