/**
 * This class represents the Move animation type. This extends from the abstract class AMotion.
 * This class contains one constructor that utilizes a super function, which takes in a start time,
 * end time, and a MOVE MotionType. This constructor then assigns starting and ending values for
 * the reference position of the shape. This also contains a toString method to print out the
 * associated changes occurring with the animation, namely the starting and ending coordinates.
 */
public class Move extends AMotion {

  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  /**
   * A constructor for the Move animation type. This calls a super function that uses the
   * AMotion default constructor, then sets starting and ending values for the reference point of
   * the shape.
   *
   * @param shape the shape to be moved
   * @param t1 the start time of the animation
   * @param t2 the end time of the animation
   * @param x2 the final position's x-coordinate
   * @param y2 the final position's y-coordinate
   * @throws IllegalArgumentException if the starting and ending position are the same
   */
  public Move(IShape shape, int t1, int t2, int x2, int y2) throws IllegalArgumentException {
    super(t1, t2, MotionType.MOVE);

    if ( shape.getX() == x2 && shape.getY() == y2 ) {
      throw new IllegalArgumentException("Animation must move between two locations!");
    }

    this.fromX = shape.getX();
    this.fromY = shape.getY();
    this.toX = x2;
    this.toY = y2;
  }

  /**
   * A toString method to print out a representation of the move animation.
   *
   * @return a string value that includes the starting and ending reference coordinates and the
   *         start/end time of the animation
   */
  @Override
  public String toString() {
    return "moves from (" + fromX + ", " + fromY + ") to (" + toX + ", " + toY
            + ") from t=" + startTime + " to t=" + endTime;

  }

}
