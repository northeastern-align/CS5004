package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Rectangle.
 */
public class RectangleTest {

  private Rectangle rectangle1;
  private Rectangle rectangle2;
  private Rectangle rectangle3;

  @Before
  public void setup() {
    rectangle1 = new Rectangle(0, 0, 5, 5, 100, 100, 100);
    rectangle2 = new Rectangle(3, 27, 16, 22, 0, 100, 200);
    rectangle3 = new Rectangle(65, 11, 44, 1, 255, 255, 3);
  }

  @Test
  public void toString1() {
    assertEquals("Type: rectangle\n"
        + "Corner: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n",
            rectangle1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: rectangle\n"
        + "Corner: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n",
            rectangle2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: rectangle\n"
        + "Corner: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n",
            rectangle3.toString());
  }
}