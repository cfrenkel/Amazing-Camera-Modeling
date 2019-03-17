package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public interface LightSource 
{
	public Vector getL(Point3D p);
	public Vector getDirection(Point3D p);
	public Color getIntensity(Point3D p);
}
