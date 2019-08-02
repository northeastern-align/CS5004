package cs5004.animator.model;

import java.util.ArrayList;
import java.util.TreeMap;

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
   * A constructor a scale function.  It checks to see if the shape has already scaled and if so it
   * takes the width and height it scaled to to as it's starting positions, otherwise it takes the
   * width and height from when the shape was constructed as it's starting width and height. One
   * "Scale" object represents a scale on the animation.
   *
   * @param allMotions a treemap of all of the existing motions in model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of the motion.
   * @param t2 the end time of the motion.
   * @param w2 the end width of the motion.
   * @param h2 the end height of the motion.
   * @throws IllegalArgumentException if time is not increasing or the width or height are < 1
   */
  public Scale(TreeMap allMotions, AAnimatedShape animatedShape, int t1, int t2, int w2, int h2)
      throws IllegalArgumentException {

    super(t1, t2, MotionType.SCALE);

    TreeMap<IMotion, String> everyMotion = allMotions;
    ArrayList<Scale> scaleMotions = new ArrayList<>();

    if (t2 - t1 <= 0 || t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Animation can not be in reverse and cannot be negative.");
    }

    if (w2 < 1 || h2 < 1) {
      throw new IllegalArgumentException("Dimensions of the shape can't be non-positive!");
    }

    if (everyMotion.size() <= 0) {
      this.startW = animatedShape.shape.getW();
      this.startH = animatedShape.shape.getH();
      this.endW = w2;
      this.endH = h2;
      if (this.startW == w2 && this.startH == h2) {
        throw new IllegalArgumentException("Dimensions of the shape must change to animate!");
      }
      return;
    }

    for (IMotion key : everyMotion.keySet()) {
      if (key.getMotionType() == MotionType.SCALE) {
        scaleMotions.add((Scale) key);
      }
    }

    if (scaleMotions.size() <= 0) {
      this.startW = animatedShape.shape.getW();
      this.startH = animatedShape.shape.getH();
      this.endW = w2;
      this.endH = h2;
      if (this.startW == w2 && this.startH == h2) {
        throw new IllegalArgumentException("Dimensions of the shape must change to animate!");
      }
      return;
    }

    updateMotions(scaleMotions, animatedShape, t1, w2, h2);

    if (this.startW == w2 && this.startH == h2) {
      throw new IllegalArgumentException("Dimensions of the shape must change to animate!");
    }
  }

  /**
   * A toString method to print out a representation of the scale animation.
   *
   * @return a string value that includes the starting and ending width and height of the shape and
   * the start/end time of the animation
   */
  @Override
  public String toString() {
    return "scales from (" + startW + ", " + startH + ") to (" + endW + ", " + endH
        + ") from t=" + startTime + " to t=" + endTime;
  }

  /**
   * A helper function that sifts through the existing scales in the game and checks to see if the
   * animated shape has been scaled before, and if so sets the start w and h of this motion to the
   * end w and h of that motion.
   *
   * @param scaleMotions a treemap of all of the existing motions in model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of this motion.
   * @param w2 the end width of this motion.
   * @param h2 the end height position of this motion.
   */
  private void updateMotions(ArrayList<Scale> scaleMotions, AAnimatedShape animatedShape, int t1,
      int w2, int h2) {

    Scale previousMotion = scaleMotions.get(0);
    boolean lastLoop = false;

    for (Scale motion : scaleMotions) {

      if (lastLoop) {
        System.out.println(previousMotion);
        motion.setFromW(previousMotion.endW);
        motion.setFromH(previousMotion.endH);
        break;
      }

      if (t1 < motion.getStartTime()) {
        this.startW = animatedShape.shape.getW();
        this.startH = animatedShape.shape.getH();
        this.endW = w2;
        this.endH = h2;
        motion.setFromW(w2);
        motion.setFromH(h2);
        break;

      } else {
        if (t1 - motion.getEndTime() <= t1 - previousMotion.getEndTime()) {
          previousMotion = motion;
          this.startW = previousMotion.getToW();
          this.startH = previousMotion.getToH();
          this.endW = w2;
          this.endH = h2;
          previousMotion = this;
          lastLoop = true;
        }
      }
    }
  }

  /**
   * Getter for the ending width.
   *
   * @return the ending width
   */
  public int getToW() {
    return this.endW;
  }

  /**
   * Getter for the ending height.
   *
   * @return the ending height
   */
  public int getToH() {
    return this.endH;
  }

  /**
   * Setter for the starting width.
   *
   * @param w the new starting width
   */
  public void setFromW(int w) {
    this.startW = w;
  }

  /**
   * Setter for the starting height.
   *
   * @param h the new starting height
   */
  public void setFromH(int h) {
    this.startH = h;
  }

}
