import java.util.Objects;

/**
 * This class represents a Transmission box that is passed a speed, current gear, and speeds
 * thresholds for first, second, third, and forth gears.
 */
public class TransmissionBox {

  private int speed;
  private int currentGear;
  private int firstGear;
  private int secondGear;
  private int thirdGear;
  private int fourthGear;

  /**
   * Construct a TransmissionBox object that is passed current speed and four speed thresholds
   * indicating a shift to a new gear.
   *
   * @param speed the provided current speed of the car
   * @param firstGear the speed threshold to go from gear 1 to gear 2
   * @param secondGear the speed threshold to go from gear 2 to gear 3
   * @param thirdGear the speed threshold to go from gear 3 to gear 4
   * @param fourthGear the speed threshold to go from gear 4 to gear 5
   */
  public TransmissionBox(int speed, int firstGear, int secondGear, int thirdGear, int fourthGear) {
    this.speed = speed;
    this.firstGear = firstGear;
    this.secondGear = secondGear;
    this.thirdGear = thirdGear;
    this.fourthGear = fourthGear;
    this.currentGear = getGear();
  }

  /**
   * Returns the current gear of the car based on speed and object's speed thresholds.
   *
   * @return an integer indicating the current gear
   */
  public int getGear() {
    if (this.speed <= this.firstGear) {
      return 1;
    } else if (this.speed <= this.secondGear) {
      return 2;
    } else if (this.speed <= this.thirdGear) {
      return 3;
    } else if (this.speed <= this.fourthGear) {
      return 4;
    } else {
      return 5;
    }
  }

  /**
   * Returns a new TransmissionBox object at a faster speed.
   *
   * @return a new TransmissionBox object at a faster speed
   */
  public TransmissionBox speedUp() {
    return new TransmissionBox(this.speed + 2, this.firstGear, this.secondGear, this.thirdGear,
        this.fourthGear);
  }

  /**
   * Returns a new TransmissionBox object at a slower speed.
   *
   * @return a new TransmissionBox object at a slower speed
   */
  public TransmissionBox slowDown() {
    return new TransmissionBox(this.speed - 2, this.firstGear, this.secondGear, this.thirdGear,
        this.fourthGear);
  }

  /**
   * Returns the current speed of the object.
   *
   * @return the current speed of the object
   */
  public int getSpeed() {
    return this.speed;
  }

  /**
   * Returns the current gear of the object.
   *
   * @return the current gear of the object
   */
  public int getCurrentGear() {
    return this.currentGear;
  }

  /**
   * Returns a string stating the current speed and gear of the object.
   *
   * @return a string stating the current speed and gear of the object
   */
  public String toString() {
    return ("Current speed is " + this.speed + " and current gear is " + this.currentGear + ".");
  }

  @Override
  public boolean equals(Object transmissionOne) {
    if (this == transmissionOne) {
      return true;
    }

    if (!(transmissionOne instanceof TransmissionBox)) {
      return false;
    }

    TransmissionBox other = (TransmissionBox) transmissionOne;

    return (this.speed == other.speed
        && this.firstGear == other.firstGear
        && this.secondGear == other.secondGear
        && this.thirdGear == other.thirdGear
        && this.fourthGear == other.fourthGear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(speed, currentGear, firstGear, secondGear,
        thirdGear, fourthGear);
  }
}
