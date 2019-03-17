package TesterElements;
import static org.junit.Assert.*;

import org.junit.Test;

import Elements.Camera;
import primitives.*;
public class TesterCamera {

	@Test
	public void test() {
      Ray r1 = new Ray(new Point3D(0,0,0), new Vector(new Point3D(3,3,-6)));
      Camera c = new Camera(new Point3D(0,0,0),
    		  new Vector(new Point3D(0,0,1)),
    		  new Vector(new Point3D(0,1,0)),
    		  new Vector(new Point3D(1,0,0)));
      Ray r2 = c.constructRayThroughPixel(3, 3, 2, 3, 3, 9, 9);
      assertEquals( r1, r2);
		
	}

}
