/**
 * This interface represents the Motion methods offered. This includes a two getters to return the
 * start and stop time of the animation.
 */
public interface IMotion {

  /**
   * A getter that returns the start time of a motion.
   *
   * @return the start time of a motion
   */
  int getStartTime();

  /**
   * A getter that returns the end time of a motion.
   *
   * @return the end time of a motion
   */
  int getEndTime();

}
