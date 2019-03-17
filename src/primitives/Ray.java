package primitives;

public class Ray
{
	//properties
	private   Point3D POO;
	private   Vector direction;
     
	//constractor
	public Ray() 
	{
		POO= new Point3D();
		direction = new Vector();
		// TODO Auto-generated constructor stub
	}

	public Ray(Point3D pOO, Vector direction) {
		POO = pOO;
		this.direction = direction;
	}
	
	public Ray(Ray r) {
		POO = r.POO;
		this.direction = r.direction;
	}

	//get and set
   public Point3D getPOO() {
		return POO;
	}

	public void setPOO(Point3D pOO) {
		POO = pOO;
	}

	public Vector getDirection() {
		return direction;
	}

	public void setDirection(Vector direction) {
		this.direction = direction;
	}

	//basic function

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (POO == null) {
			if (other.POO != null)
				return false;
		} else if (!POO.equals(other.POO))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + POO + "),("+ direction+")";
	}
	
	
	
     
     
}
