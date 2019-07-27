import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AShapeTest {

  private AShape rectangle;
  private AShape triangle;
  private AShape circle;

  @Before
  public void setup() {
    rectangle = new Rectangle(0, 10, 10, 20, 20, 30, 40);
    triangle = new Triangle(33, 44, 21, 22, 255, 0, 255);
    circle = new Ellipse(24, 1, 33, 2, 3, 255, 0);
  }

  @Test
  public void testGetX() {
    assertEquals(0, rectangle.getX());
    assertEquals(33, triangle.getX());
    assertEquals(24, circle.getX());
  }

  @Test
  public void testGetY() {
    assertEquals(10, rectangle.getY());
    assertEquals(44, triangle.getY());
    assertEquals(1, circle.getY());
  }

  @Test
  public void testGetW() {
    assertEquals(10, rectangle.getW());
    assertEquals(21, triangle.getW());
    assertEquals(33, circle.getW());
  }

  @Test
  public void testGetH() {
    assertEquals(20, rectangle.getH());
    assertEquals(22, triangle.getH());
    assertEquals(2, circle.getH());
  }

  @Test
  public void testGetR() {
    assertEquals(20, rectangle.getR());
    assertEquals(255, triangle.getR());
    assertEquals(3, circle.getR());
  }

  @Test
  public void testGetG() {
    assertEquals(30, rectangle.getG());
    assertEquals(0, triangle.getG());
    assertEquals(255, circle.getG());
  }

  @Test
  public void testGetB() {
    assertEquals(40, rectangle.getB());
    assertEquals(255, triangle.getB());
    assertEquals(0, circle.getB());
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalW() {
    AShape newShape = new Rectangle(0, 0, -10, 5, 10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalH() {
    AShape newShape = new Triangle(0, 0, 5, -1, 10, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalLowR() {
    AShape newShape = new Triangle(0, 0, 5, 5, -1, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalHighR() {
    AShape newShape = new Triangle(0, 0, 5, 5, 256, 10, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalLowG() {
    AShape newShape = new Ellipse(0, 0, 5, 5, 10, -1, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalHighG() {
    AShape newShape = new Ellipse(0, 0, 5, 5, 10, 256, 10);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalLowB() {
    AShape newShape = new Rectangle(0, 0, 5, 5, 10, 10, -1);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalHighB() {
    AShape newShape = new Rectangle(0, 0, 5, 5, 10, 10, 256);
  }

}