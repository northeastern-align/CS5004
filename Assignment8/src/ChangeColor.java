/**
 * This class represents the ChangeColor animation type. This extends from the abstract class
 * AMotion. This class contains one constructor that utilizes a super function, which takes in
 * a start time, end time, and a COLOR MotionType. This constructor then assigns starting and
 * ending values for the red, green, and blue balances of the shape's color. This also contains a
 * toString method to print out the associated changes occurring with the animation, namely the
 * color value changes and start/end times.
 */
public class ChangeColor extends AMotion {

  private int fromR;
  private int fromG;
  private int fromB;
  private int toR;
  private int toG;
  private int toB;

  /**
   * A constructor for a ChangeColor animation type. This calls a super function that uses the
   * AMotion default constructor, then sets starting and ending values for the color of the shape.
   *
   * @param shape the shape to undergo a color change
   * @param t1 the start time of the animation
   * @param t2 the end time of the animation
   * @param r2 the end red intensity of the shape's color
   * @param g2 the end green intensity of the shape's color
   * @param b2 the end blue intensity of the shape's color
   * @throws IllegalArgumentException if the starting and ending color are the same
   */
  public ChangeColor(IShape shape, int t1, int t2, int r2, int g2, int b2) throws IllegalArgumentException {
    super(t1, t2, MotionType.COLOR);

    if ( shape.getR() == r2 && shape.getG() == g2 && shape.getB() == b2 ) {
      throw new IllegalArgumentException("Animation must change the color of the shape!");
    }

    if ( r2 < 0 || g2 < 0 || b2 < 0 ) {
      throw new IllegalArgumentException("RGB values can't be negative!");
    }

    if ( r2 > 255 || g2 > 255 || b2 > 255 ) {
      throw new IllegalArgumentException("RGB values can't exceed 255!");
    }

    this.fromR = shape.getR();
    this.fromG = shape.getG();
    this.fromB = shape.getB();
    this.toR = r2;
    this.toG = g2;
    this.toB = b2;
  }

  /**
   * A toString method to print out a representation of the color change animation.
   *
   * @return a string value that includes the starting and ending color balances and the start/end
   *         time of the animation
   */
  @Override
  public String toString() {
    return "changes color from (" + fromR + ", " + fromG + ", " + fromB + ") to (" + toR
            + ", " + toG + ", " + toB + ") from t=" + startTime + " to t=" + endTime;
  }

}
