package Tester;

import primitives.Material;
/*import java.awt.Color;


import Geometries.Cylinder;
		import Geometries.Plane;
        import Geometries.Sphere;
		import Geometries.Triangle;
		import primitives.Coordinate;
		import primitives.Point2D;*/
		import primitives.Point3D;
		import primitives.Vector;

import java.awt.Color;

import Elements.Camera;
		import Geometries.Sphere;
	    import Renderer.ImageWriter;
		import Renderer.Render;
		import Scene.Scene;
public class Tester {
			public static void main(String[] args) {
				
				/*Coordinate c1 = new Coordinate(3);
				Coordinate c2 = new Coordinate(5);
				Coordinate c3 = new Coordinate(8);
				
				
				Point2D p1 = new Point2D(c1, c2);
				Point3D p2 = new Point3D(1,2,3);
				Point3D p3 = new Point3D(c3,c2,c1);
				Point2D p4 = new Point2D();
				Point3D p5 = new Point3D();
				Point3D p6 = new Point3D(4,5,6);
				Point3D p7 = new Point3D(1,2,3);
				
				Vector v0 = new Vector();
				Vector v1 = new Vector(p3);
				Vector v2 = new Vector(new Point3D(2,4,6));
				
				Ray r0= new Ray();
				Ray r1= new Ray(p2,v1);
				
				System.out.println(p1);
				System.out.println(p2);
				System.out.println(p3);
				System.out.println(p4);
				System.out.println(p5);
				System.out.println(v0);
				System.out.println(r0);
				System.out.println(v1);
				System.out.println(v2);
				System.out.println(r1);

				
			
				if (p3.equals(p2))
					System.out.println("yes");
				else
					System.out.println("no");
				
				
				System.out.println(c1.add(c2));
				System.out.println(c3.subtract(c2));
			
				System.out.println(p2.add(p3));
				System.out.println(p3.subtract(p2));

				System.out.println(p3.distance(p2));
				
				System.out.println("VECTOR");
				System.out.println(v1.multScalar(3));
				System.out.println(v1.equals(v2));
				System.out.println(v1.length());
				System.out.println(v1.dotProduct(v2));
				System.out.println(v1.add(v2));
				System.out.println(v1.move(5));
				System.out.println(v1.normalize());
				System.out.println(v1.subtract(v2));
				
				
				Color c = Color.BLUE;
				Triangle t1= new Triangle(c,p2,p6,p7);
				Triangle t2= new Triangle(c,p2,p6,p7);
				Triangle t3= new Triangle();
				
				Plane n1= new Plane(c,p2, v1);
				Plane n2= new Plane(c,p2, v1);
				Plane n3= new Plane(c,p6, v2);
				Plane n4= new Plane();
 
				double d=2;
				double r = d;
				double r11 = 3.0;
				Sphere s1= new Sphere();
				Sphere s2= new Sphere(c,r,p6);
				Sphere s3= new Sphere(c,r11,p6);
				Sphere s4= new Sphere(c,r,p6);

				Cylinder l1= new Cylinder();
				Cylinder l2= new Cylinder(c,r,p7,v1);
				Cylinder l3= new Cylinder(c,r11,p6,v2);
				Cylinder l4= new Cylinder(c,r,p2,v1);
				
			
				
				System.out.println(t1);
				System.out.println(t2);
				System.out.println(t3);
				System.out.println(t1.equals(t2));
				
				System.out.println(n1);
				System.out.println(n2);
				System.out.println(n3);
				System.out.println(n4);
				System.out.println(n1.equals(n2));
				
				System.out.println(s1);
				System.out.println(s2);
				System.out.println(s3);
				System.out.println(s4);
				System.out.println(s1.equals(s2));
				System.out.println(s4.equals(s3));
				
				System.out.println(l1);
				System.out.println(l2);
				System.out.println(l3);
				System.out.println(l4);
				System.out.println(l1.equals(l2));
				System.out.println(l4.equals(l2));
				
			    Ray r1 = new Ray(new Point3D(0,0,0), new Vector(new Point3D(3,3,-6)));
			    System.out.println(r1);
			      Camera c = new Camera(new Point3D(0,0,0),
			    		  new Vector(new Point3D(0,0,1)),
			    		  new Vector(new Point3D(0,1,0)),
			    		  new Vector(new Point3D(1,0,0)));
			      Ray r2 = c.constructRayThroughPixel(3, 3, 2, 3, 3, 9, 9);
			      System.out.println(r2);*/
			
		
				Material m = new Material();
				Scene scene = new Scene();
				scene.setScreenDistance(50);
				Vector v1 = new Vector(new Point3D(0,1,0));
				Vector v2 = new Vector(new Point3D(0,0,-1));
				Vector v3 = v1.CrossProduct(v2);
				scene.setCamera(new Camera(new Point3D(0,0,0),v1,v2,v3 ));
				
				scene.addGeometry(new Sphere(new Color(0),m, 100, new Point3D(0.0, 0.0, -150)));
				/*Triangle triangle = new Triangle(new Color(0),
						                         new Point3D( 100, 100, -49),
						 						 new Point3D(  0, 100, -49),
						 						 new Point3D( 100, 100, -49));
				
				Triangle triangle2 = new Triangle(new Color(0),
		                                       new Point3D( 100, 100, -49),
						                       new Point3D(  0, 100, -49),
						                       new Point3D( 100, 100, -49));*/
				
		/*Triangle triangle4 = new Triangle(new Color(0),
		                                          new Point3D(-100, 0, -49),
						 			 			  new Point3D(  0,  -100, -49),
						 			 			  new Point3D(-100, -100, -49));
				
				
				scene.addGeometry(triangle2);
				scene.addGeometry(triangle3);
				scene.addGeometry(triangle4);*/
				//scene.addGeometry(triangle2);
				ImageWriter imageWriter = new ImageWriter("Render test3", 500, 500, 500, 500);
				
				Render render = new Render(scene,imageWriter);	
				render.renderImage();
			   // render.printGrid(50);
				render.getImageWriter().writeToimage();
			}
					
				

			}




