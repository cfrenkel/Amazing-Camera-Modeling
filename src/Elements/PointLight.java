package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource
{

	Point3D position;
	double Kc, Kl, Kq;
	
	
	
	public Point3D getPosition() {
		return position;
	}
	public void setPosition(Point3D position) {
		this.position = position;
	}
	public double getKc() {
		return Kc;
	}
	public void setKc(double kc) {
		Kc = kc;
	}
	public double getKl() {
		return Kl;
	}
	public void setKl(double kl) {
		Kl = kl;
	}
public double getKq() {
		return Kq;
	}
public void setKq(double kq) {
		Kq = kq;
	}


	public PointLight(Color color, Point3D position, double kc, double kl, double kq) {
	super(color);
	this.position = position;
	Kc = kc;
	Kl = kl;
	Kq = kq;
}
	public PointLight() {
	super();
	this.position = new Point3D();
	Kc = 1;
	Kl = 1;
	Kq = 1;
}
	@Override
	Color getIntensity( ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getDirection(Point3D p) {
		Vector dir = getL(p);
		return dir;
	}

	@Override
	public Color getIntensity(Point3D point){
		double d = position.distance(point);
		double k =(1.0/((Kc<1 ? 1 : Kc) + Kl*d + Kq*d*d));
		int rc =(int)(color.getRed() * k);
		if(rc>255) rc=255; if(rc<0) rc=0;
		int gc =(int)(color.getGreen() * k); 
		if(gc>255) gc=255; if(gc<0) gc=0;
		int bc = (int)(color.getBlue() * k);
		if(bc>255) bc=255; if(bc<0) bc=0;
		return new Color(rc,gc,bc);
	}
	
	@Override
	public Vector getL(Point3D point) {
		return new Vector(point.subtract(position)).normalize();
	
	/*@Override
	
	Color getIntensity(Point3D p ) {
		// TODO Auto-generated method stub
		return null;
	}*/
/*	@Override
	public Vector getL(Point3D p) {
		return new Vector(p.subtract(position)).normalize();
	}

@Override
public  Color  getIntensity(Point3D point)
{
/*double distance = point.distance(position);
Color color = new Color(this.color.getRGB());
double K = 1/(Kc + Kl * distance +Kq * Math.pow(distance, 2));
if(K<1) 
K=1;
int red = (int)(color.getRed() * K);
int green = (int)(color.getGreen() * K);
int blue = (int)(color.getBlue() * K);
if (red<0)
red=0;
if (green<0)
green=0;
if (blue<0)
blue=0;
if (red>255)
red=255;
if (green>255)
green=255;
if (blue>255)
blue=255;
return new Color(red,green,blue);
}

@Override
public Color getIntensity() {
	// TODO Auto-generated method stub
	return null;*//*
	Vector l = getL(point);
	l.normalize();
	double distance = getPosition().distance(point);
	double k = (this.getKc() + this.getKl()*distance + this.getKq()*Math.pow(distance, 2));
	k=1/k;
	int rc =(int)(color.getRed() * k);
	if(rc>255) rc=255; if(rc<0) rc=0;
	int gc =(int)(color.getGreen() * k); 
	if(gc>255) gc=255; if(gc<0) gc=0;
	int bc = (int)(color.getBlue() * k);
	if(bc>255) bc=255; if(bc<0) bc=0;
	return new Color(rc,gc,bc);
}*/

}
}	

