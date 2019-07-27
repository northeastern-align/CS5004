import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for AnimatedTriangle.
 */
public class AnimatedTriangleTest {

  private IShape triangle1;
  private IShape triangle2;
  private IShape triangle3;
  private AnimatedTriangle animated1;
  private AnimatedTriangle animated2;
  private AnimatedTriangle animated3;


  @Before
  public void setup() {
    triangle1 = new Triangle( 0, 0, 5, 5, 100, 100, 100);
    triangle2 = new Triangle(3, 27, 16, 22, 0, 100, 200);
    triangle3 = new Triangle(65, 11, 44, 1, 255, 255, 3);
    animated1 = new AnimatedTriangle(triangle1, 10, 20);
    animated2 = new AnimatedTriangle(triangle2, 0, 100);
    animated3 = new AnimatedTriangle(triangle3, 45, 46);

  }

  @Test
  public void toString1() {
    assertEquals("Type: triangle\n"
        + "Corner: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n"
        + "Appears at t=10\n"
        + "Disappears at t=20\n", animated1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: triangle\n"
        + "Corner: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n", animated2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: triangle\n"
        + "Corner: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n"
        + "Appears at t=45\n"
        + "Disappears at t=46\n", animated3.toString());
  }
}