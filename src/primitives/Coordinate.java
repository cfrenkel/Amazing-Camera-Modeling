 package primitives;

public class Coordinate {

	//********properties******
	private double coordinate;

	//******getters and setters******
	
	public double getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(double coordinate) {
		this.coordinate = coordinate;
	}

	//******constractors*******
	public Coordinate() {
		this.coordinate = 0;
	}
	
	public Coordinate(double coordinate) {
		this.coordinate = coordinate;
	}

	
	public Coordinate(Coordinate other) {
		this.coordinate = other.coordinate;
	}
	
	//********basic function********
	@Override
	public String toString() {
		return ""+ coordinate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return this.coordinate == other.coordinate;
	}

	//function
	public Coordinate add(Coordinate c){
		double x = this.coordinate +  c.coordinate;
		return new Coordinate(x);
	}
	
	public Coordinate subtract(Coordinate c){
		double x = this.coordinate -  (c.coordinate);
		return new Coordinate(x);
	}
	
	
}