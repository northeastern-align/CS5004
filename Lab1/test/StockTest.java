import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Stock class.
 */
public class StockTest {

  private Stock stock;

  @Before
  public void setUp() {

    stock = new Stock("Grant's Company", "GC", 20.00f, 100.15f,
        500.80f, 20000.50f, 30000.50f, 5);

  }

  @Test
  public void testCompany() {
    assertEquals("Grant's Company", stock.getCompany());
  }

  @Test
  public void testTicker() {
    assertEquals("GC", stock.getTicker());
  }

  @Test
  public void testPpus() {
    assertEquals(20.00f, stock.getPpus(), 0.0001);
  }

  @Test
  public void testYearLow() {
    assertEquals(100.15f, stock.getYearLow(), 0.0001);
  }

  @Test
  public void testYearHigh() {
    assertEquals(500.80f, stock.getYearHigh(), 0.0001);
  }

  @Test
  public void testDebts() {
    assertEquals(20000.50f, stock.getDebts(), 0.0001);
  }

  @Test
  public void testAssets() {
    assertEquals(30000.50f, stock.getAssets(), 0.0001);
  }

  @Test
  public void testRecommendation() {
    assertEquals(5, stock.getRecommendation(), 0.0001);
  }

}