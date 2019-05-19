import java.util.Objects;

/**
 * This class represents a 3D vector that has an x, y, and z component.
 * Resources: Override - https://www.geeksforgeeks.org/overriding-equals-method-in-java/
 * Override hashCode() - https://medium.com/@biratkirat/learning-effective-java-item-9-6b00f8eabd47
 */
public class Vector3D {

  private double xCord;
  private double yCord;
  private double zCord;

  /**
   * Construct a Vector3D object that has x, y, and z component.
   *
   * @param xCord the user provided x-coordinate of the vector
   * @param yCord the user provided y-coordinate of the vector
   * @param zCord the user provided z-coordinate of the vector
   */
  public Vector3D(double xCord, double yCord, double zCord) {
    this.xCord = xCord;
    this.yCord = yCord;
    this.zCord = zCord;
  }

  /**
   * Return the x-coordinate of a vector.
   *
   * @return the x-coordinate of a vector
   */
  public double getX() {
    return this.xCord;
  }

  /**
   * Return the y-coordinate of a vector.
   *
   * @return the y-coordinate of a vector
   */
  public double getY() {
    return this.yCord;
  }

  /**
   * Return the z-coordinate of a vector.
   *
   * @return the z-coordinate of a vector
   */
  public double getZ() {
    return this.zCord;
  }

  /**
   * Returns a string of the vector coordinates in the form (x,y,z).
   *
   * @return a string of the vector coordinates in the form (x,y,z)
   */
  public String toString() {
    String xCordStr = String.format("%.2f", this.xCord);
    String yCordStr = String.format("%.2f", this.yCord);
    String zCordStr = String.format("%.2f", this.zCord);

    return "(" + xCordStr + "," + yCordStr + "," + zCordStr + ")";
  }

  /**
   * Returns the magnitude of the vector.
   *
   * @return the magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(Math.pow(this.xCord, 2) + Math.pow(this.yCord, 2) + Math.pow(this.zCord, 2));
  }

  /**
   * Returns the normalized vector (each direction divided by magnitude).
   *
   * @return a new vector that is equivalent of the normalized vector coordinates
   */
  public Vector3D normalize() {
    double magnitude = getMagnitude();

    if (magnitude != 0) {
      return new Vector3D(this.xCord / magnitude, this.yCord / magnitude,
          this.zCord / magnitude);
    }

    throw new IllegalStateException("The magnitude can't be equal to zero!");

  }

  /**
   * Returns a string of two vector coordinates added together.
   *
   * @param other a Vector3D object to get added
   * @return a new vector that is equivalent to the two vector coordinates added together
   */
  public Vector3D add(Vector3D other) {
    return new Vector3D(this.xCord + other.xCord, this.yCord + other.yCord,
        this.zCord + other.zCord);
  }

  /**
   * Returns vector parameters after multiplied by a constant.
   *
   * @param constant a constant multiplier value
   * @return a new vector that is equivalent to the old vector multiplied by a constant
   */
  public Vector3D multiply(double constant) {
    return new Vector3D(this.xCord * constant, this.yCord * constant,
        this.zCord * constant);
  }

  /**
   * Returns the dot product of two Vector3D objects.
   *
   * @param other a second Vector3D object to be used in dot product calculation
   * @return a double representing the dot product of two vectors
   */
  public double dotProduct(Vector3D other) {
    return ((this.xCord * other.xCord) + (this.yCord * other.yCord) + (this.zCord * other.zCord));
  }

  /**
   * Returns the angle between two vectors.
   *
   * @param other a second Vector3D object to be used to find the angle between
   * @return a double representing the angle between two vectors
   */
  public double angleBetween(Vector3D other) {

    double firstMagnitude = this.getMagnitude();
    double secondMagnitude = other.getMagnitude();

    if ((firstMagnitude * secondMagnitude) != 0) {
      return (Math.toDegrees(Math.acos(dotProduct(other) / (firstMagnitude * secondMagnitude))));
    }

    throw new IllegalStateException("The magnitudes can't be equal to zero!");
  }

  // Compares two objects to be equal
  @Override
  public boolean equals(Object vectorOne) {
    if (this == vectorOne) {
      return true;
    }

    if (!(vectorOne instanceof Vector3D)) {
      return false;
    }

    Vector3D vectorTwo = (Vector3D) vectorOne;

    return (Math.abs(this.xCord - vectorTwo.xCord) < 0.01
         && Math.abs(this.yCord - vectorTwo.yCord) < 0.01
         && Math.abs(this.zCord - vectorTwo.zCord) < 0.01);
  }

  // Written to resolve submission server error
  @Override
  public int hashCode() {
    return Objects.hash(xCord, yCord, zCord);
  }

}