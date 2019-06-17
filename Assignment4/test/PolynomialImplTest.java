import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Polynomial.
 */
public class PolynomialImplTest {

  private PolynomialImpl polynomial;
  private PolynomialImpl polynomialToAdd1;
  private PolynomialImpl polynomialToAdd2;

  @Before
  public void setUp() {
    polynomial = new PolynomialImpl();

    polynomialToAdd1 = new PolynomialImpl();
    polynomialToAdd1.addTerm(8, 2);
    polynomialToAdd1.addTerm(7, 3);
    polynomialToAdd1.addTerm(2, 0);

    polynomialToAdd2 = new PolynomialImpl();
    polynomialToAdd2.addTerm(-2, 1);
    polynomialToAdd2.addTerm(5, 3);
    polynomialToAdd2.addTerm(3, 2);
    polynomialToAdd2.addTerm(-7, 7);
  }

  @Test
  public void testZeroDegree() {
    assertEquals(0, polynomial.getDegree());
  }

  @Test
  public void testZeroCoefficient() {
    assertEquals(0, polynomial.getCoefficient(0));
  }

  @Test
  public void testAddTerm1() {
    polynomial.addTerm(2, 1);
    assertEquals("2x^1", polynomial.toString());
  }

  @Test
  public void testEvaluate1() {
    polynomial.addTerm(2, 1);
    assertEquals(2.4691356, polynomial.evaluate(1.2345678), 0.0);
  }

  @Test
  public void testRemoveTerm1() {
    polynomial.addTerm(2, 1);
    assertEquals("0", polynomial.removeTerm(1).toString());
  }

  @Test
  public void testGetDegree1() {
    polynomial.addTerm(2, 1);
    assertEquals(1, polynomial.getDegree());

  }

  @Test
  public void testGetCoefficient1() {
    polynomial.addTerm(2, 1);
    assertEquals(2, polynomial.getCoefficient(1));
  }

  @Test
  public void testAddTerm2() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    assertEquals("-5x^3 +2x^1", polynomial.toString());
  }

  @Test
  public void testEvaluate2() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    assertEquals(0, polynomial.evaluate(0), 0);
  }

  @Test
  public void testRemoveTerm2() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.removeTerm(1);
    assertEquals("-5x^3", polynomial.toString());
  }

  @Test
  public void testGetDegree2a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    assertEquals(3, polynomial.getDegree());
  }

  @Test
  public void testGetDegree2b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.removeTerm(1);
    assertEquals(3, polynomial.getDegree());
  }

  @Test
  public void testGetDegree2c() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.removeTerm(3);
    assertEquals(1, polynomial.getDegree());
  }

  @Test
  public void testGetCoefficient2a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    assertEquals(-5, polynomial.getCoefficient(3));
  }

  @Test
  public void testGetCoefficient2b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    assertEquals(2, polynomial.getCoefficient(1));
  }

  @Test
  public void testAddTerm3a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    assertEquals("-5x^3 -3x^2 +2x^1", polynomial.toString());
  }

  @Test
  public void testAddTerm3b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.addTerm(9, 2);
    assertEquals("-5x^3 +6x^2 +2x^1", polynomial.toString());
  }

  @Test
  public void testRemoveTerm3a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.removeTerm(3);
    assertEquals("-3x^2 +2x^1", polynomial.toString());
  }

  @Test
  public void testRemoveTerm3b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.removeTerm(3);
    polynomial.removeTerm(1);
    assertEquals("-3x^2", polynomial.toString());
  }

  @Test
  public void testRemoveTerm3c() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.removeTerm(3);
    polynomial.removeTerm(2);
    polynomial.removeTerm(1);
    assertEquals("0", polynomial.toString());
  }

  @Test
  public void testRemoveTerm3d() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.removeTerm(4);
    assertEquals("-5x^3 -3x^2 +2x^1", polynomial.toString());
  }

  @Test
  public void testEvaluate3a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    assertEquals(285.975, polynomial.evaluate(-4.1), 0.001);
  }

  @Test
  public void testEvaluate3b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    assertEquals(-690, polynomial.evaluate(5), 0.001);
  }

  @Test
  public void testGetCoefficient3a() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    assertEquals(-3, polynomial.getCoefficient(2));
  }

  @Test
  public void testGetCoefficient3b() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    assertEquals(0, polynomial.getCoefficient(5));
  }

  @Test
  public void testGetCoefficient3c() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.addTerm(9, 2);
    assertEquals(6, polynomial.getCoefficient(2));
  }

  @Test
  public void testAddTerm4() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.addTerm(7, 7);
    assertEquals("7x^7 -5x^3 -3x^2 +2x^1", polynomial.toString());
  }

  @Test
  public void testAddPolynomials1() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.addTerm(7, 7);
    assertEquals("7x^7 +2x^3 +5x^2 +2x^1 +2",
        polynomial.add(polynomialToAdd1).toString());
  }

  @Test
  public void testAddPolynomials2() {
    assertEquals("7x^3 +8x^2 +2",
        polynomial.add(polynomialToAdd1).toString());
  }

  @Test
  public void testAddPolynomials3() {
    polynomial.addTerm(2, 1);
    polynomial.addTerm(-5, 3);
    polynomial.addTerm(-3, 2);
    polynomial.addTerm(7, 7);
    assertEquals("0", polynomial.add(polynomialToAdd2).toString());
  }

  @Test
  public void testPolyFromStr1() {
    PolynomialImpl polynomialFromStr = new PolynomialImpl("5x^1");
    assertEquals("5x^1", polynomialFromStr.toString());
    assertEquals(1, polynomialFromStr.getDegree());
    assertEquals(5, polynomialFromStr.getCoefficient(1));
  }

  @Test
  public void testPolyFromStr2() {
    PolynomialImpl polynomialFromStr = new PolynomialImpl("-3x^3 +5x^1");
    assertEquals("-3x^3 +5x^1", polynomialFromStr.toString());
    polynomialFromStr.addTerm(15, 4);
    assertEquals("15x^4 -3x^3 +5x^1", polynomialFromStr.toString());
  }

  @Test
  public void testPolyFromStr3() {
    PolynomialImpl polynomialFromStr = new PolynomialImpl("15x^4 -3x^3 +5x^1");
    assertEquals("15x^4 -3x^3 +5x^1", polynomialFromStr.toString());
    assertEquals(4, polynomialFromStr.getDegree());
    assertEquals(5, polynomialFromStr.getCoefficient(1));
  }

  @Test
  public void testPolyFromStr4() {
    PolynomialImpl polynomialFromStr = new PolynomialImpl("-24x^12 +15x^4 -3x^3 +5x^1");
    assertEquals("-24x^12 +15x^4 -3x^3 +5x^1", polynomialFromStr.toString());
    assertEquals(-7, polynomialFromStr.evaluate(1), 0);
  }

  @Test
  public void testPolyFromStr5() {
    PolynomialImpl polynomialFromStr = new PolynomialImpl("-24x^12 +0x^8 +15x^4 -3x^3 +5x^1");
    assertEquals("-24x^12 +15x^4 -3x^3 +5x^1", polynomialFromStr.toString());
    polynomialFromStr.removeTerm(3);
    assertEquals("-24x^12 +15x^4 +5x^1", polynomialFromStr.toString());
  }

}