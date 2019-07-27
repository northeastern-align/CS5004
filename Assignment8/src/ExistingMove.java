/**
 * A class representing an existing motion of the same motion type during the same time span.
 * Returns true if there is, false if there isn't.
 */
public class ExistingMove {

  /**
   * Checks to see if there is already an existing move of that motion type. Returns true if yes,
   * flase if no.
   *
   * @param motion     the motion to be checked.
   * @param t1         the start time of the new animation.
   * @param t2         the end time of the new animation.
   * @param motionType the motion type of the new animation.
   * @return true if the time of the new animation will overlap with the old and they are the same
   * motion type.
   */
  public static boolean validMove(IMotion motion, int t1, int t2, MotionType motionType) {

    if (motion.getMotionType() == motionType) {

      if (t1 >= motion.getStartTime() && t1 < motion.getEndTime()) {
        return false;
      }

      if (t1 < motion.getStartTime() && t2 > motion.getStartTime()) {
        return false;
      }
    }
    return true;
  }
}
