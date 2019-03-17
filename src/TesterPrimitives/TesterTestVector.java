package TesterPrimitives;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

public class TesterTestVector {

	@Test
	public void testAdd() {
		Vector v2 = new Vector(new Point3D(2,4,6));
		Vector v1 = new Vector(new Point3D(1,3,5));
		Vector v3 = v1.add(v2);
		Vector v4 = new Vector(new Point3D(3,7,11));
		assertEquals(v3, v4);
	}
	@Test
	public void testSub() {
		Vector v2 = new Vector(new Point3D(2,4,6));
		Vector v1 = new Vector(new Point3D(1,3,5));
		Vector v3 = v2.subtract(v1);
		Vector v4 = new Vector(new Point3D(1,1,1));
		assertEquals(v3, v4);
	}
	
	@Test
	public void testCrossProduct() {
		Vector v2 = new Vector(new Point3D(2,4,6));
		Vector v1 = new Vector(new Point3D(1,3,5));
		Vector v3 = v1.CrossProduct(v2);
		Vector v4 = new Vector(new Point3D(-2,4,-2));
		assertEquals(v3, v4);
	}
	@Test
	public void testDotProduct() {
		Vector v2 = new Vector(new Point3D(2,4,6));
		Vector v1 = new Vector(new Point3D(1,3,5));
		double d = v1.dotProduct(v2);
		double d1 = 44;
		assertEquals(d, d1, 0);
	}
	@Test
	public void testScale() {
		Vector v1 = new Vector(new Point3D(2,4,6));
		Vector v = v1.multScalar(4);
		Vector v2= new Vector(new Point3D(8,16,24));
		assertEquals(v,v2);
	}
	@Test
	public void testMove() {
		Vector v1 = new Vector(new Point3D(2,4,6));
		Vector v = v1.move(4);
		Vector v2= new Vector(new Point3D(6,8,10));
		assertEquals(v,v2);
	}	
	
	@Test
	public void testLen() {
		Vector v1 = new Vector(new Point3D(2,4,6));
		double d = v1.length();
		double d1 = Math.sqrt(2*2+4*4+6*6);
		assertEquals(d,d1,0);
	}	
	@Test
	public void testNormal() {
		Vector v1 = new Vector(new Point3D(2,4,6));
		Vector v = v1.normalize();
		Vector v2= new Vector(new Point3D(2/v1.length(),4/v1.length(),6/v1.length()));
		assertEquals(v,v2);
	}
}
