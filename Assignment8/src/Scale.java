/**
 * This class represents the Scale animation type. This extends from the abstract class AMotion.
 * This class contains one constructor that utilizes a super function, which takes in a start time,
 * end time, and a SCALE MotionType. This constructor then assigns starting and ending values for
 * the width and height of the shape. This also contains a toString method to print out the
 * associated changes occurring with the animation, namely the starting and ending width/height.
 */
public class Scale extends AMotion {
  private int startW;
  private int startH;
  private int endW;
  private int endH;

  /**
   * A constructor for the Scale animation type. This calls a super function that uses the
   * AMotion default constructor, then sets starting and ending values for the size of the shape.
   *
   * @param shape the shape to be moved
   * @param t1 the start time of the animation
   * @param t2 the end time of the animation
   * @param w2 the final width of the shape
   * @param h2 the final height of the shape
   * @throws IllegalArgumentException if the starting and ending position are the same
   */
  public Scale(IShape shape, int t1, int t2, int w2, int h2) throws IllegalArgumentException {
    super(t1, t2, MotionType.SCALE);

    if (shape.getW() == w2 && shape.getH() == h2) {
      throw new IllegalArgumentException("Dimensions of the shape must change to animate!");
    }

    if (w2 < 1 || h2 < 1) {
      throw new IllegalArgumentException("Dimensions of the shape can't be non-positive!");
    }

    this.startW = shape.getW();
    this.startH = shape.getH();
    this.endW = w2;
    this.endH = h2;
  }

  /**
   * A toString method to print out a representation of the scale animation.
   *
   * @return a string value that includes the starting and ending width and height of the shape
   *         and the start/end time of the animation
   */
  @Override
  public String toString() {
    return "scales from (" + startW + ", " + startH + ") to (" + endW + ", " + endH
            + ") from t=" + startTime + " to t=" + endTime;
  }

}
