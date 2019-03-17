package Elements;

import java.awt.Color;

import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight implements LightSource
{

	Vector direction;

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	public SpotLight(Color color, Point3D position, double kc, double kl, double kq, Vector direction) {
		super(color, position, kc, kl, kq);
		this.direction = direction;
	}
	public SpotLight() {
		super();
		this.direction = new Vector();
	}
	
	// spot light 
	// ***************** Operations ******************** //
	/*@Override
	public Color getIntensity(Point3D point)
	{
	int r = this.getColor().getRed();
	int g = this.getColor().getGreen();
	int b = this.getColor().getBlue();
	Vector l = getL(point);
	l.normalize();
	double distance = getPosition().distance(point);
	double k = (this.getKc() + this.getKl()*distance + this.getKq()*Math.pow(distance, 2));
	//if (k > 1)
	//k=1;

	//System.out.println((int)(r/ k));
	//System.out.println((Math.abs(r/ k)));
	/*int rn = (int)((Math.abs(r / k)));
	if(rn>255) rn = 255; if(rn<0) rn = 0;
	int gn = (int)((Math.abs(g / k)));
	if(gn>255) gn = 255; if(gn<0) gn = 0;
	int bn = (int)((Math.abs(b / k)));
	if(bn>255) bn = 255; if(bn<0) bn = 0;
	Color color = new Color(rn,gn,bn);
	
	double kk = Math.abs(this.direction.dotProduct(l));
	if(kk > 1)
	kk = 1;
	int rc =(int)(color.getRed() * kk);
	if(rc>255) rc=255; if(rc<0) rc=0;
	int gc =(int)(color.getGreen() * kk); 
	if(gc>255) gc=255; if(gc<0) gc=0;
	int bc = (int)(color.getBlue() * kk);
	if(bc>255) bc=255; if(bc<0) bc=0;
	return new Color(rc,gc,bc);*/
	/*
	double t = Math.abs(direction.dotProduct(l));
	t = t/distance;
	int rc =(int)(color.getRed() * t);
	if(rc>255) rc=255; if(rc<0) rc=0;
	int gc =(int)(color.getGreen() * t); 
	if(gc>255) gc=255; if(gc<0) gc=0;
	int bc = (int)(color.getBlue() * t);
	if(bc>255) bc=255; if(bc<0) bc=0;
	return new Color(rc,gc,bc);
	}*/

	@Override
	public Vector getDirection(Point3D point) {
		return direction;
	}

	@Override
	public Color getIntensity(Point3D point) {
		double d = position.distance(point);
		double coef = direction.dotProduct(getL(point)) / ((Kc < 1 ? 1.0 : Kc) + Kl * d + Kq * d * d);
		if (coef <= 0.0)
			return new Color(0,0,0);
		double k =Math.abs(coef);
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
	}

	}

