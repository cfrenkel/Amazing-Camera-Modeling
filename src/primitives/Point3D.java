package primitives;

public class Point3D extends Point2D{
	//properties
	private Coordinate z;
//constractors
	public Point3D() {
		super();
		this.z = new Coordinate();
	}

	public Point3D(Coordinate c1, Coordinate c2, Coordinate c3) {
		super(c1, c2);
		this.z = new Coordinate(c3);
		
	}

	public Point3D(double n1, double n2, double n3) {
		super(n1, n2);
		this.z = new Coordinate(n3);
	}


	public Point3D(Point3D other) {
		super(other);
		this.z = new Coordinate(other.z);
	}
	//get and set
	public Coordinate getZ() {
		return z;
	}

	public void setZ(Coordinate z) {
		this.z = z;
	}
//basic function
	@Override

	public boolean equals(Object obj) {
	
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (!super.equals(obj))
			return false;
		if (z == null){
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + x + " , " + y + " , " +  z + ")";
	}
//functoin
	//****************remove to vector
public  Point3D subtract(Point3D p){
		
		return new Point3D(this.x.subtract(p.x),this.y.subtract(p.y),this.z.subtract(p.z)) ;
	}
public  Point3D add(Point3D p){
		
		return new Point3D(this.x.add(p.x),this.y.add(p.y),this.z.add(p.z)) ;
	}
public  Point3D add(Vector p){
	
	return new Point3D(this.x.add(p.getHead().x),this.y.add(p.getHead().y),this.z.add(p.getHead().z)) ;
}
public  double distance(Point3D p){
	double d=Math.sqrt
			(Math.pow((this.x.getCoordinate()-p.x.getCoordinate()), 2)
			+Math.pow((this.y.getCoordinate()-p.y.getCoordinate()), 2)
			+Math.pow((this.z.getCoordinate()-p.z.getCoordinate()), 2));
	return d;
}

	
}