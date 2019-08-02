import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * JUnit test class for ChangeColor.
 */
public class ChangeColorTest {

  private ChangeColor CCR;
  private ChangeColor CCT;
  private ChangeColor CCC;
  private IShape rectangle;
  private IShape triangle;
  private IShape circle;
  private AAnimatedShape animatedRectangle;
  private AAnimatedShape animatedEllipse;
  private AAnimatedShape animatedTriangle;
  private TreeMap<IMotion, String> motions = new TreeMap<>();

  @Before
  public void setup() {
    rectangle = new Rectangle(0, 0, 5, 5, 255, 255, 255);
    animatedRectangle = new AnimatedRectangle(rectangle, 10,20);
    triangle = new Triangle(0, 0, 5, 5, 255, 255, 255);
    animatedTriangle = new AnimatedTriangle(triangle, 0, 45);
    circle = new Ellipse(0, 0, 5, 5, 255, 255, 255);
    animatedEllipse = new AnimatedEllipse(circle, 33,44);
    CCR = new ChangeColor(motions, animatedRectangle,10, 20, 5, 255, 15);
    CCT = new ChangeColor(motions, animatedTriangle,0, 45, 0, 0, 0);
    CCC = new ChangeColor(motions, animatedEllipse, 33, 44, 255, 255, 0);
  }

  @Test
  public void toStringR() {
    assertEquals("changes color from (255, 255, 255) to (5, 255, 15) from t=10 to t=20", CCR.toString());
  }

  @Test
  public void toStringT() {
    assertEquals("changes color from (255, 255, 255) to (0, 0, 0) from t=0 to t=45", CCT.toString());
  }

  @Test
  public void toStringC() {
    assertEquals("changes color from (255, 255, 255) to (255, 255, 0) from t=33 to t=44", CCC.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeR() {
    ChangeColor newTest = new ChangeColor(motions, animatedRectangle, 0, 10, 255, 255, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeT() {
    ChangeColor newTest = new ChangeColor(motions, animatedTriangle, 0, 10, -1, 255, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeC() {
    ChangeColor newTest = new ChangeColor(motions, animatedEllipse, 0, 10, 256, 255, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalTime1() {
    ChangeColor newTest = new ChangeColor(motions, animatedEllipse, 0, 0, 100, 255, 255);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalTime2() {
    ChangeColor newTest = new ChangeColor(motions, animatedEllipse, -1, 0, 100, 255, 255);
  }

}