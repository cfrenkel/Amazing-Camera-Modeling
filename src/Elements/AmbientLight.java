package Elements;

import java.awt.Color;

import primitives.Point3D;

public class AmbientLight extends Light
{
	//*******properties********
         
         double Ka;
    //*******get and set*******
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public double getKa() {
			return Ka;
		}
		public void setKa(double ka) {
			Ka = ka;
		}
	//*****Constructors**********
		public AmbientLight(Color color, double ka) {
			super(color);
			Ka = ka;
		}
		public AmbientLight() {
			this.color = Color.white;
			Ka = 0.1;
		}
	//****basic function**********
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AmbientLight other = (AmbientLight) obj;
			if (Double.doubleToLongBits(Ka) != Double.doubleToLongBits(other.Ka))
				return false;
			if (color == null) {
				if (other.color != null)
					return false;
			} else if (!color.equals(other.color))
				return false;
			return true;
		}
   //*****light function**********		
		public Color getIntensity()
		{
		 int r = (int)(color.getRed()*Ka);
		 int g = (int)(color.getGreen()*Ka);
		 int b = (int)(color.getBlue()*Ka);
		 return new Color(r,g,b);
		 
		}
		
         

}
