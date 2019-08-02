package cs5004.animator.model;

/**
 * This class represents the Rectangle shape type. This extends from the abstract class AShape. This
 * class contains one constructor that utilizes a super function, which takes in an x and y
 * coordinate, a width/height, and RGB color values. This class also contains a toString method to
 * print out the associated attributes of the shape, including the type, the reference coordinate
 * location, the width/height, and RGB color values.
 */
public class Rectangle extends AShape {

  protected Rectangle(int x, int y, int w, int h, int r, int g, int b) {
    super(x, y, w, h, r, g, b);
  }

  /**
   * A toString method to print out a representation of the created shape.
   *
   * @return a string value that includes the type of shape, the reference coordinate, the width/
   * height, and the RGB color values
   */
  @Override
  public String toString() {
    return "Type: rectangle\nCorner: (" + x + ", " + y + "), Width: " + w + ", Height: " + h
        + ", Color: (" + r + ", " + g + ", " + b + ")\n";
  }
}
