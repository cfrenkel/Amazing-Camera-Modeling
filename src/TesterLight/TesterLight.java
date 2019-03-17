package TesterLight;
import java.awt.Color;
import org.junit.Test;

import Elements.Camera;
import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import Scene.Scene;

public class TesterLight{

	@Test
	public void rendering() {

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		  Color c = new Color(52,231,208);
		  Color c1 = new Color(0,255,0);
		  Color c2 = new Color(255,255,0);
		  Color c3 = new Color(255,128,0);
		  Color c4 = new Color(247,32,9);
		//	Material m = new Material(0.8, 1, 20, 1, 0);
			Material m1 = new Material(0.8, 1, 20, 0, 0);
	       
		  scene.addGeometry(new Sphere(c,m1, 5.0, new Point3D(0,9,-32)));
		  scene.addGeometry(new Sphere(c1,m1, 5.0, new Point3D(7,0,-32)));
		  scene.addGeometry(new Sphere(c2,m1, 5.0, new Point3D(0,-9,-32)));
		  scene.addGeometry(new Sphere(c3,m1, 5.0, new Point3D(-10,-5.2,-32)));
		Material m = new Material(0.8, 1, 20, 1, 0);
		 scene.addGeometry(new Sphere(c4,m1, 5.0, new Point3D(-10, 5.2,-32)));
		//  scene.addGeometry(new Sphere(Color.WHITE,m1, 500.0, new Point3D(-10, 0,-32)));
			Sphere sphere1 = new Sphere(Color.WHITE,m1, 500, new Point3D(0, 0.0, -1000));
			sphere1.getMaterial().setnShininess(20);
			//sphere1.setColor(new Color(0, 0, 100));
		scene.addGeometry(sphere1);
		  
			
			Triangle triangle = new Triangle(Color.black, m,new Point3D(  350/2,  350/2, -200),
					 new Point3D( -350/2, -350/2, -100),
					 new Point3D(  350/2, -350/2, -200));

           Triangle triangle2 = new Triangle(Color.black, m,new Point3D(  350/2,  350/2, -200),
						  new Point3D( -350/2,  350/2, -100),
						  new Point3D( -350/2, -350/2, -100));
           scene.addGeometry(triangle);
           scene.addGeometry(triangle2);
       	//scene.addLight(new SpotLight(new Color(0, 100, 0), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,
		//		   new Vector(new Point3D(-2, -2, -3))));
	
		 
       //    PointLight pointLight = new PointLight(new Color(255, 200, 200), new Point3D(-20, -20, 0), 1, 0.0001, 0.0001);
   		SpotLight spotLight = new SpotLight(new Color(255, 155, 255), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
   				new Vector(new Point3D(0, 0, -1)));

   	//	scene.addLight(pointLight);
   	scene.addLight(spotLight);
   		ImageWriter imageWriter = new ImageWriter("final test1", 501, 501, 501, 501);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		// render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	@Test
	public void rendering1() {

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		  Color c = new Color(52,231,208);
		  Color c1 = new Color(0,255,0);
		  Color c2 = new Color(255,255,0);
		  Color c3 = new Color(255,128,0);
		  Color c4 = new Color(247,32,9);
			Material m = new Material(0.8, 1, 20, 1, 0);
			Material m1 = new Material(0.8, 1, 20, 0, 0);
	       
		  scene.addGeometry(new Sphere(c,m1, 5.0, new Point3D(0,9,-32)));
		  scene.addGeometry(new Sphere(c1,m1, 5.0, new Point3D(7,0,-30)));
		  scene.addGeometry(new Sphere(c2,m1, 5.0, new Point3D(0,-9,-32)));
		  scene.addGeometry(new Sphere(c3,m1, 5.0, new Point3D(-10,-5.2,-35)));
		  scene.addGeometry(new Sphere(c4,m1, 5.0, new Point3D(-10, 5.2,-35)));
		
			Triangle triangle = new Triangle(Color.black, m1,new Point3D(  350/2,  350/2, -200),
					 new Point3D( -350/2, -350/2, -100),
					 new Point3D(  350/2, -350/2, -200));

           Triangle triangle2 = new Triangle(Color.black, m1,new Point3D(  350/2,  350/2, -200),
						  new Point3D( -350/2,  350/2, -100),
						  new Point3D( -350/2, -350/2, -100));
           scene.addGeometry(triangle);
           scene.addGeometry(triangle2);
           
           scene.addLight(new SpotLight(new Color(255, 155, 255), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
				new Vector(new Point3D(0, 0, -1))));
		ImageWriter imageWriter = new ImageWriter("final test2", 501, 501, 501, 501);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		// render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	@Test
	public void ReflectionTest() {

		Scene scene = new Scene();
		scene.setScreenDistance(200);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
        Color c = (Color.MAGENTA);
		Material m = new Material(0.8, 1, 20, 1, 0);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
        scene.addGeometry(new Triangle(new Color (0,0,0), m, new Point3D(-10,-10,-20),new Point3D(-10,20,-20),new Point3D(20,-10,-40)));
        scene.addGeometry(new Sphere(c,m1, 5.0, new Point3D(10,10,-25)));
		PointLight pointLight = new PointLight(new Color(255, 200, 200), new Point3D(-20, -20, 0), 1, 0.0001, 0.0001);
		SpotLight spotLight = new SpotLight(new Color(255, 155, 255), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
				new Vector(new Point3D(0, 0, -1)));
		scene.addLight(pointLight);
		scene.addLight(spotLight);
		ImageWriter imageWriter = new ImageWriter("Reflection test", 501, 501, 501, 501);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		// render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	@Test
	public void RefractionTest() {
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		Material m = new Material(0.8, 1, 20, 0, 1);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
        scene.addGeometry(new Sphere((new Color(200,0,0)),m1,5.0 ,new Point3D(0,0,-20)));
        scene.addGeometry(new Sphere((new Color(0,0,100)),m,15.0 ,new Point3D(0,0,-20)));
		PointLight pointLight = new PointLight(new Color(0, 255, 200), new Point3D(-30, -30, 0), 1, 0.0001, 0.0001);
		scene.addLight(pointLight);
		ImageWriter imageWriter = new ImageWriter("Refraction test", 501, 501, 501, 501);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		// render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	@Test
	public void rendering3(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0)))); 
		Material m = new Material(0.8, 1, 20, 0.5, 0.5);
		Material m1 = new Material(0.8, 1, 20, 0, 0);
		Sphere sphere = new Sphere(new Color(0), m,400, new Point3D(0.0, 0.0, -500));
		sphere.getMaterial().setnShininess(20);
		sphere.setColor(new Color(0, 0, 100));
		Sphere sphere1 = new Sphere(new Color(0), m1,500, new Point3D(-1000, 0.0, -1500));
		sphere1.getMaterial().setnShininess(20);
		sphere1.setColor(new Color(0, 0, 100));
		Sphere sphere4= new Sphere(new Color(0), m1,250, new Point3D(500,600 , -800));
		sphere4.getMaterial().setnShininess(20);
		sphere4.setColor(new Color(0, 0, 100));
		Sphere sphere5= new Sphere(new Color(0), m1,250, new Point3D(500,-600 , -800));
		sphere5.getMaterial().setnShininess(20);
		sphere5.setColor(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addGeometry(sphere1);
		scene.addGeometry(sphere4);
		scene.addGeometry(sphere5);
    
		Material m2 = new Material(0.8, 1, 20, 1, 0);
		Triangle triangle = new Triangle(new Color(0), m2,new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0), m2,new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		
		scene.addLight(new SpotLight(new Color(0, 255, 255), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,
				   new Vector(new Point3D(-2, -2, -3))));
			ImageWriter imageWriter = new ImageWriter("final test3", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		render.getImageWriter().writeToimage();		
	}
	@Test
	public void shadowTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0)))); 
		Sphere sphere = new Sphere(new Color(0), new Material(),500, new Point3D(0.0, 0.0, -1000));
		sphere.getMaterial().setnShininess(20);
		sphere.setColor(new Color(0, 0, 100));	
		scene.addGeometry(sphere);
		
		Triangle triangle = new Triangle(new Color(0), new Material(),new Point3D(  3500,  3500, -2000),
				 						 new Point3D( -3500, -3500, -1000),
				 						 new Point3D(  3500, -3500, -2000));

		Triangle triangle2 = new Triangle(new Color(0), new Material(),new Point3D(  3500,  3500, -2000),
				  						  new Point3D( -3500,  3500, -1000),
				  						  new Point3D( -3500, -3500, -1000));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);	
		scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100), 0, 0.000001, 0.0000005,
				   new Vector(new Point3D(-2, -2, -3))));

		ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);
		Render render = new Render(scene, imageWriter);
		render.renderImage();
		render.getImageWriter().writeToimage();
		
	}
	@Test 
	public void emmissionTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(50);
		 scene.setCamera(new Camera(
		    		new Point3D(0, 0, 0), 
		    		new Vector(new Point3D(0,0,-1)), 
		    		new Vector(new Point3D(0,1,0))));
		scene.addGeometry(new Sphere(new Color(255,255,255), new Material() ,35, new Point3D(0.0, 0.0, -50)));
		
		Triangle triangle = new Triangle(new Color(0), new Material(), new Point3D( 100, 0, -49),
				 						 new Point3D(  0, 100, -49),
				 						 new Point3D( 100, 100, -49));
		
		Triangle triangle2 = new Triangle(new Color(0), new Material(), new Point3D( 100, 0, -49),
				 			 			  new Point3D(  0, -100, -49),
				 			 			  new Point3D( 100,-100, -49));
		triangle2.setColor(new Color (50, 200, 50));
		
		Triangle triangle3 = new Triangle(new Color(0), new Material(), new Point3D(-100, 0, -49),
				 						  new Point3D(  0, 100, -49),
				 						  new Point3D(-100, 100, -49));
		triangle3.setColor(new Color (50, 50, 200));
		
		Triangle triangle4 = new Triangle(new Color(0), new Material(),new Point3D(-100, 0, -49),
				 			 			  new Point3D(  0,  -100, -49),
				 			 			  new Point3D(-100, -100, -49));
		triangle4.setColor(new Color (200, 50, 50));
		
		scene.addGeometry(triangle);
		scene.addGeometry(triangle2);
		scene.addGeometry(triangle3);
		scene.addGeometry(triangle4);
		
		ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
		
		Render render = new Render(scene,imageWriter );
		
		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	@Test
	public void pointLightTest(){
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));
		Sphere sphere = new Sphere (new Color(0), new Material(),800, new Point3D(0.0, 0.0, -1000));
		sphere.getMaterial().setnShininess(20);
		sphere.setColor(new Color(0, 0, 100));
		scene.addGeometry(sphere);
		scene.addLight(new PointLight(new Color(255,100,100), new Point3D(-200, -200, -100), 
					   0, 0.00001, 0.000005));
	
		ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);
		
		Render render = new Render( scene, imageWriter);
		
		render.renderImage();
		render.getImageWriter().writeToimage();
		
		
	}
	@Test
	public void lightTest() {
		
		Scene scene = new Scene();
		scene.setScreenDistance(100);
		scene.setCamera(new Camera(
	    		new Point3D(0, 0, 0), 
	    		new Vector(new Point3D(0,0,-1)), 
	    		new Vector(new Point3D(0,1,0))));		

		Material m = new Material(0.8, 0.9, 100, 0,0);

		scene.addGeometry(new Sphere(new Color(0, 0, 150),m,(double) 150,  new Point3D(0.0, 0.0, -200) ));
	PointLight pointLight = new PointLight(new Color(255, 200, 200), new Point3D(-50, -50, 0), 1, 0.0001, 0.0001);
		SpotLight spotLight = new SpotLight(new Color(255, 155, 255), new Point3D(-30, -30, 0), 1.0, 0.005, 0.0000001,
				new Vector(new Point3D(0, 0, -1)));

		scene.addLight(pointLight);
		scene.addLight(spotLight);

		ImageWriter imageWriter = new ImageWriter("Render test lights", 501, 501, 501, 501);

		Render render = new Render(scene, imageWriter);

		render.renderImage();
		render.printGrid(50);
		render.getImageWriter().writeToimage();
	}
	    @Test
	public void spotLightTest()
	        {
			
			Scene scene = new Scene();
scene.setScreenDistance(100);
scene.setCamera(new Camera(
		new Point3D(0, 0, 0), 
		new Vector(new Point3D(0,0,-1)), 
		new Vector(new Point3D(0,1,0))));		


	                Material m1=new Material();
			Sphere sphere = new Sphere(new Color(85,140,140),m1,680.0,new Point3D((0.0),(0.0),(-1000.0)) );
			scene.addGeometry(sphere);
			
	                scene.addLight(new SpotLight(new Color(230, 95, 95),
	                		new Point3D((-200.0),(200.0),(-100.0)),  0.0, 0.00001, 0.000005,
	                         new Vector(new Point3D((2.0),(2.0),(-3.0)))));
	                       
		
			ImageWriter imageWriter = new ImageWriter("Spot Test", 500, 500, 500, 500);
			
			Render render = new Render(scene,imageWriter);
			
			render.renderImage();	
			render.getImageWriter().writeToimage();
		}
	    /*
	    	@Test
		public void rendering0() {

			Scene scene = new Scene();
			scene.setScreenDistance(100);
			scene.setCamera(new Camera(
		    		new Point3D(0, 0, 0), 
		    		new Vector(new Point3D(0,0,-1)), 
		    		new Vector(new Point3D(0,1,0))));
			  Color c = new Color(52,231,208);
			  Color c1 = new Color(0,255,0);
			  Color c2 = new Color(255,255,0);
			  Color c3 = new Color(255,128,0);
			  Color c4 = new Color(247,32,9);
			//	Material m = new Material(0.8, 1, 20, 1, 0);
				Material m1 = new Material(0.8, 1, 20, 0, 0);
		        scene.addGeometry(new Sphere(c1,m1, 15.0, new Point3D(0,0,-10))); 
			  scene.addGeometry(new Sphere(c,m1, 20.0, new Point3D(0,0,-25)));
			
			//  scene.addGeometry(new Sphere(c2,m1, 10.0, new Point3D(-5,5.2,0)));
		//	  scene.addGeometry(new Sphere(c3,m1, 5.0, new Point3D(15,5.2,0)));
		
			//Material m = new Material(0.8, 1, 20, 1, 0);
			/* scene.addGeometry(new Sphere(c4,m1, 5.0, new Point3D(-10, 5.2,-32)));
			//  scene.addGeometry(new Sphere(Color.WHITE,m1, 500.0, new Point3D(-10, 0,-32)));
				Sphere sphere1 = new Sphere(Color.WHITE,m1, 500, new Point3D(0, 0.0, -1000));
				sphere1.getMaterial().setnShininess(20);
				//sphere1.setColor(new Color(0, 0, 100));
			scene.addGeometry(sphere1);*/
	     	//SpotLight spotLight = new SpotLight(new Color(255, 155, 255), new Point3D(-20, -20, 0), 1.0, 0.005, 0.0000001,
	   		//		new Vector(new Point3D(0, 0, -1)));

	   	//	scene.addLight(pointLight);
	     	
	   	/*scene.addLight(spotLight);
	   		ImageWriter imageWriter = new ImageWriter("final test0", 501, 501, 501, 501);

			Render render = new Render(scene, imageWriter);

			render.renderImage();
			// render.printGrid(50);
			render.getImageWriter().writeToimage();
		}
*/
		
		
		
	}
