package cs5004.animator.model;

/**
 * This is an abstract class for Shapes. The Ellipse, Rectangle, and Triangle classes extend this
 * abstract class and utilize the constructor housed in this abstract class. This class implements
 * the interface IShape, which contains several getter functions for a coordinate location, width/
 * height, and RGB color values.
 */

public abstract class AShape implements IShape {

  protected final int x;
  protected final int y;
  protected final int w;
  protected final int h;
  protected final int r;
  protected final int g;
  protected final int b;

  /**
   * Constructor for an AShape abstract class. Takes in an x, y coordinate, width/height, and RGB
   * colors values to create the shape.
   *
   * @param x the x-coordinate of a reference point to the shape
   * @param y the y-coordinate of a reference point to the shape
   * @param w the width of the shape
   * @param h the height of the shape
   * @param r the red intensity for the shape's color
   * @param g the green intensity for the shape's color
   * @param b the blue intensity for the shape's color
   * @throws IllegalArgumentException if the width/height of the shape are a non-positive integer or
   * the RGB values are outside of an acceptable range.
   */
  protected AShape(int x, int y, int w, int h, int r, int g, int b)
      throws IllegalArgumentException {

    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Width and height must be positive!");
    }

    if (r < 0 || g < 0 || b < 0) {
      throw new IllegalArgumentException("RGB values must be positive!");
    }

    if (r > 255 || g > 255 || b > 255) {
      throw new IllegalArgumentException("RGB values must be less than 256!");
    }

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   * A getter that returns the x-coordinate value of a reference point to a shape.
   *
   * @return the x-coordinate of a reference point to a shape
   */
  @Override
  public int getX() {
    return this.x;
  }

  /**
   * A getter that returns the y-coordinate of a reference point to a shape.
   *
   * @return the y-coordinate of a reference point to a shape
   */
  @Override
  public int getY() {
    return this.y;
  }

  /**
   * A getter that returns the width of a shape.
   *
   * @return the width of a shape
   */
  @Override
  public int getW() {
    return this.w;
  }

  /**
   * A getter that returns the height of a shape.
   *
   * @return the height of a shape
   */
  @Override
  public int getH() {
    return this.h;
  }

  /**
   * A getter that returns the red intensity of a shape's color.
   *
   * @return the red intensity of a shape's color
   */
  @Override
  public int getR() {
    return this.r;
  }

  /**
   * A getter that returns the green intensity of a shape's color.
   *
   * @return the green intensity of a shape's color
   */
  @Override
  public int getG() {
    return this.g;
  }

  /**
   * A getter that returns the blue intensity  of a shape's color.
   *
   * @return the blue intensity of a shape's color
   */
  @Override
  public int getB() {
    return this.b;
  }

}
