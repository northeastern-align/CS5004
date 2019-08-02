package cs5004.animator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cs5004.animator.util.TweenModelBuilder;

/**
 * This interface represents the AnimationModel methods offered. The model implements the actual
 * functionality of the Animation assignment.
 */
public class AnimationModel implements IAnimationModel {

  private Map<String, IShape> shapes = new HashMap<>();
  private Map<String, AAnimatedShape> animatedShapes = new HashMap<>();
  private TreeMap<IMotion, String> motions = new TreeMap<>();

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
  @Override
  public void addShape(String id, ShapeType type, int t1, int t2, int x, int y, int w, int h,
      int r, int g, int b) throws IllegalArgumentException {
    IShape shape;
    AAnimatedShape animatedShape;

    if (t1 < 0 || t2 < 0) {
      throw new IllegalArgumentException("Time can't be a negative value!");
    }

    if (t2 <= t1) {
      throw new IllegalArgumentException("End time must be later than start time!");
    }

    switch (type) {
      case RECTANGLE:
        shape = new Rectangle(x, y, w, h, r, g, b);
        animatedShape = new AnimatedRectangle(shape, t1, t2);
        break;
      case ELLIPSE:
        shape = new Ellipse(x, y, w, h, r, g, b);
        animatedShape = new AnimatedEllipse(shape, t1, t2);
        break;
      case TRIANGLE:
        shape = new Triangle(x, y, w, h, r, g, b);
        animatedShape = new AnimatedTriangle(shape, t1, t2);
        break;
      default:
        shape = null;
        animatedShape = null;
    }
    if (shape != null) {
      shapes.putIfAbsent(id, shape);
      animatedShapes.putIfAbsent(id, animatedShape);

    } else {
      throw new IllegalArgumentException("Shape type: " + shape + " is not a valid shape type.");
    }
  }

  /**
   * Creates a Scale animation and assigns to a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param w2 the ending width after the scaling animation
   * @param h2 the ending height after the scaling animation
   * @throws IllegalArgumentException if there is already a scale motion during that time frame, or
   * the shape id is not an existing shape.
   */
  @Override
  public void addScaleMotion(String id, int t1, int t2, int w2, int h2)
      throws IllegalArgumentException {

    for (IMotion key : motions.keySet()) {
      if (motions.get(key) == id) {
        if (!ExistingMove.validMove(key, t1, t2, MotionType.SCALE)) {
          throw new IllegalArgumentException("Scale already exits at that time!");
        }
      }
    }

    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }

    IMotion motion = new Scale(motions, animatedShapes.get(id), t1, t2, w2, h2);
    motions.put(motion, id);
    animatedShapes.get(id).addAnimation(motion);
  }

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
  @Override
  public void addMoveMotion(String id, int t1, int t2, int x2, int y2)
      throws IllegalArgumentException {

    // Checks every motion against the rules
    for (IMotion key : motions.keySet()) {
      if (motions.get(key) == id) {
        if (!ExistingMove.validMove(key, t1, t2, MotionType.MOVE)) {
          throw new IllegalArgumentException("Move already exits at that time!");
        }
      }
    }

    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }

    IMotion motion = new Move(motions, animatedShapes.get(id), t1, t2, x2, y2);
    motions.put(motion, id);
    animatedShapes.get(id).addAnimation(motion);

  }

  /**
   * Creates a ColorChange animation and assigns it ot a shape.
   *
   * @param id a String identification used to identify the shape to apply the animation to
   * @param t1 the starting time of the animation
   * @param t2 the ending time of the animation
   * @param r2 the ending red intensity of the shape's color
   * @param g2 the ending green intensity of the shape's color
   * @param b2 the ending blue intensity of the shape's color
   * @throws IllegalArgumentException if there is already a color change motion during that time
   * frame of the shape id is not an existing shape
   */
  @Override
  public void addColorChangeMotion(String id, int t1, int t2, int r2, int g2, int b2)
      throws IllegalArgumentException {
    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }

    // Checks every motion against the rules
    for (IMotion key : motions.keySet()) {
      if (motions.get(key) == id) {
        if (!ExistingMove.validMove(key, t1, t2, MotionType.COLOR)) {
          throw new IllegalArgumentException("Color Change already exits at that time!");
        }
      }
    }

    IMotion motion = new ChangeColor(motions, animatedShapes.get(id), t1, t2, r2, g2, b2);
    motions.put(motion, id);

    animatedShapes.get(id).addAnimation(motion);

  }

  /**
   * Prints out the toString methods of the shapes and animations.
   *
   * @return a string listing out the shapes and animations
   */
  @Override
  public String getState() {

    StringBuilder endString = new StringBuilder();
    endString.append("Shapes:\n");

    for (String key : animatedShapes.keySet()) {
      endString.append("Name: " + key + "\n");
      endString.append(animatedShapes.get(key).toString() + "\n");
    }

    for (Map.Entry<IMotion, String> entry : motions.entrySet()) {
      endString.append("Shape " + entry.getValue() + " " + entry.getKey() + "\n");
    }

    return endString.toString();

  }

  /**
   * Returns the state of the AnimatedShape at a particular frame, interpolated given the start and
   * stop time of the animation. NOT CURRENTLY ACTIVE
   *
   * @param frame the particular frame to view the status of the animation at
   * @return a shape representing the shape's characteristics at that particular frame
   */
  @Override
  public List<IShape> getShapesAtFrame(int frame) {
    // This is tricky but will be needed for the animation.  In this we'll need to return a list
    // of shapes at a certain frame so that the screen can render those shapes. Not sure if
    // this is fully needed for this part of the assignment though, we could leave it blank.
    return null;
  }

  public static TweenModelBuilder getBuilder(){
    return new ModelBuilder();
  }

  public static class ModelBuilder implements TweenModelBuilder{

    IAnimationModel model;

    public ModelBuilder(){
      model = new AnimationModel();
    }

    @Override
    public TweenModelBuilder addOval(String name, float cx, float cy, float xRadius, float yRadius,
                                     float red, float green, float blue, int startOfLife,
                                     int endOfLife) {

      model.addShape(name, ShapeType.ELLIPSE, startOfLife, endOfLife, (int) cx, (int) cy,
              (int) xRadius, (int) yRadius, (int) red, (int) green, (int) blue);
      return this;
    }

    @Override
    public TweenModelBuilder addRectangle(String name, float lx, float ly, float width, float height, float red, float green, float blue, int startOfLife, int endOfLife) {
      model.addShape(name, ShapeType.RECTANGLE, startOfLife, endOfLife, (int) lx, (int) ly,
              (int) width, (int) height, (int) red, (int) green, (int) blue);
      return this;
    }

    @Override
    public TweenModelBuilder addMove(String name, float moveFromX, float moveFromY, float moveToX, float moveToY, int startTime, int endTime) {
      model.addMoveMotion(name, startTime, endTime, (int) moveToX, (int) moveToY);
      return this;
    }

    @Override
    public TweenModelBuilder addColorChange(String name, float oldR, float oldG, float oldB, float newR, float newG, float newB, int startTime, int endTime) {
      model.addColorChangeMotion(name, startTime, endTime, (int) newR, (int) newG, (int) newB);
      return this;
    }

    @Override
    public TweenModelBuilder addScaleToChange(String name, float fromSx, float fromSy, float toSx, float toSy, int startTime, int endTime) {
      model.addScaleMotion(name, startTime, endTime, (int) toSx, (int) toSy);
      return null;
    }

    @Override
    public IAnimationModel build() {
      return model;
    }
  }
}
