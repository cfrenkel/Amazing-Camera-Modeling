package Elements;

import java.awt.Color;

import primitives.Point3D;

public abstract class Light 
{
	
	protected  Color color;
	
	abstract Color getIntensity();

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Light(Color color) {
		
		this.color = color;
	
	}
	public Light() {
		
		this.color = new Color(0);
	
	}
}
