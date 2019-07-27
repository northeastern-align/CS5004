/**
 * This is an abstract class for Motions. The Move, Scale, and ChangeColor classes extend this
 * abstract class and utilize the constructor housed in this abstract class. This abstract class
 * implements the interface of IMotion, which contains two getters, getStartTime and getEndTime.
 */
public abstract class AMotion implements IMotion, Comparable<AMotion> {

  protected MotionType motionType;
  protected int startTime;
  protected int endTime;

  /**
   * Constructor for AMotion abstract class. Takes in a start time, end time (integers), and
   * a motionType. This constructor is used by the Move, Scale, and ChangeColor classes.
   *
   * @param t1 the start time of the animation
   * @param t2 the end time of the animation
   * @param motionType the type of animation (Move, Scale, ChangeColor) to take place
   * @throws IllegalArgumentException if the provides time are negative or the start time is after
   *         the end times.
   */
  protected AMotion(int t1, int t2, MotionType motionType) throws IllegalArgumentException {

   if ( t1 >= t2 ) {
     throw new IllegalArgumentException("Time 2 must be after time 1!");
   }

   if ( t1 < 0 ) {
     throw new IllegalArgumentException("Time can't be negative!");
   }

    this.startTime = t1;
    this.endTime = t2;
    this.motionType = motionType;
  }

  /**
   * A getter that returns the start time of a motion.
   *
   * @return the start time of a motion
   */
  @Override
  public int getStartTime() {
    return startTime;
  }

  /**
   * A getter that returns the end time of a motion.
   *
   * @return the end time of a motion
   */
  @Override
  public int getEndTime() {
    return endTime;
  }

  /**
   * Using the Comparable, this function compares the start time of two motions to ultimately help
   * determine the order motions should take place.
   *
   * @param o a second AMotion object to be compared to
   * @return an integer representing the order the two motions should be sorted in
   */
  @Override
  public int compareTo(AMotion o) {
    int difference = this.startTime - o.getStartTime();

    if (difference == 0) {
      if (this.endTime - o.getEndTime() > 0) {
        difference = this.endTime - o.getEndTime();
      } else {
        difference = this.motionType.name().compareTo(o.motionType.name());
      }
    }

    return difference;
  }

}
