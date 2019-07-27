/**
 * This interface represents the AnimatedShape methods offered. This includes a single function,
 * addAnimation, that can be fed a motion (i.e. move, scale, color change).
 */
public interface IAnimatedShape {

  /**
   * Takes in an assigned motion and adds that motion to a created ArrayList of motions.
   *
   * @param motion the animation motion to be initialized, stored in an ArrayList with other
   *        motions
   */
  void addAnimation(IMotion motion);

}
