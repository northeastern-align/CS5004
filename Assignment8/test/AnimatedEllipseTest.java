import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for AnimatedEllipse.
 */
public class AnimatedEllipseTest {

  private IShape ellipse1;
  private IShape ellipse2;
  private IShape ellipse3;
  private AnimatedEllipse animated1;
  private AnimatedEllipse animated2;
  private AnimatedEllipse animated3;


  @Before
  public void setup() {
    ellipse1 = new Ellipse( 0, 0, 5, 5, 100, 100, 100);
    ellipse2 = new Ellipse(3, 27, 16, 22, 0, 100, 200);
    ellipse3 = new Ellipse(65, 11, 44, 1, 255, 255, 3);
    animated1 = new AnimatedEllipse(ellipse1, 10, 20);
    animated2 = new AnimatedEllipse(ellipse2, 0, 100);
    animated3 = new AnimatedEllipse(ellipse3, 45, 46);

  }

  @Test
  public void toString1() {
    assertEquals("Type: Circle\n"
        + "Center: (0, 0), Width: 5, Height: 5, Color: (100, 100, 100)\n"
        + "Appears at t=10\n"
        + "Disappears at t=20\n", animated1.toString());
  }

  @Test
  public void toString2() {
    assertEquals("Type: Circle\n"
        + "Center: (3, 27), Width: 16, Height: 22, Color: (0, 100, 200)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n", animated2.toString());
  }

  @Test
  public void toString3() {
    assertEquals("Type: Circle\n"
        + "Center: (65, 11), Width: 44, Height: 1, Color: (255, 255, 3)\n"
        + "Appears at t=45\n"
        + "Disappears at t=46\n", animated3.toString());
  }
}