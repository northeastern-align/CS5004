import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Vector3D.
 * Resources: Exception test - https://bit.ly/2z00JMo
 */

public class Vector3DTest {

  private Vector3D vector;

  @Before
  public void setUp() {

    vector = new Vector3D(10.55, 10.45, 10.50);

  }

  @Test
  public void testGetX() {
    assertEquals(10.55, vector.getX(), 0.0);
  }

  @Test
  public void testGetY() {
    assertEquals(10.45, vector.getY(), 0.0);
  }

  @Test
  public void testGetZ() {
    assertEquals(10.50, vector.getZ(), 0.0);
  }

  @Test
  public void testToString() {
    assertEquals("(10.55,10.45,10.50)", vector.toString());
  }

  @Test
  public void testGetMagnitude() {
    assertEquals(18.19, vector.getMagnitude(),
        0.01);
  }

  @Test
  public void testNormalize() {
    Vector3D expected = new Vector3D(0.58, 0.57, 0.58);
    assertEquals(expected, vector.normalize());
  }

  @Test
  public void testAdd() {
    Vector3D toBeAdded = new Vector3D(1.25, 4.75, 8.90);
    Vector3D expected = new Vector3D(11.80, 15.20, 19.40);
    assertEquals(expected, vector.add(toBeAdded));

  }

  @Test
  public void testMultiply() {
    double constant = 1.33;
    Vector3D expected = new Vector3D(14.03, 13.90, 13.97);
    assertEquals(expected, vector.multiply(constant));
  }

  @Test
  public void testDotProduct() {
    Vector3D toBeMultiplied = new Vector3D(4.77, 3.28, 7.15);
    assertEquals(159.67, vector.dotProduct(toBeMultiplied), 0.01);
  }

  @Test
  public void testAngleBetween() {
    Vector3D toBeCompared = new Vector3D(4.77, 3.28, 7.15);
    assertEquals(17.38, vector.angleBetween(toBeCompared), 0.01);
  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalStateException() {
    Vector3D illegalTest = new Vector3D(0, 0, 0);
    vector.angleBetween(illegalTest);
  }

}