import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EllipseTest {

  private Ellipse ellipse1;
  private Ellipse ellipse2;
  private Ellipse ellipse3;

  @Before
  public void setup() {
    ellipse1 = new Ellipse(0, 0, 5, 5, 100, 100, 100);
    ellipse2 = new Ellipse(3, 27, 16, 22, 0, 100, 200);
    ellipse3 = new Ellipse(65, 11, 44, 1, 255, 255, 3);
  }

  @Test
  public void toString1() {
    assertEquals("Type: ellipse\n"
        + "Corner: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n", ellipse1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: ellipse\n"
        + "Corner: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n", ellipse2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: ellipse\n"
        + "Corner: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n", ellipse3.toString());
  }
}