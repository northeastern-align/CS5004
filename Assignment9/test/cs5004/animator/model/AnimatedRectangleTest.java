package cs5004.animator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for AnimatedRectangle.
 */
public class AnimatedRectangleTest {

  private IShape rectangle1;
  private IShape rectangle2;
  private IShape rectangle3;
  private AnimatedRectangle animated1;
  private AnimatedRectangle animated2;
  private AnimatedRectangle animated3;


  @Before
  public void setup() {
    rectangle1 = new Rectangle( 0, 0, 5, 5, 100, 100, 100);
    rectangle2 = new Rectangle(3, 27, 16, 22, 0, 100, 200);
    rectangle3 = new Rectangle(65, 11, 44, 1, 255, 255, 3);
    animated1 = new AnimatedRectangle(rectangle1, 10, 20);
    animated2 = new AnimatedRectangle(rectangle2, 0, 100);
    animated3 = new AnimatedRectangle(rectangle3, 45, 46);

  }

  @Test
  public void toString1() {
    assertEquals("Type: rectangle\n"
        + "Corner: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n"
        + "Appears at t=10\n"
        + "Disappears at t=20\n", animated1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: rectangle\n"
        + "Corner: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n", animated2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: rectangle\n"
        + "Corner: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n"
        + "Appears at t=45\n"
        + "Disappears at t=46\n", animated3.toString());
  }
}