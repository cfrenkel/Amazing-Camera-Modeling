package Elements;
import primitives.*;
//import Geometries.*;
public class Camera {
	
	//****properties********
     private Point3D p0;
     private Vector vUp;
     private Vector vTo;
     private Vector vRight;
     
     //****set and get******
	public Point3D getP0() {
		return p0;
	}
	public void setP0(Point3D p0) {
		this.p0 = p0;
	}
	public Vector getvUp() {
		return vUp;
	}
	public void setvUp(Vector vUp) {
		this.vUp = vUp;
	}
	public Vector getvTo() {
		return vTo;
	}
	public void setvTo(Vector vTo) {
		this.vTo = vTo;
	}
	public Vector getvRight() {
		return vRight;
	}
	public void setvRight(Vector vRight) {
		this.vRight = vRight;
	}
	
	//****constructors*********
	public Camera(Point3D p0, Vector vUp, Vector vTo, Vector vRight) {
		super();
		this.p0 = p0;
		this.vUp = vUp;
		this.vTo = vTo;
		this.vRight = vRight;
	}
	public Camera(Point3D p0, Vector vTo, Vector vRight) {

		this.p0 = p0;
		this.vUp = vTo.CrossProduct(vRight);
		this.vTo = vTo;
		this.vRight = vRight;
	}
	public Camera() 
	{
		this.p0 = new Point3D(0,0,0);
		this.vUp = new Vector(new Point3D(0,0,1));
		this.vTo =  new Vector(new Point3D(1,0,0));
		this.vRight =  new Vector(new Point3D(0,1,0));
	}
	public Camera(Camera c) {
		this.p0 = c.p0;
		this.vUp = c.vUp;
		this.vTo = c.vTo;
		this.vRight = c.vRight;
	}
//********basic function
	@Override
    public String toString() {
		return "Camera [p0=" + p0 + ", vUp=" + vUp + ", vTo=" + vTo + ", vRight=" + vRight + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camera other = (Camera) obj;
		if (p0 == null) {
			if (other.p0 != null)
				return false;
		} else if (!p0.equals(other.p0))
			return false;
		if (vRight == null) {
			if (other.vRight != null)
				return false;
		} else if (!vRight.equals(other.vRight))
			return false;
		if (vTo == null) {
			if (other.vTo != null)
				return false;
		} else if (!vTo.equals(other.vTo))
			return false;
		if (vUp == null) {
			if (other.vUp != null)
				return false;
		} else if (!vUp.equals(other.vUp))
			return false;
		return true;
	}
	
//********camera function**********
   public Ray constructRayThroughPixel (double Nx, double Ny, double x,
    		double y, double screenDist, 
    		double screenWidth,double screenHeight)
    {
	  
    	Point3D pc = p0.add(vTo.multScalar(screenDist));
    	double Rx = screenWidth/Nx;
    	double Ry = screenHeight/Ny;
    	Vector v1 = vRight.multScalar((x-Nx/2)*Rx+Rx/2);
    	Vector v2 = vUp.multScalar((y-Ny/2)*Ry+Ry/2);
    	Vector v = v1.subtract(v2);
    	Point3D p = pc.add(v);
    	return new Ray(p0, new Vector(p.subtract(p0)));
    }
	
	
     
     
}
