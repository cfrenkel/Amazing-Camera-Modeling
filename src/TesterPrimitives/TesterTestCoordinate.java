package TesterPrimitives;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Coordinate;

public class TesterTestCoordinate {

	@Test
	public void testAdd() 
	{
		Coordinate c1 = new Coordinate(3);
		Coordinate c2 = new Coordinate(4);
		Coordinate c4 = new Coordinate(7);
		Coordinate c3 = c1.add(c2);
		assertEquals(c4, c3);
	}
	@Test
	public void testSub() 
	{
		Coordinate c1 = new Coordinate(10);
		Coordinate c2 = new Coordinate(3);
		Coordinate c4 = new Coordinate(7);
		Coordinate c3 = c1.subtract(c2);
		assertEquals(c4, c3);
	}
}
