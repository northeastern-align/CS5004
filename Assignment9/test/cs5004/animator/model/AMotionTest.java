package cs5004.animator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

/**
 * JUnit test class for AMotion.
 */
public class AMotionTest {

  private IMotion motionColor;
  private IMotion motionMove;
  private IMotion motionScale;
  private IShape shape;
  private AAnimatedShape animatedShape;
  private TreeMap<IMotion, String> motions = new TreeMap<>();

  @Before
  public void setup() {
    shape = new Rectangle(10, 10, 3, 8, 250, 250, 250);
    animatedShape = new AnimatedRectangle(shape, 0, 200);
    motionColor = new ChangeColor(motions, animatedShape,0, 10, 5, 5, 5);
    motionMove = new Move(motions, animatedShape, 41, 50, 5, 5 );
    motionScale = new Scale(motions, animatedShape, 103, 104, 5, 5 );
  }

  @Test
  public void testGetStartTimeAllMotions() {
    assertEquals(0 , motionColor.getStartTime());
    assertEquals(41, motionMove.getStartTime());
    assertEquals(103, motionScale.getStartTime());
  }

  @Test
  public void testGetEndTimeAllMotions() {
    assertEquals(10 , motionColor.getEndTime());
    assertEquals(50, motionMove.getEndTime());
    assertEquals(104, motionScale.getEndTime());
  }


}