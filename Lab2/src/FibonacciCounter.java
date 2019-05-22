import java.util.Objects;

/**
 * This class represents a single Fibonacci counter (takes on initial count value and tracks current
 * count).
 */

public class FibonacciCounter {

  private int initialCount;
  private int currentCount;

  /**
   * Construct a FibonacciCounter object that has an initial count.
   *
   * @param initialCount the start of the FibonacciCounter
   */
  public FibonacciCounter(int initialCount) {
    this.initialCount = initialCount;
    this.currentCount = initialCount;
  }

  public int incrementCount() {
    this.currentCount++;
    return this.currentCount;
  }

  public int decrementCount() {
    if (this.currentCount > this.initialCount) {
      this.currentCount--;
      return this.currentCount;
    } else {
      return this.currentCount;
    }
  }

  public int getCurrentCount() {
    return this.currentCount;
  }

  public int getFibonacci() {
    return (int) ((1 / Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5)) / 2), this.currentCount)
        - Math.pow(((1 - Math.sqrt(5)) / 2), this.currentCount)));
  }

  @Override
  public boolean equals(Object temp) {
    if (this == temp) {
      return true;
    }

    if (!(temp instanceof FibonacciCounter)) {
      return false;
    }

    FibonacciCounter other = (FibonacciCounter) temp;

    return (this.getFibonacci() == other.getFibonacci() || this.currentCount == other.currentCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initialCount, currentCount);
  }

}
