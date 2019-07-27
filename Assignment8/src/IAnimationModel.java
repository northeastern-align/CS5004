/**
 * This interface represents the AnimationModel methods offered. The model implements the actual
 * functionality of the Animation assignment.
 */
public interface IAnimationModel {

  /**
   * Creates a shape to add to the animation model.
   *
   * @param id a String identification assigned to the shape
   * @param type the type of shape created
   * @param t1 the start (appearance) time of the shape
   * @param t2 the end (disappearance) time of the shape
   * @param x the x-coordinate of a reference point for the shape
   * @param y the y-coordinate of a reference points for the shape
   * @param w the width of the shape
   * @param h the height of the shape
   * @param r the red-balance of the shape's color
   * @param g the green-balance of the shape's color
   * @param b the blue-balance of the shape's color
   */
  void addShape(String id, ShapeType type, int t1, int t2, int x, int y, int w, int h,
                int r, int g, int b);

  // There is a way to make just an addMotion method and allow multiple different parameters,
  // similar to having multiple constructions, I'm just not sure how.

  /**
   * Creates a Scale animation and assigns to a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param w2 the ending width after the scaling animation
   * @param h2 the ending height after the scaling animation
   */
  void addScaleMotion(String id, int t1, int t2, int w2, int h2);

  /**
   * Creates a Move animation and assigns to a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param x2 the ending x-coordinate of the reference point for the shape
   * @param y2 the ending y-coordinate of the reference point for the shape
   */
  void addMoveMotion(String id, int t1, int t2, int x2, int y2);

  /**
   * Creates a ColorChange animation and assigns it ot a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param r2 the ending red intensity of the shape's color
   * @param g2 the ending green intensity of the shape's color
   * @param b2 the ending blue intensity of the shape's color
   */
  void addColorChangeMotion(String id, int t1, int t2, int r2, int g2, int b2);

  /**
   * Removes a shape using the ID as a reference.
   *
   * @param id a String identification to identify the shape to remove
   */
  void removeShape(String id);

  /**
   * Prints out the toString methods of the shapes and animations.
   *
   * @return a string listing out the shapes and animations
   */
  String getState();

  /**
   * Returns the state of the AnimatedShape at a particular frame, interpolated given the start
   * and stop time of the animation.
   *
   * @param frame the particular frame to view the status of the animation at
   * @return a shape representing the shape's characteristics at that particular frame
   */
  java.util.List<IShape> getShapesAtFrame(int frame);
}
