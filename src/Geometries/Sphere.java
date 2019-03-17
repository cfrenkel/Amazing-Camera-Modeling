package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Sphere extends Geomtry
	{
	//*********properties*************
	
	double radius;
	Point3D centerPoint;
	//***********getters and setters**

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
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
	//*********Constructors*******************
	public Sphere() {
		super();
		// TODO Auto-generated constructor stub
		 radius= 0;
		 centerPoint=new Point3D();
	}

	public Sphere(Color color, Material m, double radius,Point3D centerPoint) {
		this.color=color;
		material = m;
		this.radius=radius;
		this.centerPoint=centerPoint;
		// TODO Auto-generated constructor stub
	}
	public Sphere(Sphere s) {
		this.color=s.color;
		material = s.material;
		this.radius=s.radius;
		this.centerPoint=s.centerPoint;
		// TODO Auto-generated constructor stub
	}

//*****************basic function**************
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (centerPoint == null) {
			if (other.centerPoint != null)
				return false;
		} else if (!centerPoint.equals(other.centerPoint))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sphere [radius=" + radius + ", centerPoint=" + centerPoint + "]";
	}
	
	//******geometries function*********
	@Override
	public Vector getNormal(Point3D p) {
		return new Vector(p.subtract(centerPoint));
		
	}


	@Override
public  List<Point3D> findIntersections(Ray r)
{
Point3D l1=this.centerPoint.subtract(r.getPOO());
Vector l=new Vector(l1);
double tm=l.dotProduct(r.getDirection().normalize());
double d=Math.sqrt(l.length()*l.length()-tm*tm);
/*double d=Math.sqrt(l.VectorKLength()*l.VectorKLength()-tm*tm);*/
double th =Math.sqrt(this.radius*this.radius-d*d);
double t1 = tm-th;
double t2 = tm + th;
Vector v = new Vector(r.getDirection().normalize());
Point3D vP1= r.getPOO().add(v.multScalar(t1));
Point3D vP2=r.getPOO().add(v.multScalar(t2));
List<Point3D> lst=new ArrayList<Point3D>();	
if(d>this.radius)
return null;
if(t1<=0)
return null;
else 
lst.add(vP1);
if(t2<=0)
return null;
else
lst.add(vP2);
return lst;

}
}
