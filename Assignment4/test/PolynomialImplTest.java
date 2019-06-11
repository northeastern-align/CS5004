import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PolynomialImplTest {
  private PolynomialImpl polynomial;
  private PolynomialImpl polynomialToAdd;

  @Before
  public void setUp() {
    polynomial = new PolynomialImpl();
  }

  @Test
  public void testAddTerm() {
    assertEquals(0, polynomial.getDegree());
    assertEquals(0, polynomial.getCoefficient(3));

    polynomial.addTerm(2, 1);
    assertEquals("2x^1", polynomial.toString());
    assertEquals(1, polynomial.getDegree());
    assertEquals(2, polynomial.getCoefficient(1));

    polynomial.addTerm(-5, 3);
    assertEquals("-5x^3 +2x^1", polynomial.toString());
    assertEquals(3, polynomial.getDegree());
    assertEquals(-5, polynomial.getCoefficient(3));

    polynomial.addTerm(-3, 2);
    assertEquals("-5x^3 -3x^2 +2x^1", polynomial.toString());
    assertEquals(3, polynomial.getDegree());
    assertEquals(0, polynomial.getCoefficient(0));

    polynomial.addTerm(7, 7);
    assertEquals("7x^7 -5x^3 -3x^2 +2x^1", polynomial.toString());
    assertEquals(7, polynomial.getDegree());
    assertEquals(7, polynomial.getCoefficient(7));

    polynomial.removeTerm(3);
    assertEquals("7x^7 -3x^2 +2x^1", polynomial.toString());
    assertEquals(7, polynomial.getDegree());
    assertEquals(0, polynomial.getCoefficient(3));

    polynomial.removeTerm(7);
    assertEquals("-3x^2 +2x^1", polynomial.toString());
    assertEquals(2, polynomial.getDegree());
    assertEquals(2, polynomial.getCoefficient(1));

    polynomial.removeTerm(1);
    assertEquals("-3x^2", polynomial.toString());
    assertEquals(2, polynomial.getDegree());
    assertEquals(0, polynomial.getCoefficient(7));

    polynomial.addTerm(5,2);
    assertEquals("2x^2", polynomial.toString());
    assertEquals(2, polynomial.getDegree());
    assertEquals(2, polynomial.getCoefficient(2));

    polynomialToAdd = new PolynomialImpl();
    polynomialToAdd.addTerm(8, 2);
    polynomialToAdd.addTerm(5, 5);
    polynomialToAdd.addTerm(2, 0);
    assertEquals("5x^5 +8x^2 +2x^0", polynomialToAdd.toString());
    assertEquals("5x^5 +10x^2 +2x^0", polynomial.add(polynomialToAdd));
  }

}