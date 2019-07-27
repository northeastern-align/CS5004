import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoveTest {

  private Move moveR;
  private Move moveT;
  private Move moveC;
  private IShape rectangle;
  private IShape triangle;
  private IShape circle;

  @Before
  public void setup() {
    rectangle = new Rectangle(0, 0, 5, 5, 255, 255, 255);
    triangle = new Triangle(0, 0, 5, 5, 255, 255, 255);
    circle = new Ellipse(0, 0, 5, 5, 255, 255, 255);
    moveR = new Move(rectangle, 10, 20, 5, 5);
    moveT = new Move(triangle, 0, 45, 0, 10);
    moveC = new Move(circle, 33, 44, 10, 0);
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
    Move newTest = new Move(rectangle, 0, 10, 0,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeT() {
    Move newTest = new Move(triangle, 0, 0, 10,0);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeC() {
    Move newTest = new Move(triangle, -1, 0, 10,0);
  }

}