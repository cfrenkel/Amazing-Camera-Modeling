package TesterPrimitives;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;

public class TesterTestPoint3D {

	@Test
	public void testAdd() {
		
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D p2 = new Point3D(2, 4, 6);
		Point3D P3 = p1.add(p2);
		Point3D P4 = new Point3D(3, 6, 9);
		assertEquals(P3, P4);
	}
	
	@Test
	public void testSub() {
		
		Point3D p1 = new Point3D(3, 6, 9);
		Point3D p2 = new Point3D(1, 2, 3);
		Point3D P3 = p1.subtract(p2);
		Point3D P4 = new Point3D(2, 4, 6);
		assertEquals(P3, P4);
	}

	@Test
	public void testDistance() {
		
		Point3D p1 = new Point3D(3, 6, 9);
		Point3D p2 = new Point3D(1, 2, 3);
		double dis = p1.distance(p2);
		double dis1 = Math.sqrt(56);
	    assertEquals(dis, dis1,0);
	}

	
}
