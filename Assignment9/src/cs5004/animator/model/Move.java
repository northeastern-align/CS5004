package cs5004.animator.model;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * This class represents the Move animation type. This extends from the abstract class AMotion. This
 * class contains one constructor that utilizes a super function, which takes in a treemap of the
 * existing motions in the same, the animated shape that is being moves, as well as the start time,
 * end time, end x position and end y position.  The starting and ending positions for the move
 * motion are based on the previous ending position of the last motion. This also contains a
 * toString method to print out the associated changes occurring with the animation, namely the
 * starting and ending coordinates.
 */
public class Move extends AMotion {

  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  /**
   * A constructor a move function.  It checks to see if the shape has already moved and if so it
   * takes the positions it moved to as it's starting positions, otherwise it starts where the shape
   * was originally created. One "Move" object represents a move on the animation.
   *
   * @param allMotions a treemap of all of the existing motions in model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of the motion.
   * @param t2 the end time of the motion.
   * @param x2 the end x position of the motion.
   * @param y2 the end y position of the motion.
   * @throws IllegalArgumentException if the time is not increasing or the animation is not moving.
   */
  public Move(TreeMap allMotions, AAnimatedShape animatedShape, int t1, int t2, int x2, int y2)
      throws IllegalArgumentException {

    super(t1, t2, MotionType.MOVE);

    if (t2 - t1 <= 0 || t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Animation can not be in reverse and cannot be negative.");
    }

    TreeMap<IMotion, String> everyMotion = allMotions;
    ArrayList<Move> moveMotions = new ArrayList<>();

    if (everyMotion.size() <= 0) {
      this.fromX = animatedShape.shape.getX();
      this.fromY = animatedShape.shape.getY();
      this.toX = x2;
      this.toY = y2;
      if (this.fromX == x2 && this.fromY == y2) {
        throw new IllegalArgumentException("Animation must move between two locations!");
      }
      return;
    }

    for (IMotion key : everyMotion.keySet()) {
      if (key.getMotionType() == MotionType.MOVE) {
        moveMotions.add((Move) key);
      }
    }

    if (moveMotions.size() <= 0) {
      this.fromX = animatedShape.shape.getX();
      this.fromY = animatedShape.shape.getY();
      this.toX = x2;
      this.toY = y2;
      if (this.fromX == x2 && this.fromY == y2) {
        throw new IllegalArgumentException("Animation must move between two locations!");
      }
      return;
    }

    updateMotions(moveMotions, animatedShape, t1, x2, y2);

    if (this.fromX == x2 && this.fromY == y2) {
      throw new IllegalArgumentException("Animation must move between two locations!");
    }
  }

  /**
   * A toString method to print out a representation of the move animation.
   *
   * @return a string value that includes the starting and ending reference coordinates and the
   * start/end time of the animation
   */
  @Override
  public String toString() {
    return "moves from (" + fromX + ", " + fromY + ") to (" + toX + ", " + toY
        + ") from t=" + startTime + " to t=" + endTime;

  }

  /**
   * A helper function that sifts through the existing moves in the game and checks to see if the
   * animated shape has been moved before, and if so sets the start location of this motion to the'
   * end location of that motion.
   *
   * @param moveMotions a treemap of all of the existing motions in model.
   * @param animatedShape the animated shape of which the motion is being added.
   * @param t1 the start time of this motion.
   * @param x2 the end x position of this motion.
   * @param y2 the end y position of this motion.
   */
  private void updateMotions(ArrayList<Move> moveMotions, AAnimatedShape animatedShape, int t1,
      int x2, int y2) {
    Move previousMotion = moveMotions.get(0);
    boolean lastLoop = false;

    for (Move motion : moveMotions) {

      if (lastLoop) {
        motion.setFromX(previousMotion.toX);
        motion.setFromY(previousMotion.toY);
        break;
      }

      if (t1 < moveMotions.get(0).getStartTime()) {
        this.fromX = animatedShape.shape.getX();
        this.fromY = animatedShape.shape.getY();
        this.toX = x2;
        this.toY = y2;
        motion.setFromX(x2);
        motion.setFromY(y2);
        break;
      } else {
        if (t1 - motion.getEndTime() <= t1 - previousMotion.getEndTime()) {
          previousMotion = motion;
          this.fromX = previousMotion.getToX();
          this.fromY = previousMotion.getToY();
          this.toX = x2;
          this.toY = y2;
          previousMotion = this;
          lastLoop = true;
        }
      }
    }
  }

  /**
   * Getter for the ending x value.
   *
   * @return the ending x value
   */
  public int getToX() {
    return this.toX;
  }

  /**
   * Getter for the ending y value.
   *
   * @return the ending y value
   */
  public int getToY() {
    return this.toY;
  }

  /**
   * Setter for the starting x value.
   *
   * @param x the new value for fromX
   */
  public void setFromX(int x) {
    this.fromX = x;
  }

  /**
   * Setter for the starting y value.
   *
   * @param y the new value for fromY.
   */
  public void setFromY(int y) {
    this.fromY = y;
  }


}
