package TesterGeometries;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Geometries.Triangle;
import primitives.Coordinate;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class TesterTriangle {

	@Test
	public void testGetNormal() {
		Triangle t = new Triangle(new Color(0), new Material(),new Point3D(1,1,1), new Point3D(2,2,2), new Point3D(3,3,3));
		Point3D p1 = new Point3D(1, 2, 3);
		Vector v = t.getNormal(p1);
		Vector v1 = new Vector(new Point3D(-1/Math.sqrt(6),2/Math.sqrt(6),-1/Math.sqrt(6)));
	    assertEquals(v, v1);
	}
	
	@Test
	 public void testFindInstraction()
	 {
		 
				Point3D p1= new Point3D(1,2,3);
				Point3D p2= new Point3D(2,2,3);
				Point3D p3= new Point3D(1,2,1);
				Point3D p4= new Point3D(0,1,2);
				Vector v = new Vector(new Point3D(4,2,3));
				Ray r = new Ray(p4,v);
				
				
			    Triangle t = new Triangle(Color.green,new Material(),p1,p2,p3);
			    t.findIntersections(r);
			    
			    List<Point3D> list1 = new ArrayList<Point3D>();
				List<Point3D> list2 = new ArrayList<Point3D>();
				list1 = t.findIntersections(r);
				list2=null;
				
				assertEquals(list1,list2);

	 }
	@Test
	public void findIntersectionsTest() 
	{
	Color color = new Color(0,0,0);
	Coordinate c0 = new Coordinate(0.0);
	Coordinate c1 = new Coordinate(1);
	Coordinate c2 = new Coordinate(2);
	Coordinate c_2 = new Coordinate(-2);
    Ray ray2 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c0,c1,c0)));
	Point3D p1 = new Point3D(c2,c2,c_2);
	Point3D p2 = new Point3D(c_2,c2,c_2);
	Point3D p3 = new Point3D(c0,c2,c2);
	//Point3D p4 = new Point3D(c1,c2,c0);
	//Ray ray3 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c1,c1,c1)));
	Triangle triangle1 = new Triangle(color,new Material(),p1,p2,p3);
	//Triangle triangle2 = new Triangle(p1,p2,p4,color);
    List<Point3D> intersectT2 = new ArrayList<Point3D>();
	intersectT2.add(new Point3D(c0,c2,c0));
	assertEquals(intersectT2,triangle1.findIntersections(ray2));
	//assertEquals(intersectT2,triangle2.findIntersections(ray3));
	}
	
	@Test
	public void findIntersectionsTest3() {
	Color color = new Color(0,0,0);
	Coordinate c0 = new Coordinate(0.0);
	Coordinate c1 = new Coordinate(1);
	Coordinate c2 = new Coordinate(2);
    Coordinate c_2 = new Coordinate(-2);
	Ray ray2 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c0,c1,c0)));
	Point3D p1 = new Point3D(c2,c2,c_2);
	Point3D p2 = new Point3D(c_2,c2,c_2);
	Point3D p3 = new Point3D(c0,c2,c2);
	//Point3D p4 = new Point3D(c1,c2,c0);
	//Ray ray3 = new Ray(new Point3D(c0,c0,c0), new Vector(new Point3D(c1,c1,c1)));
	Triangle triangle1 = new Triangle(color,new Material(),p1,p2,p3);
	//Triangle triangle2 = new Triangle(p1,p2,p4,color);
     List<Point3D> intersectT2 = new ArrayList<Point3D>();
	intersectT2.add(new Point3D(c0,c2,c0));
	assertEquals(intersectT2,triangle1.findIntersections(ray2));
	//assertEquals(intersectT2,triangle2.findIntersections(ray3));
	}
	 @Test
     public void testFindIntersections1() throws Exception
     {
     Point3D p1=new Point3D(new Coordinate(-2.0),new Coordinate(2.0),new Coordinate(1.0));
     Point3D p2=new Point3D(new Coordinate(2.0),new Coordinate(2.0),new Coordinate(1.0));
     Point3D p3=new Point3D(new Coordinate(0.0),new Coordinate(-4.0),new Coordinate(1.0));
     Triangle tmp=new Triangle(Color.BLACK,new Material(),p1,p2,p3);
     Ray r=new Ray(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(0.0)),
             new Vector(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(1.0))));
     List<Point3D> il=tmp.findIntersections(r);
     List<Point3D> iltmp=new ArrayList<>();
     iltmp.add(new Point3D(new Coordinate(0.0),new Coordinate(0.0),new Coordinate(1.0)));
     assertEquals(iltmp,il);
     }
        

     @Test
     public void testFindIntersections2() throws Exception{
     Point3D p1=new Point3D(new Coordinate(-2.0),new  Coordinate(2.0),new Coordinate(1.0));
     Point3D p2=new Point3D(new Coordinate(2.0),new  Coordinate(2.0),new Coordinate(1.0));
     Point3D p3=new Point3D(new Coordinate(0.0),new  Coordinate(-4.0),new Coordinate(1.0));
     Triangle tmp=new Triangle(Color.BLACK,new Material(),p1,p2,p3);
     Ray r=new Ray(new Point3D(new Coordinate(0.0),new  Coordinate(0.0),new Coordinate(0.0)),
             new Vector(new Point3D(new Coordinate(0.0),new  Coordinate(0.0),new Coordinate(1.0))));
     List<Point3D> il=tmp.findIntersections(r);
     List<Point3D> iltmp=new ArrayList<>();
     iltmp.add(new Point3D(new Coordinate(0.0),new  Coordinate(0.0),new Coordinate(1.0)));
     assertEquals(iltmp,il);
     } 
 }

