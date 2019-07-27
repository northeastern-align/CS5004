import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class AnimationModel implements IAnimationModel {
  private java.util.Map<String, IShape> shapes = new HashMap<>();
  private java.util.Map<String, AAnimatedShape> animatedShapes = new HashMap<>();
  private java.util.TreeMap<IMotion, String> motions = new TreeMap<>();
  private java.util.TreeMap<IMotion, String> sortedMotions = new TreeMap<>();

  @Override
  public void addShape(String id, ShapeType type, int t1, int t2, int x, int y, int w, int h,
                       int r, int g, int b) throws IllegalArgumentException {
    IShape shape;
    AAnimatedShape animatedShape;
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

  @Override
  public void addScaleMotion(String id, int t1, int t2, int w2, int h2) throws IllegalArgumentException {
    // RULES NEEDED:
    // t1 must be larger than or equal to animatedShape.appearTime
    // t2 must be less than or equal to animatedShape.disapperTime
    // t1 to t2 can't overlap with motion.t1 and motion.t2

    // t = 5 t = 20
    // t = 15 and t = 21

    for (IMotion key : motions.keySet()) {
      if (motions.get(key) == id) {
        if (!ExistingMove.validMove(key, t1, t2)){
          throw new IllegalArgumentException("Move already exits at that time!");
        }
      }
    }

    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }
    IMotion motion = new Scale(shapes.get(id), t1, t2, w2, h2);
    motions.put(motion, id);
    animatedShapes.get(id).addAnimation(motion);
  }

  @Override
  public void addMoveMotion(String id, int t1, int t2, int x2, int y2)
          throws IllegalArgumentException {
    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }
    IMotion motion = new Move(shapes.get(id), t1, t2, x2, y2);
    motions.put(motion, id);
    animatedShapes.get(id).addAnimation(motion);

  }

  @Override
  public void addColorChangeMotion(String id, int t1, int t2, int r2, int g2, int b2)
          throws IllegalArgumentException {
    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " is not a valid shape!");
    }
    IMotion motion = new ChangeColor(shapes.get(id), t1, t2, r2, g2, b2);
    motions.put(motion, id);
    animatedShapes.get(id).addAnimation(motion);

  }

  @Override
  public void removeShape(String id) throws IllegalArgumentException {
    if (!shapes.containsKey(id)) {
      throw new IllegalArgumentException(id + " does not exist!");
    }
    shapes.remove(id);
  }

  @Override
  public String getState() {
    sortedMotions.putAll(motions);

    String output = "Shapes:\n";

    for (String key : animatedShapes.keySet()) {
      output += "Name: " + key + "\n";
      output += animatedShapes.get(key).toString() + "\n";
    }

    for (IMotion key : sortedMotions.keySet()) {
      output += "Shape " + sortedMotions.get(key) + " " + key + "\n";
    }

    return output;
  }

  @Override
  public List<IShape> getShapesAtFrame(int frame) {
    // This is tricky but will be needed for the animation.  In this we'll need to return a list
    // of shapes at a certain frame so that the screen can render those shapes. Not sure if
    // this is fully needed for this part of the assignment though, we could leave it blank.
    return null;
  }
}
