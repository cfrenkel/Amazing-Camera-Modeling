package primitives;
public class Vector {
	//properties
	private Point3D head;

	//*****constractors*****
	public Vector(Point3D head) {
		this.head = head;
	}
	public Vector() {
		this.head = new Point3D();
	}
	public Vector(Vector v) {
		this.head = v.head;
	}
	//*****get and set******
    public Point3D getHead() {
		return head;
	}
	public void setHead(Point3D head) {
		this.head = head;
	}
	//*****basic function***
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector other = (Vector) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "(" + head.getX() + "," +head.getY()+","+head.getZ()+")";
	}
	//*****functoin******
	public Vector add(Vector v)
	{
		Point3D p= new Point3D(this.head.add(v.head));
		return new Vector (p);
	}
	
	public Vector subtract(Vector v)
	{
		Point3D p= new Point3D(this.head.subtract(v.head));
		return new Vector (p);
	}
	
	public Vector multScalar(double  v)
	{
		Point3D p= new Point3D(this.head.getX().getCoordinate()*v,this.head.getY().getCoordinate()*v,this.head.getZ().getCoordinate()*v);
		return new Vector (p);
	}
	public double dotProduct(Vector  v)
	{
		return this.head.getX().getCoordinate()*v.head.getX().getCoordinate()
				+this.head.getY().getCoordinate()*v.head.getY().getCoordinate()
				+this.head.getZ().getCoordinate()*v.head.getZ().getCoordinate();
	}
	public Vector CrossProduct(Vector  v)
	{
		double u1=  this.head.getX().getCoordinate();
		double v1=	 v.head.getX().getCoordinate();
		double u2=	this.head.getY().getCoordinate();
		double v2=	v.head.getY().getCoordinate();
		double u3=	this.head.getZ().getCoordinate();
		double v3=v.head.getZ().getCoordinate();
		
		Coordinate x = new Coordinate(u2*v3-u3*v2);
		Coordinate y = new Coordinate(u3*v1-u1*v3);
		Coordinate z = new Coordinate(u1*v2-u2*v1);
		
		return new Vector(new Point3D(x,y,z));
	  
	}
	
	public double length()
	{
		return Math.sqrt(Math.pow(this.head.getX().getCoordinate(), 2)+
			   Math.pow(this.head.getY().getCoordinate(), 2)+
			   Math.pow(this.head.getZ().getCoordinate(), 2));
	}
	public Vector normalize()
	{
		if(this.length()==0)
			return this;
		double u1=  this.head.getX().getCoordinate()/this.length();
		double u2=	this.head.getY().getCoordinate()/this.length();
		double u3=	this.head.getZ().getCoordinate()/this.length();
		
		Coordinate x = new Coordinate(u1);
		Coordinate y = new Coordinate(u2);
		Coordinate z = new Coordinate(u3);
		
		return new Vector(new Point3D(x,y,z));
	}
	
	public Vector move(double alfa)
	{
		double u1=  this.head.getX().getCoordinate()+alfa;
		double u2=	this.head.getY().getCoordinate()+alfa;
		double u3=	this.head.getZ().getCoordinate()+alfa;
		
		Coordinate x = new Coordinate(u1);
		Coordinate y = new Coordinate(u2);
		Coordinate z = new Coordinate(u3);
		
		return new Vector(new Point3D(x,y,z));
	}
	
}
