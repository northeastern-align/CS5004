package cs5004.animator.model;

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
   * @throws IllegalArgumentException is the shape is not a valid ShapeType
   */
  void addShape(String id, ShapeType type, int t1, int t2, int x, int y, int w, int h,
      int r, int g, int b) throws IllegalArgumentException;

  /**
   * Creates a Scale animation and assigns to a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param w2 the ending width after the scaling animation
   * @param h2 the ending height after the scaling
   * @throws IllegalArgumentException if there is already a scale motion during that time frame, or
   * *                                  the shape id is not an existing shape.
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
   * @throws IllegalArgumentException if there is already a move motion during that time frame, of
   * if the shape id is not an existing shape.
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
   * @throws IllegalArgumentException if there is already a color change motion during that time *
   * frame of the shape id is not an existing shape
   */
  void addColorChangeMotion(String id, int t1, int t2, int r2, int g2, int b2);

  /**
   * Prints out the toString methods of the shapes and animations.
   *
   * @return a string listing out the shapes and animations
   */
  String getState();

  /**
   * Returns the state of the AnimatedShape at a particular frame, interpolated given the start and
   * stop time of the animation. NOT CURRENTLY ACTIVE
   *
   * @param frame the particular frame to view the status of the animation at
   * @return a shape representing the shape's characteristics at that particular frame
   */
  java.util.List<IShape> getShapesAtFrame(int frame);
}
