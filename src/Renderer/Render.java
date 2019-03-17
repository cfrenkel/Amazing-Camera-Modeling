package Renderer;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Elements.LightSource;
import Scene.Scene;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import Geometries.FlatGeomtry;
import Geometries.Geomtry;

public class Render {
	//*****properties*********
	private Scene scene;
	private ImageWriter imageWriter;
	//*****get and set*********
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public ImageWriter getImageWriter() {
		return imageWriter;
	}
	public void setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
	}
	//******Constructors********
	public Render(Scene scene, ImageWriter imageWriter) {
		this.scene = scene;
		this.imageWriter = imageWriter;
	}
	//******basic function********
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Render other = (Render) obj;
		if (imageWriter == null) {
			if (other.imageWriter != null)
				return false;
		} else if (!imageWriter.equals(other.imageWriter))
			return false;
		if (scene == null) {
			if (other.scene != null)
				return false;
		} else if (!scene.equals(other.scene))
			return false;
		return true;
	}
	//******renderer function************
	public void renderImage()
	{
		Ray ray = new Ray();
		Ray ray1 = new Ray();
		Ray ray2 = new Ray();
		Ray ray3 = new Ray();
		Ray ray4 = new Ray();
		//Map<Geomtry,List<Point3D>> intersectionPoints = new HashMap<Geomtry,List<Point3D>>();
		//Map<Geomtry,Point3D> closestPoint = new HashMap<Geomtry,Point3D>();
		for(int i=0; i<imageWriter.getNx();i++)
		{
			for(int j=0;j<imageWriter.getNy();j++)
			{
				 ray = scene.getCamera().constructRayThroughPixel(
                          imageWriter.getNx(), imageWriter.getNy(), 
						  j, i,scene.getScreenDistance(), imageWriter.getWidth(),imageWriter.getHeight());
				 Map<Geomtry,List<Point3D>> intersectionPoints =getSceneRayIntersections(ray);
				 double d= (imageWriter.getWidth()/imageWriter.getNx())/2;
				 Point3D p1 = new Point3D(d,d,0);
				 Point3D p2 = new Point3D(d,-d,0);
				 Point3D p3 = new Point3D(-d,d,0);
				 Point3D p4 = new Point3D(-d,-d,0);
				 ray1 = new Ray(ray.getPOO().add(p1), ray.getDirection());
				 ray2 = new Ray(ray.getPOO().add(p2), ray.getDirection());
				 ray3 = new Ray(ray.getPOO().add(p3), ray.getDirection());
				 ray4 = new Ray(ray.getPOO().add(p4), ray.getDirection());
				 Map<Geomtry,List<Point3D>> intersectionPoints1 =getSceneRayIntersections(ray1);
				 Map<Geomtry,List<Point3D>> intersectionPoints2 =getSceneRayIntersections(ray2);
				 Map<Geomtry,List<Point3D>> intersectionPoints3 =getSceneRayIntersections(ray3);
				 Map<Geomtry,List<Point3D>> intersectionPoints4 =getSceneRayIntersections(ray4);
					
				if (intersectionPoints.isEmpty())
					imageWriter.writePixel(j, i, scene.getBackground());
				else 
				{
					 Color c = new Color(0,0,0),c1= new Color(0,0,0),c2= new Color(0,0,0),c3= new Color(0,0,0),c4= new Color(0,0,0);
				     Map<Geomtry, Point3D> closestPoint = getClosestPoint(intersectionPoints); 
				     Map<Geomtry, Point3D> closestPoint1 = getClosestPoint(intersectionPoints1); 
				     Map<Geomtry, Point3D> closestPoint2 = getClosestPoint(intersectionPoints2); 
				     Map<Geomtry, Point3D> closestPoint3 = getClosestPoint(intersectionPoints3); 
				     Map<Geomtry, Point3D> closestPoint4 = getClosestPoint(intersectionPoints4); 
	                    for(Entry<Geomtry, Point3D> entry: closestPoint.entrySet())
	                    	 c = calcColor(entry.getValue(), entry.getKey(), ray);
	                    for(Entry<Geomtry, Point3D> entry: closestPoint1.entrySet())
	                    	 c1 = calcColor(entry.getValue(), entry.getKey(), ray1);
	                    for(Entry<Geomtry, Point3D> entry: closestPoint2.entrySet())
	                    	 c2 = calcColor(entry.getValue(), entry.getKey(), ray2);
	                    for(Entry<Geomtry, Point3D> entry: closestPoint3.entrySet())
	                    	 c3 = calcColor(entry.getValue(), entry.getKey(), ray3);
	                    for(Entry<Geomtry, Point3D> entry: closestPoint4.entrySet())
	                    	 c4 = calcColor(entry.getValue(), entry.getKey(), ray4);
	                    c = mult(c,0.8); c1 = mult(c,0.05);
	                    c2 = mult(c,0.05);  c3 = mult(c,0.05);
	                    c4 = mult(c,0.05);
	                    c = add(c,add (add(c1,c2),add(c4,c3)));
	                        imageWriter.writePixel((int) j, (int) i,c);
	                    
			
				}
				
			}
		}
	}
    public void printGrid(int interval)
    {
        for(int i=0; i<500 ; i+=interval)
            for(int j=0;j<500; j++)
                this.imageWriter.writePixel(i, j, Color.WHITE);
        for(int i=0; i<500 ; i++)
            for(int j=0;j<500; j+=interval)
                this.imageWriter.writePixel(i, j, Color.WHITE);

    }
	private Map<Geomtry,List<Point3D>> getSceneRayIntersections(Ray r)
	{
		Iterator<Geomtry> geometries = scene.getGeometryIterator();
		Map<Geomtry,List<Point3D>> intersectionPoints = new HashMap<Geomtry,List<Point3D>>();

		while (geometries.hasNext())
		{
		Geomtry geometry = geometries.next();
		List<Point3D> geometryIntersectionPoints =
		 geometry.findIntersections(r);
		if(geometryIntersectionPoints!=null)
		intersectionPoints.put(geometry,  geometryIntersectionPoints );
		}
		return intersectionPoints; 
	}
	private int RECURSION_LEVEL=3;
	private Color calcColor(Point3D p, Geomtry g, Ray inRay)
	{
		 return calcColor( p,  g,  inRay,0);		
	}
	private Color calcColor(Point3D p, Geomtry g, Ray inRay, int level)
	{
		if (level == RECURSION_LEVEL) return new Color(0, 0, 0);
		Color ambientLight =  scene.getAmbientLight().getIntensity(); 
		Color emissionLight = g.getColor();
		
		Iterator<LightSource> lights = scene.getLightIterator();
		Color diffuseLight  = new Color(0,0,0);
		Color specularLight = new Color(0,0,0);
		while(lights.hasNext())
		{ 
			LightSource lights1 = lights.next();
			if(!occludd(lights1,p,g)){
			 
				diffuseLight = add(diffuseLight ,calcDiffusiveComp(g.getMaterial().getKd(),
				               g.getNormal(p),
				               lights1.getL(p),
				               new Vector(p.subtract(scene.getCamera().getP0())).normalize(),
				               lights1.getIntensity(p)));
				specularLight = add(specularLight,calcSpecularComp(g.getMaterial().getKs(),
					                                new Vector(p.subtract(scene.getCamera().getP0())).normalize(),
					                            	g.getNormal(p),
					                            	lights1.getL(p),
					                            	g.getMaterial().getnShininess(),
					                            	lights1.getIntensity(p)));
			}
		}
		Color refractedColor = new Color(0,0,0);
		Color reflectedColor = new Color(0,0,0);
		Ray reflectedRay = constructReflectedRay(g.getNormal(p), p, inRay);
		Map<Geomtry,Point3D>reflectedEntry = getClosestPoint(getSceneRayIntersections(reflectedRay));
		
           for(Entry<Geomtry, Point3D> entry: reflectedEntry.entrySet())
        	  reflectedColor= calcColor(entry.getValue(), entry.getKey(), reflectedRay, level+1);
        double kr = g.getMaterial().getKr();
		Color reflectedLight = mult( reflectedColor,kr);
		// Recursive call for a retracted ray
		Ray refractedRay = constructRefractedRay(g.getNormal(p), p, inRay);
		Map<Geomtry,Point3D> refractedEntry =getClosestPoint(getSceneRayIntersections(refractedRay));
     		 for(Entry<Geomtry, Point3D> entry: refractedEntry.entrySet())
		refractedColor = calcColor(entry.getValue(), entry.getKey(), refractedRay, level+1);
    	double kt = g.getMaterial().getKt();
		Color refractedLight =mult ( refractedColor, kt);
		return add( refractedLight, add (ambientLight, add(add(emissionLight,diffuseLight),add(specularLight,reflectedLight))));			
		
	}
	Color add (Color c1, Color c2)
	{
		int r =(int)( c1.getRed()+c2.getRed());
		if(r>255) r=255; if(r<0) r = -1*r;
		int g =(int)( c1.getGreen()+c2.getGreen());
		if(g>255) g=255; if(g<0) g = -1*g;
		int b =(int)( c1.getBlue()+c2.getBlue());
		if(b>255) b=255; if(b<0) b = -1*b;
		return new Color(r,g,b);
		
		
	}
	Color mult(Color c, double d)
	{
		int r =(int)( c.getRed()*d);
		if(r>255) r=255; if(r<0) r = -1*r;
		int g =(int)( c.getGreen()*d);
		if(g>255) g=255; if(g<0) g = -1*g;
		int b =(int)( c.getBlue()*d);
		if(b>255) b=255; if(b<0) b = -1*b;
		return new Color(r,g,b);
	}
	private Color calcSpecularComp(double ks, Vector vector, Vector normal,Vector l, int n, Color intensity) {
		vector=vector.multScalar(-1).normalize();
		l=l.normalize();
		normal=normal.normalize();
		Vector R = l.subtract(normal.multScalar(2*l.dotProduct(normal)));
		//Vector R = vector.subtract(normal.multScalar(2*vector.dotProduct(normal)));
	    double cos = R.dotProduct(vector);
	    //if(cos>0) return Color.black;
	    
		double v = Math.pow( cos,n) ;
		double f = v*ks*intensity.getRed();
		int r = (int)(v*ks*intensity.getRed());
		if(r>255) r=255; if(r<0) r=0;
		int g =   (int)(v*ks*intensity.getGreen());
		if(g>255) g=255;if(g<0) g=0;
		int b = (int)(v*ks*intensity.getBlue());
		if(b>255) b=255;if(b<0) b=0;
		return new Color(r,g,b);
		
	}
	private Color calcDiffusiveComp(double kd, Vector normal, Vector l,Vector V, Color intensity) {
		V=V.multScalar(-1).normalize();
		normal=normal.normalize();
		l=l.normalize();
		double v = Math.abs(normal.dotProduct(l));
		int r = (int)(v*kd*intensity.getRed());
		if(r>255 ) r=255; if(r<0 ) r=0;
		int g =   (int)(v*kd*intensity.getGreen());
		if(g>255 ) g=255;if(g<0 ) g=0;
		int b = (int)(v*kd*intensity.getBlue());
		if(b>255 ) b=255;if(b<0 ) b=0;
		return new Color(r,g,b);
	}
	private Map<Geomtry,Point3D> getClosestPoint (Map<Geomtry,List<Point3D>> lst)
    {

          double distance = Double.MAX_VALUE;
          Point3D P0 = scene.getCamera().getP0();
          Map<Geomtry,Point3D> minDistancePoint = new HashMap<Geomtry,Point3D>();
         for(Entry<Geomtry, List<Point3D>> entry: lst.entrySet())
          {
          for (Point3D point: entry.getValue())
          {
        	 
              if (P0.distance(point) < distance)
              {

              minDistancePoint.clear();
              minDistancePoint.put(entry.getKey(), new Point3D(point));
              distance = P0.distance(point);
              }
          }
          }
              return minDistancePoint; 
   
    }

	private boolean occludd(LightSource light,Point3D point, Geomtry geometry)
	{
		   Vector lightDirection = light.getL(point);
		   lightDirection=lightDirection.multScalar(-1); 
		   Point3D geometryPoint = new Point3D(point); 
		   Vector epsVector = new Vector(geometry.getNormal(point)); 
		   epsVector=epsVector.multScalar(2);
		   geometryPoint=geometryPoint.add(epsVector); 
		   Ray lightRay = new Ray(geometryPoint, lightDirection);
		   Map<Geomtry,List<Point3D>> intersectionPoints = getSceneRayIntersections(lightRay);
		   if(geometry instanceof FlatGeomtry)
			   intersectionPoints.remove(geometry);
		   
		   for (Entry<Geomtry, List<Point3D>>entry:intersectionPoints.entrySet() )
			   if (entry.getKey().getMaterial().getKt() == 0)
			   {
			   return true;
			   }
			   return false;
		 /*  if (intersectionPoints.isEmpty())
              return  false;
          return true;  */
	}
	private Ray  constructReflectedRay(Vector n, Point3D point ,Ray  d)
	{
		Vector D = d.getDirection().normalize();
		Vector R1 = D.subtract(n.multScalar(2*D.dotProduct(n)));
		Ray  R = new Ray ( point.add(R1.multScalar(2).getHead()) ,R1);
		return R;
	}
	private Ray constructRefractedRay(Vector n, Point3D point ,Ray  d)
	{
		return new Ray (point.add(d.getDirection().multScalar(0.001).getHead()), d.getDirection());
	}
}

