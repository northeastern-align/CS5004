/**
 * This interface represents the Shape methods offered. This includes seven getters to return the
 * x and y coordinates of a reference point, the width/height, and the RGB color values.
 */
public interface IShape {
  /**
   * A getter that returns the x-coordinate value of a reference point to a shape.
   *
   * @return the x-coordinate of a reference point to a shape
   */
  int getX();

  /**
   * A getter that returns the y-coordinate of a reference point to a shape.
   *
   * @return the y-coordinate of a reference point to a shape
   */
  int getY();

  /**
   * A getter that returns the width of a shape.
   *
   * @return the width of a shape
   */
  int getW();

  /**
   * A getter that returns the height of a shape.
   *
   * @return the height of a shape
   */
  int getH();

  /**
   * A getter that returns the red intensity of a shape's color.
   *
   * @return the red intensity of a shape's color
   */
  int getR();

  /**
   * A getter that returns the green intensity of a shape's color.
   *
   * @return the green intensity of a shape's color
   */
  int getG();

  /**
   * A getter that returns the blue intensity  of a shape's color.
   *
   * @return the blue intensity of a shape's color
   */
  int getB();

}
