package Elements;

import java.awt.Color;


import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource
{

	Vector direction;
	
	public DirectionalLight(Color color, Vector direction) {
		super(color);
		this.direction = direction;
	}
	public DirectionalLight() {
		super();
		this.direction = new Vector();
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	/*@Override
	Color getIntensity(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	Color getIntensity() {
		// TODO Auto-generated method stub
		return null;
	}*/
	@Override
	public Vector getL(Point3D p) {
		return new Vector(p.subtract(direction.getHead())).normalize();
	}
	@Override
	public Color getIntensity(Point3D p) {
		return this.getColor();
	}
	@Override
	Color getIntensity() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Vector getDirection(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
