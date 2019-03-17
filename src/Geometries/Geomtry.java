package Geometries;

import java.awt.Color;
import java.util.List;

import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;;

public abstract class Geomtry
{
	//******properties**********
 protected  Color color;
 protected  Material material;
 //********get and set*********
public Material getMaterial() {
	return material;
}

public void setMaterial(Material material) {
	this.material = material;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}




public Geomtry(Color color, Material material) {
	this.color = color;
	this.material = material;
}
public Geomtry(Geomtry g) {
	this.color = g.color;
	this.material = g.material;
}
public Geomtry() {
	this.color = new Color(0);
	this.material = new Material();
}

public abstract Vector getNormal(Point3D p);
public abstract List<Point3D> findIntersections(Ray p);

 
   
}
