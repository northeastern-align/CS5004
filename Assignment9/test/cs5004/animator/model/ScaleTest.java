package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * JUnit test class for Scale.
 */
public class ScaleTest {

  private Scale scaleR;
  private Scale scaleT;
  private Scale scaleC;
  private AAnimatedShape animatedRectangle;
  private AAnimatedShape animatedEllipse;
  private AAnimatedShape animatedTriangle;
  private TreeMap<IMotion, String> motions = new TreeMap<>();

  @Before
  public void setup() {
    IShape rectangle;
    IShape triangle;
    IShape circle;
    rectangle = new Rectangle(0, 0, 5, 5, 255, 255, 255);
    animatedRectangle = new AnimatedRectangle(rectangle, 0, 50);
    triangle = new Triangle(0, 0, 5, 5, 255, 255, 255);
    animatedTriangle = new AnimatedTriangle(triangle, 0, 100);
    circle = new Ellipse(0, 0, 5, 5, 255, 255, 255);
    animatedEllipse = new AnimatedEllipse(triangle,0, 100);
    scaleR = new Scale(motions, animatedRectangle, 10, 20, 10, 10);
    scaleT = new Scale(motions, animatedTriangle, 0, 45, 5, 10);
    scaleC = new Scale(motions, animatedEllipse, 33, 44, 10, 5);
  }

  @Test
  public void toStringR() {
    assertEquals("scales from (5, 5) to (10, 10) from t=10 to t=20", scaleR.toString());
  }

  @Test
  public void toStringT() {
    assertEquals("scales from (5, 5) to (5, 10) from t=0 to t=45", scaleT.toString());
  }

  @Test
  public void toStringC() {
    assertEquals("scales from (5, 5) to (10, 5) from t=33 to t=44", scaleC.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeR() {
    Scale newTest = new Scale(motions, animatedRectangle, 0, 10, 5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeT() {
    Scale newTest = new Scale(motions, animatedTriangle, 0, 10, 5,-5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeC() {
    Scale newTest = new Scale(motions, animatedEllipse, 0, 0, 5,6);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalTimeNeg() {
    Scale newTest = new Scale(motions, animatedEllipse, -1, 0, 5,6);
  }


}