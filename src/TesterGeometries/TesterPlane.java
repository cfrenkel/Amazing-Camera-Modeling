package TesterGeometries;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Geometries.Plane;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TesterPlane {

	 @Test
	public void testGetNormal() 
	 {
		
		Plane p=new Plane(new Color(0),new Material(), new Point3D(new Coordinate(4),new Coordinate(4), new Coordinate(4)),new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0))));
		Vector v=new Vector(), v1=new Vector(new Point3D(new Coordinate(0),new Coordinate(0), new Coordinate(0)));
		v=p.getNormal(new Point3D(new Coordinate(4),new Coordinate(4), new Coordinate(4)));
		assertEquals(v, v1 );
        
	 }
	 
	 @Test
	 public void testFindInstraction()
	 {

			Point3D p = new Point3D(1,1,1);
			Point3D p1 = new Point3D(3,0,0);
			Vector v = new Vector(p1);
		    Plane pl = new Plane(Color.green,new Material(),p,v);
		    
		    Point3D p0 = new Point3D(2,1,2);
			Vector v1 = new Vector(new Point3D(3,0,0));
			Ray ray = new Ray(p0,v1);
				
			List<Point3D> list1 = new ArrayList<Point3D>();
			List<Point3D> list2 = new ArrayList<Point3D>();
			list1 = pl.findIntersections(ray);
			list2=null;
			
			assertEquals(list1,list2);
			}

			@Test
			public	void intersections1Test() {
				
			Point3D p = new Point3D(3,1,1);
			Point3D p1 = new Point3D(3,0,0);
			Vector v = new Vector(p1);
		    Plane pl = new Plane(Color.green,new Material(),p,v);
		    
		    Point3D p0 = new Point3D(2,1,2);
			Vector v1 = new Vector(new Point3D(3,0,0));
			Ray ray = new Ray(p0,v1);
				
			List<Point3D> list1 = new ArrayList<Point3D>();
			List<Point3D> list2 = new ArrayList<Point3D>();
			list1 = pl.findIntersections(ray);
			Point3D p2 = new Point3D(3,1,2);
			list2.add(p2);
			
			assertEquals(list1,list2);
			}
	 }

