import java.awt.geom.Point2D;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This class represents a Rectangle that is passed an x-coord, y-coord, width, and height.
 */

public class Rectangle {

  private Point2D bottomLeft;
  private Point2D topRight;
  private double width;
  private double height;

  /**
   * Construct a Rectangle object that is passed an x-coord, y-coord (bottom left corner) and a
   * width and height.
   *
   * @param xCord the x-coordinate of the lower left hand corner of the rectangle
   * @param yCord the y-coordinate of the lower left hand corner of the rectangle
   * @param width the width (x-distance) of the rectangle
   * @param height the height (y-distance) of the rectangle
   * @throws IllegalArgumentException if the passed width or height is not positive.
   */
  public Rectangle(double xCord, double yCord, double width, double height)
      throws IllegalArgumentException {

    if (width > 0 && height > 0) {
      this.bottomLeft = new Point2D.Double(xCord, yCord);
      this.topRight = new Point2D.Double(xCord + width, yCord + height);
      this.width = width;
      this.height = height;
    } else {
      throw new IllegalArgumentException("Width and height must be positive integers!");
    }
  }

  /**
   * Returns a boolean value if two rectangles overlap.
   *
   * @param other a second rectangle object to compare to
   * @return boolean if an overlap is present
   */
  public boolean overlap(Rectangle other) {

    return !(this.topRight.getX() <= other.bottomLeft.getX()
        || other.topRight.getX() <= this.bottomLeft.getX()
        || this.topRight.getY() <= other.bottomLeft.getY()
        || other.topRight.getY() <= this.bottomLeft.getY());
  }

  /**
   * Returns a new rectangle that represents the intersection of two rectangles.
   *
   * @param other a second rectangle object to compare to
   * @return a new rectangle object that represents the intersection of two rectangles
   * @throws NoSuchElementException if the rectangles do not overlap
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {

    if (!this.overlap(other)) {
      throw new NoSuchElementException("The rectangles don't overlap!");
    } else {
      double leftX = Math.max(this.bottomLeft.getX(), other.bottomLeft.getX());
      double rightX = Math.min(this.topRight.getX(), other.topRight.getX());
      double bottomY = Math.max(this.bottomLeft.getY(), other.bottomLeft.getY());
      double topY = Math.min(this.topRight.getY(), other.topRight.getY());

      return new Rectangle(leftX, bottomY, rightX - leftX, topY - bottomY);
    }
  }

  /**
   * Returns a new rectangle that represents the union of two rectangles.
   *
   * @param other a second rectangle object to compare to
   * @return a new rectangle object that represents the union of two rectangles
   */
  public Rectangle union(Rectangle other) {

    double leftX = Math.min(this.bottomLeft.getX(), other.bottomLeft.getX());
    double rightX = Math.max(this.topRight.getX(), other.topRight.getX());
    double bottomY = Math.min(this.bottomLeft.getY(), other.bottomLeft.getY());
    double topY = Math.max(this.topRight.getY(), other.topRight.getY());

    return new Rectangle(leftX, bottomY, rightX - leftX, topY - bottomY);
  }

  /**
   * Returns a string stating the x-coord, y-coord, width, and height. Values are rounded based on
   * submission server JUnit testing feedback.
   *
   * @return a string stating the x-coord, y-coord, width, and height
   */
  public String toString() {
    return "x:" + Math.round(this.bottomLeft.getX()) + ", y:" + Math.round(this.bottomLeft.getY())
        + ", w:" + Math.round(this.width) + ", h:" + Math.round(this.height);
  }

  @Override
  public boolean equals(Object rectangle) {
    if (this == rectangle) {
      return true;
    }

    if (!(rectangle instanceof Rectangle)) {
      return false;
    }

    Rectangle other = (Rectangle) rectangle;

    return (this.bottomLeft.getX() == other.bottomLeft.getX()
        && this.bottomLeft.getY() == other.bottomLeft.getY()
        && this.topRight.getX() == other.topRight.getX()
        && this.topRight.getY() == other.topRight.getY());
  }

  @Override
  public int hashCode() {
    return Objects.hash(bottomLeft, topRight, width, height);
  }
}
