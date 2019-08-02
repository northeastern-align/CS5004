package cs5004.animator.model;

import java.util.ArrayList;

/**
 * This is an abstract class for Animated Shapes. The AnimatedEllipse, AnimatedRectangle, and
 * AnimatedTriangle classes extend this abstract class and utilize the constructor housed in this
 * abstract class. This class implements the interface IAnimatedShape, which contains an
 * addAnimation function.
 */
public class AAnimatedShape implements IAnimatedShape {

  protected int appearTime;
  protected int disappearTime;

  protected IShape shape;

  ArrayList<IMotion> motions = new ArrayList<>();

  /**
   * Constructor for an AnimatedShape abstract class. Takes in a shape (IShape type), id (String),
   * and time 1 and time 2 (ints), the appearance and disappearance time, respectively. This
   * constructor is used by the AnimatedEllipse, AnimatedRectangle, and Animated Triangle classes.
   *
   * @param shape the shape to be animated.
   * @param t1 the animation start (appearance) time.
   * @param t2 the animation end (disappearance) time.
   */
  public AAnimatedShape(IShape shape, int t1, int t2) {
    this.shape = shape;
    this.appearTime = t1;
    this.disappearTime = t2;
  }

  /**
   * Takes in an assigned motion and adds that motion to the created ArrayList of motions.
   *
   * @param motion the animation motion to be initialized, stored in an ArrayList with other
   * motions.
   */
  @Override
  public void addAnimation(IMotion motion) {
    motions.add(motion);
  }

}
