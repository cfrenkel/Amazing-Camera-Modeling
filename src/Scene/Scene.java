package Scene;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.Light;
import Elements.LightSource;
import Elements.SpotLight;
import Geometries.Geomtry;

public class Scene {

	//******properties**********
	private String sceneName;
	private Color background;
	private AmbientLight ambientLight;
	private List<Geomtry> geometries;
	List<LightSource> lights;
	private Camera camera;
	private double screenDistance;
	
	//******Constructors*********
	public Scene(String sceneName, AmbientLight a, Color background,List<LightSource> l, List<Geomtry> geometries, Camera camera, double screenDistance) {
		this.sceneName = sceneName;
		this.background = background;
		this.geometries = geometries;
		this.camera = camera;
		this.screenDistance = screenDistance;
		this.ambientLight = a;
		this.lights = l;
		
	}
	public Scene() {
		this.sceneName = "";
		this.background = Color.BLACK;
		this.ambientLight = new AmbientLight();
		this.geometries = new ArrayList<Geomtry>();
		this.camera = new Camera();
		this.screenDistance = 0;
		this.lights = new ArrayList<LightSource>();
	}

	
   //*****get and set**********
	public String getSceneName() {
		return sceneName;
	}
	public void setSceneName(String sceneName) {
		this.sceneName = sceneName;
	}
	public Color getBackground() {
		return background;
	}
	public void setBackground(Color background) {
		this.background = background;
	}
	public AmbientLight getAmbientLight() {
		return ambientLight;
	}
	public void setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
	}
	public List<Geomtry> getGeometries() {
		return geometries;
	}
	public void setGeometries(List<Geomtry> geometries) {
		this.geometries = geometries;
	}
	public Camera getCamera() {
		return camera;
	}
	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	public double getScreenDistance() {
		return screenDistance;
	}
	public void setScreenDistance(double screenDistance) {
		this.screenDistance = screenDistance;
	}
	
	
	public List<LightSource> getLights() {
		return lights;
	}
	public void setLights(List<LightSource> lights) {
		this.lights = lights;
	}
	//******Scene function******
	public void  addGeometry(Geomtry g)
	{
		this.geometries.add(g);	
	}
	public Iterator<Geomtry> getGeometryIterator()
	{
		return this.geometries.iterator();
	}
	
	public Iterator<LightSource> getLightIterator()
	{
		return this.lights.iterator();
	}
	public void addLight(LightSource  spotLight) {
		
		lights.add(spotLight);
		// TODO Auto-generated method stub
		
	}
}
