package TesterGeometries;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import Geometries.Sphere;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TesterSphere {

	@Test
	public void testGetNormal() {
	
		Sphere s = new Sphere(new Color(0),new Material(),4, new Point3D(3,3,3));
		Point3D p = new Point3D(1,1,1);
		Vector v = new Vector(new Point3D(-2,-2,-2));
		Vector v1 = s.getNormal(p);
		assertEquals(v, v1);
	}
	@Test
	 public void testFindInstraction()
	 {

		Color color = new Color(0,0,0);
		Coordinate c0 = new Coordinate(0.0);
		Coordinate c1 = new Coordinate(1);
		Coordinate c3 = new Coordinate(3);
		Coordinate c4 = new Coordinate(4);
		Coordinate _c4 = new Coordinate(3.868517091821332);
		Coordinate _c5 = new Coordinate(1.464816241512003);
		Ray ray3 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c1,c1,c1)));
	
		
		//sphere intersections
		Sphere sphere = new Sphere(color,new Material(),3.0,new Point3D(c1,c3,c4));
		List<Point3D> intersectS1 = new ArrayList<Point3D>();
		intersectS1.add(new Point3D(_c5,_c5,_c5));
		intersectS1.add(new Point3D(_c4,_c4,_c4));
		assertEquals(intersectS1,sphere.findIntersections(ray3));
		
		
		
	}

	 }
