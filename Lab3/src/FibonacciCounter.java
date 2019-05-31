import java.util.Objects;

/**
 * This class represents a single Fibonacci counter (takes on initial count value and tracks current
 * count).
 * Resources: https://www.tutorialspoint.com/java-program-to-check-for-integer-overflow
 */

public class FibonacciCounter {

  private int initialCount;
  private int currentCount;

  /**
   * Construct a FibonacciCounter object that has an initial count.
   *
   * @param initialCount the start of the FibonacciCounter
   * @throws IllegalArgumentException if initial count is not a positive number.
   */
  public FibonacciCounter(int initialCount) throws IllegalArgumentException {
    if (initialCount < 0) {
      throw new IllegalArgumentException("Initial count must be a non-negative number!");
    }
    this.initialCount = initialCount;
    this.currentCount = initialCount;
  }

  /**
   * Increment the Fibonacci current count by 1.
   *
   * @return the incremented current count
   */
  public int incrementCount() {
    this.currentCount++;
    return this.currentCount;
  }

  /**
   * Decrement the Fibonacci current count by 1.
   *
   * @return the decremented current count
   * @throws IllegalStateException if count becomes a negative number
   */
  public int decrementCount() throws IllegalStateException {
    if (this.currentCount <= 0) {
      throw new IllegalStateException("Count must be a non-negative number!");
    }

    this.currentCount--;
    return this.currentCount;

  }

  /**
   * Returns the current count of the Fibonacci number.
   *
   * @return the current count of the Fibonacci sequence
   */
  public int getCurrentCount() {
    return this.currentCount;
  }

  /**
   * Calculates the Fibonacci number based on the current count.
   *
   * @return the calculated Fibonacci number based on current count
   * @throws ArithmeticException when Fibonacci number is greater than MAX_VALUE of int
   */
  public int getFibonacci() throws ArithmeticException {

    long fibonacci = (long) ((1 / Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5)) / 2),
        this.currentCount) - Math.pow(((1 - Math.sqrt(5)) / 2), this.currentCount)));

    if (fibonacci > Integer.MAX_VALUE) {
      throw new ArithmeticException("Overflow!");
    }

    return (int) ((1 / Math.sqrt(5)) * (Math.pow(((1 + Math.sqrt(5)) / 2), this.currentCount)
        - Math.pow(((1 - Math.sqrt(5)) / 2), this.currentCount)));
  }

  // Overrides equals method
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

  // Overrides hashCode
  @Override
  public int hashCode() {
    return Objects.hash(initialCount, currentCount);
  }

}
