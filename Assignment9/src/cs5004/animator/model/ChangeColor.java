package cs5004.animator.model;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class represents the ChangeColor animation type. This extends from the abstract class
 * AMotion. This class contains one constructor that utilizes a super function, which takes in a
 * start time, end time, and a COLOR MotionType. This constructor then assigns starting and ending
 * values for the red, green, and blue balances of the shape's color. This also contains a toString
 * method to print out the associated changes occurring with the animation, namely the color value
 * changes and start/end times.
 */
public class ChangeColor extends AMotion {

  private int fromR;
  private int fromG;
  private int fromB;
  private int toR;
  private int toG;
  private int toB;

  /**
   * A constructor for the changeColor function.  It checks to see if the shape has already changed
   * color and if so it takes the latest color of the shape as it's starting colors, otherwise it
   * starts with the color it was originally constructed width. One "ChangeColor" object represents
   * a changing color motion on the animation.
   *
   * @param allMotions a treemap of all of the existing motions in model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of the motion.
   * @param t2 the end time of the motion.
   * @param r2 the ending red value of the shape.
   * @param g2 the ending green value of the shape.
   * @param b2 the ending blue value of the shape.
   * @throws IllegalArgumentException if r g b values are not between 0-255 and if the animation is
   * not increasing in time.
   */
  public ChangeColor(TreeMap allMotions, AAnimatedShape animatedShape, int t1, int t2, int r2,
      int g2, int b2) throws IllegalArgumentException {
    super(t1, t2, MotionType.COLOR);

    if (r2 < 0 || g2 < 0 || b2 < 0) {
      throw new IllegalArgumentException("RGB values can't be negative!");
    }

    if (r2 > 255 || g2 > 255 || b2 > 255) {
      throw new IllegalArgumentException("RGB values can't exceed 255!");
    }

    if (t2 - t1 <= 0 || t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Animation can not be in reverse and cannot be negative.");
    }

    if (t1 < animatedShape.appearTime || t2 > animatedShape.disappearTime) {
      throw new IllegalArgumentException("Animation has to be within shape appear and " +
          "disappear time!");
    }

    TreeMap<IMotion, String> everyMotion = allMotions;
    ArrayList<ChangeColor> colorMotions = new ArrayList<>();

    if (everyMotion.size() <= 0) {
      this.fromR = animatedShape.shape.getR();
      this.fromG = animatedShape.shape.getG();
      this.fromB = animatedShape.shape.getB();
      this.toR = r2;
      this.toG = g2;
      this.toB = b2;
      if (this.fromR == r2 && this.fromG == g2 && this.fromB == b2) {
        throw new IllegalArgumentException("Animation must change the color of the shape!");
      }
      return;
    }

    for (IMotion key : everyMotion.keySet()) {
      if (key.getMotionType() == MotionType.COLOR) {
        colorMotions.add((ChangeColor) key);
      }
    }

    if (colorMotions.size() <= 0) {
      this.fromR = animatedShape.shape.getR();
      this.fromG = animatedShape.shape.getG();
      this.fromB = animatedShape.shape.getB();
      this.toR = r2;
      this.toG = g2;
      this.toB = b2;
      if (this.fromR == r2 && this.fromG == g2 && this.fromB == b2) {
        throw new IllegalArgumentException("Animation must change the color of the shape!");
      }
      return;
    }

    updateMotions(colorMotions, animatedShape, t1, r2, g2, b2);

    if (this.fromR == r2 && this.fromG == g2 && this.fromB == b2) {
      throw new IllegalArgumentException("Animation must change the color of the shape!");
    }
  }

  /**
   * A toString method to print out a representation of the color change animation.
   *
   * @return a string value that includes the starting and ending color balances and the start/end
   * time of the animation
   */
  @Override
  public String toString() {
    return "changes color from (" + fromR + ", " + fromG + ", " + fromB + ") to (" + toR
        + ", " + toG + ", " + toB + ") from t=" + startTime + " to t=" + endTime;
  }

  /**
   * A helper functinon that sifts through the existing moves in the game and checks to see if the
   * animated shape has changed color before.  If so, it sets the starting r g and b values to the r
   * g and b values the motion before it ended with.
   *
   * @param colorMotions a treemap of the existing motion in the model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of this motion
   * @param r2 the end r value of this shape
   * @param g2 the end g value of this shape
   * @param b2 the end b value of this shape
   */
  private void updateMotions(ArrayList<ChangeColor> colorMotions, AAnimatedShape animatedShape,
      int t1, int r2, int g2, int b2) {
    ChangeColor previousMotion = colorMotions.get(0);
    boolean lastLoop = false;

    for (ChangeColor motion : colorMotions) {

      if (lastLoop) {
        motion.setFromR(previousMotion.toR);
        motion.setFromG(previousMotion.toG);
        motion.setFromB(previousMotion.toB);
        break;
      }

      if (t1 < motion.getStartTime()) {
        this.fromR = animatedShape.shape.getR();
        this.fromG = animatedShape.shape.getG();
        this.fromB = animatedShape.shape.getB();
        this.toR = r2;
        this.toG = g2;
        this.toB = b2;
        motion.setFromR(r2);
        motion.setFromG(g2);
        motion.setFromB(b2);
        break;
      } else {
        if (t1 - motion.getEndTime() <= t1 - previousMotion.getEndTime()) {
          previousMotion = motion;
        }
        this.fromR = previousMotion.getToR();
        this.fromG = previousMotion.getToG();
        this.fromB = previousMotion.getToB();
        this.toR = r2;
        this.toG = g2;
        this.toB = b2;
        previousMotion = this;
        lastLoop = true;
      }
    }
  }

  /**
   * A getter for the ending r value.
   *
   * @return the ending r value
   */
  public int getToR() {
    return this.toR;
  }

  /**
   * A getter for the ending g value.
   *
   * @return the ending g value
   */
  public int getToG() {
    return this.toG;
  }

  /**
   * A getter for the ending b value.
   *
   * @return the ending b value
   */
  public int getToB() {
    return this.toB;
  }

  /**
   * A setter for the staring r value.
   *
   * @param r the new r value.
   */
  public void setFromR(int r) {
    this.fromR = r;
  }

  /**
   * A setter for the starting g value.
   *
   * @param g the new g value.
   */
  public void setFromG(int g) {
    this.fromR = g;
  }

  /**
   * A setter for the starting b value.
   *
   * @param b the new b value.
   */
  public void setFromB(int b) {
    this.fromR = b;
  }

}
