/**
 * This class represents the AnimatedEllipse animated shape type. This extends from the abstract
 * class AAnimatedShape. This class contains one constructor that utilizes a super function, which
 * takes in a non-animated shape and a start (appearance) time and end (disappearance time). This
 * also contains a toString method to print out the associated information with the ellipse,
 * including center location, width/height, color, and times.
 */
public class AnimatedEllipse extends AAnimatedShape {

  /**
   * Constructor that calls the super function to defer to the default constructor in
   * AAnimatedShape.
   *
   * @param shape the shape to be animated
   * @param t1    the animation start (appearance) time
   * @param t2    the animation end (disappearance) time
   */
  public AnimatedEllipse(IShape shape, int t1, int t2) {
    super(shape, t1, t2);
  }

  /**
   * A toString method to print out a representation of the created animation.
   *
   * @return a string value that includes the shape type, center location, width/height, color (RGB
   * values), and start/end (appearance/disappearance) times
   */
  @Override
  public String toString() {
    return "Type: Circle\nCenter: (" + shape.getX() + ", " + shape.getY() + "), Width: "
            + shape.getW() + ", Height: " + shape.getH() + ", Color: (" + shape.getR() + ", "
            + shape.getG() + ", " + shape.getB() + ")\nAppears at t=" + appearTime
            + "\nDisappears at t=" + disappearTime + "\n";
  }

}
