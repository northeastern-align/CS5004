import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test class for FibonacciCounter.
 */

public class FibonacciCounterTest {
  private FibonacciCounter fibonacci;

  @Before
  public void setUp() {

    fibonacci = new FibonacciCounter(3);
  }

  @Test
  public void testGetCurrentCount() {
    assertEquals(3, fibonacci.getCurrentCount());
  }

  @Test
  public void testIncrementCount() {
    assertEquals(4, fibonacci.incrementCount());
  }

  @Test
  public void testDecrementCount() {
    assertEquals(3, fibonacci.decrementCount());

    fibonacci.incrementCount();
    fibonacci.incrementCount();
    assertEquals(4, fibonacci.decrementCount());
  }

  @Test
  public void testGetFibonacci() {
    assertEquals(2, fibonacci.getFibonacci());

    FibonacciCounter newTest = new FibonacciCounter(14);
    assertEquals(377, newTest.getFibonacci());
  }
}