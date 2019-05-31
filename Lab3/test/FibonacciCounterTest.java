import static org.junit.Assert.assertEquals;

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
    assertEquals(2, fibonacci.decrementCount());

    fibonacci.incrementCount();
    fibonacci.incrementCount();
    assertEquals(3, fibonacci.decrementCount());
  }

  @Test
  public void testGetFibonacci() {
    assertEquals(2, fibonacci.getFibonacci());

    FibonacciCounter newTest = new FibonacciCounter(14);
    assertEquals(377, newTest.getFibonacci());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalInitialCount() {
    fibonacci = new FibonacciCounter(-2);
  }

  @Test(expected = IllegalStateException.class)
  public void testIllegalDecrement() {
    fibonacci = new FibonacciCounter(0);
    fibonacci.decrementCount();
  }

  @Test(expected = ArithmeticException.class)
  public void testOverflow() {
    fibonacci = new FibonacciCounter(47);
    fibonacci.getFibonacci();
  }

}