package TesterRenderer;

import java.awt.Color;

import org.junit.Test;

import Elements.Camera;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class TestRender {

	@Test
	public void basicRendering(){
	Scene scene = new Scene();
	 scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));  
	scene.setScreenDistance(50);
	Color c1=Color.pink;
    Color c2=Color.yellow;
    Color c3=Color.green;
    Color c4=Color.red;
    Color c5=Color.blue;
	scene.addGeometry(new Sphere(c1,new Material(),35, new Point3D(0.0, 0.0, -50)));
	Triangle triangle = new Triangle(c5,new Material(),
			                         new Point3D( 100, 0, -49),
			 						 new Point3D(  0, 100, -49),
			 						 new Point3D( 100, 100, -49));

	Triangle triangle2 = new Triangle(c2,new Material(),
                                      new Point3D( 100, 0, -49),
			 			 			  new Point3D(  0, -100, -49),
			 			 			  new Point3D( 100,-100, -49));
	
	Triangle triangle3 = new Triangle(c3,new Material(),
                                      new Point3D(-100, 0, -49),
			 						  new Point3D(  0, 100, -49),
			 						  new Point3D(-100, 100, -49));
	
	Triangle triangle4 = new Triangle(c4,new Material(),
                                      new Point3D(-100, 0, -49),
			 			 			  new Point3D(  0,  -100, -49),
			 			 			  new Point3D(-100, -100, -49));
	
	scene.addGeometry(triangle);
	scene.addGeometry(triangle2);
	scene.addGeometry(triangle3);
	scene.addGeometry(triangle4);
	
	ImageWriter imageWriter = new ImageWriter("Render test", 500, 500, 500, 500);
	
	Render render = new Render(scene,imageWriter);	
	render.renderImage();
    render.printGrid(50);
	render.getImageWriter().writeToimage();
     
}
	@Test
	public void basicRendering1(){
	Scene scene = new Scene();
	 scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));  
	scene.setScreenDistance(50);
	Color c1=Color.pink;
    Color c2=Color.yellow;
    Color c3=Color.green;
    Color c4=Color.red;
    Color c5=Color.blue;
    Triangle triangle = new Triangle(c5,new Material(),
			                         new Point3D(  100,-100, -49),
			 						 new Point3D(  -100, -100, -49),
			 						 new Point3D( 100, 100, -49));

	Triangle triangle2 = new Triangle(c5,new Material(),
                                      new Point3D(  -100, -100, -49),
			 			 			  new Point3D( 100, 100, -49),
			 			 			  new Point3D(-100, 100, -49));
	
	Triangle triangle3 = new Triangle(c3,new Material(),
                                      new Point3D(-100, -100, -49),
			 						  new Point3D(   -100,100, -49),
			 						  new Point3D( -200,0, -49));
	
	Triangle triangle4 = new Triangle(c4,new Material(),
                                      new Point3D( 101.03*2,-6.97*2, -49),
			 			 			  new Point3D(    100.41*2,7.98*2, -49),
			 			 			  new Point3D( 100,-7.32*2, -49));
	Triangle triangle5 = new Triangle(c4,new Material(),
            new Point3D( 100,-7.32*2, -49),
			  new Point3D(   100.41*2, 7.98*2, -49),
			  new Point3D( 100,7.03*2, -49));
	scene.addGeometry(triangle);
	scene.addGeometry(triangle2);
	scene.addGeometry(triangle3);
	scene.addGeometry(triangle4);
	scene.addGeometry(triangle5);
	ImageWriter imageWriter = new ImageWriter("Render test svivon", 500, 500, 500, 500);
	Render render = new Render(scene,imageWriter);	
	render.renderImage();
    render.printGrid(50);
	render.getImageWriter().writeToimage();
	}	
@Test
	public void basicRendering2(){
	Scene scene = new Scene();
	 scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));  
	scene.setScreenDistance(50);
	Color c1=Color.pink;
    Color c2=Color.yellow;
    Color c3=Color.green;
    Color c4=Color.red;
    Color c5=Color.blue;
Triangle triangle = new Triangle(c1,new Material(),
			                         new Point3D( -14.1*5, 46.4*5, -49),
			 						 new Point3D(  -29.4*5, 31.4*5, -49),
			 						 new Point3D( -13.1*5, 30.4*5, -49));

	Triangle triangle2 = new Triangle(c1,new Material(),
                                      new Point3D(  -29.4*5, 31.4*5, -49),
			 			 			  new Point3D( -13.1*5, 30.4*5, -49),
			 			 			  new Point3D( -12.9*5,4.4*5, -49));
	
	Triangle triangle3 = new Triangle(c1,new Material(),
                                      new Point3D(  -29.4*5, 31.4*5, -49),
			 						  new Point3D( -12.9*5,04.4*5, -49),
			 						  new Point3D(-29.6*5, 3.8*5, -49));
	
	Triangle triangle4 = new Triangle(c1,new Material(),
                                      new Point3D( -12.9*5,4.4*5, -49),
			 			 			  new Point3D(-29.6*5, 3.8*5, -49),
			 			 			  new Point3D(-13.7*5, -22.8*5, -49));
	Triangle triangle5 = new Triangle(c1,new Material(),
            new Point3D( -30.6*5,-21.8*5, -49),
			  new Point3D(-29.6*5, 3.8*5, -49),
			  new Point3D(-13.7*5, -22.8*5, -49));

	Triangle triangle6 = new Triangle(c1,new Material(),
            new Point3D( -30.6*5,-21.8*5, -49),
			  new Point3D(-14.7*5, -44.2*5, -49),
			  new Point3D(-13.7*5, -22.8*5, -49));

	Triangle triangle7 = new Triangle(c4,new Material(),
            new Point3D( -9.3*5,46.2*5, -49),
			  new Point3D(-8.7*5, 3.8*5, -49),
			  new Point3D(29*5, 4*5, -49));
	Triangle triangle8 = new Triangle(c3,new Material(),
            new Point3D( -8.5*5,0, -49),
			  new Point3D(30.0*5, 0, -49),
			  new Point3D(-10.5*5, -45.0*5, -49));
	Triangle triangle9 = new Triangle(c5,new Material(),
            new Point3D( 27.8*5,-15.6*5, -49),
			  new Point3D(28.2*5, -27.2*5, -49),
			  new Point3D(21.4*5, -15.4*5, -49));
	Triangle triangle10 = new Triangle(c5,new Material(),
            new Point3D(21.4*5, -15.4*5, -49),
			  new Point3D(28.2*5, -19.2*5, -49),
			  new Point3D(16.4*5, -15.1*5, -49));
	scene.addGeometry(triangle);
	scene.addGeometry(triangle2);
	scene.addGeometry(triangle3);
	scene.addGeometry(triangle4);
	scene.addGeometry(triangle5);
	scene.addGeometry(triangle6);
	scene.addGeometry(triangle7);
	scene.addGeometry(triangle8);
	scene.addGeometry(triangle9);
	scene.addGeometry(triangle10);
	
	ImageWriter imageWriter = new ImageWriter("Render test oniya", 500, 500, 500, 500);
	
	Render render = new Render(scene,imageWriter);	
	render.renderImage();
    render.printGrid(50);
	render.getImageWriter().writeToimage();
     
}
}