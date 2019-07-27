import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * JUnit test class for Move.
 */
public class MoveTest {

  private Move moveR;
  private Move moveT;
  private Move moveC;
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
    animatedRectangle = new AnimatedRectangle(rectangle, 0, 200);
    triangle = new Triangle(0, 0, 5, 5, 255, 255, 255);
    animatedTriangle = new AnimatedTriangle(triangle, 0, 200);
    circle = new Ellipse(0, 0, 5, 5, 255, 255, 255);
    animatedEllipse = new AnimatedEllipse(circle, 0, 200);
    moveR = new Move(motions, animatedRectangle, 10, 20, 5, 5);
    moveT = new Move(motions, animatedTriangle, 0, 45, 0, 10);
    moveC = new Move(motions, animatedTriangle, 33, 44, 10, 0);
  }

  @Test
  public void toStringR() {
    assertEquals("moves from (0, 0) to (5, 5) from t=10 to t=20", moveR.toString());
  }

  @Test
  public void toStringT() {
    assertEquals("moves from (0, 0) to (0, 10) from t=0 to t=45", moveT.toString());
  }

  @Test
  public void toStringC() {
    assertEquals("moves from (0, 0) to (10, 0) from t=33 to t=44", moveC.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeR() {
    Move newTest = new Move(motions, animatedRectangle, 0, 10, 0,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeT() {
    Move newTest = new Move(motions, animatedTriangle, 0, 0, 10,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeC() {
    Move newTest = new Move(motions, animatedEllipse, -1, 0, 10,0);
  }

}