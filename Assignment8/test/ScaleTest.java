import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScaleTest {

  private Scale scaleR;
  private Scale scaleT;
  private Scale scaleC;
  private IShape rectangle;
  private IShape triangle;
  private IShape circle;

  @Before
  public void setup() {
    rectangle = new Rectangle(0, 0, 5, 5, 255, 255, 255);
    triangle = new Triangle(0, 0, 5, 5, 255, 255, 255);
    circle = new Ellipse(0, 0, 5, 5, 255, 255, 255);
    scaleR = new Scale(rectangle, 10, 20, 10, 10);
    scaleT = new Scale(triangle, 0, 45, 5, 10);
    scaleC = new Scale(circle, 33, 44, 10, 5);
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
    Scale newTest = new Scale(rectangle, 0, 10, 5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeT() {
    Scale newTest = new Scale(triangle, 0, 10, 5,-5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalChangeC() {
    Scale newTest = new Scale(circle, 0, 0, 5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void illegalTimeNeg() {
    Scale newTest = new Scale(circle, -1, 0, 5,5);
  }


}