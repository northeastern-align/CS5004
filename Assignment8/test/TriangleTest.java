import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

  private Triangle triangle1;
  private Triangle triangle2;
  private Triangle triangle3;

  @Before
  public void setup() {
    triangle1 = new Triangle(0, 0, 5, 5, 100, 100, 100);
    triangle2 = new Triangle(3, 27, 16, 22, 0, 100, 200);
    triangle3 = new Triangle(65, 11, 44, 1, 255, 255, 3);
  }

  @Test
  public void toString1() {
    assertEquals("Type: triangle\n"
        + "Corner: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n", triangle1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: triangle\n"
        + "Corner: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n", triangle2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: triangle\n"
        + "Corner: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n", triangle3.toString());
  }
}