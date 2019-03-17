package Geometries;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Triangle extends Geomtry implements FlatGeomtry
{
	//*****properties******
 private   Point3D p1;
 private   Point3D p2;
 private   Point3D p3;
 
 //*****getters and setters******
 public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public Point3D getP1() {
		return p1;
	}
	public void setP1(Point3D p1) {
		this.p1 = p1;
	}
	public Point3D getP2() {
		return p2;
	}
	public void setP2(Point3D p2) {
		this.p2 = p2;
	}
	public Point3D getP3() {
		return p3;
	}
	public void setP3(Point3D p3) {
		this.p3 = p3;
	}
	
	//*****Constructor*********
	public Triangle() {
     super();
	p1= new Point3D();
	p2=new Point3D();
	p3=new Point3D();
	}
	public Triangle(Color color, Material m,Point3D p1, Point3D p2, Point3D p3) {
	
		this.color=color;
		material = m;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
    
	public Triangle(Triangle T) {
		
		this.color=T.color;
		material = T.material;
		this.p1 = T.p1;
		this.p2 = T.p2;
		this.p3 = T.p3;
	}
	
	//*****basic function********
	@Override
	public String toString() {
		return "Triangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		return true;
	}
    //******Geometries function******
	@Override
	public Vector getNormal(Point3D p) {
		Vector v1 = new Vector(p.subtract(p1));
		Vector v2 = new Vector(p.subtract(p2));
		Vector v = v2.CrossProduct(v1).normalize();
		
		return v;
	}

	
	public List<Point3D> findIntersections(Ray p)
	{
		Vector v0=new Vector();
		Plane pl = new Plane(new Color(0),new Material(), p3, this.getNormal(p3));//build plane from the triangle
		if (pl.findIntersections(p)==null)
			return null;
	     v0 = new Vector(new Point3D(pl.findIntersections(p).get(0)).subtract(p.getPOO()));
		
	    Vector v1 = new Vector(new Point3D(p1.subtract(p.getPOO())));
		Vector v2 = new Vector(new Point3D(p2.subtract(p.getPOO())));
		Vector v3 = new Vector(new Point3D(p3.subtract(p.getPOO())));
		Vector N1 = (v1.CrossProduct(v2)).normalize();
		Vector N3 = (v3.CrossProduct(v1)).normalize();
		Vector N2 = (v2.CrossProduct(v3)).normalize();
		List<Point3D> lst = new ArrayList<Point3D>();
		double e1=v0.dotProduct(N1);
		double e2=v0.dotProduct(N2);
		double e3=v0.dotProduct(N3);
	        if(sigh(e1)==sigh(e2)&&sigh(e2)==sigh(e3))
	        {
	        lst.add(pl.findIntersections(p).get(0));
		    }
		 else
			 return null;
		return lst;
		}
	private int sigh(double d)
	{
		if(d<0)
			return 1;
		return 0;
	}
    
}
