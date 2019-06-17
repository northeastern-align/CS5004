import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit Testing for PolynomialImpl class.
 */
public class PolynomialImplTest2 {

  private PolynomialImpl polynomial;
  private PolynomialImpl polyToAdd;

  @Before
  public void setUp() {
    polynomial = new PolynomialImpl();
    polyToAdd = new PolynomialImpl();
  }

  // Testing Blank Polynomial(){
  @Test
  public void emptyPoly() {
    assertEquals("0", polynomial.toString());
  }

  // Testing creating polynomial from string.
  @Test
  public void setPolyFromString1Poly() {
    PolynomialImpl fromString = new PolynomialImpl("-3x^3");
    assertEquals("-3x^3", fromString.toString());
  }

  @Test
  public void setPolyFromString2Polys() {
    PolynomialImpl fromString = new PolynomialImpl("-3x^3 +100x^2");
    assertEquals("-3x^3 +100x^2", fromString.toString());
  }

  @Test
  public void setPolyFromString3Polys() {
    PolynomialImpl fromString = new PolynomialImpl("5000x^3000 -10x^15 +12x^4");
    assertEquals("5000x^3000 -10x^15 +12x^4", fromString.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setPolyFromStringNegativePower() {
    PolynomialImpl fromString = new PolynomialImpl("5x^-2");
  }

  @Test
  public void setPolyFromStringHighPower() {
    PolynomialImpl fromString = new PolynomialImpl("-5x^2000345 +10x^1");
    assertEquals("-5x^2000345 +10x^1", fromString.toString());
  }

  @Test
  public void morePolyFromString(){
    PolynomialImpl fromString = new PolynomialImpl("10x^30 -1x^15");
    assertEquals("10x^30 -1x^15", fromString.toString());

    //10x^30 –1x^15
  }


  // Test AddTerm

  @Test(expected = IllegalArgumentException.class)
  public void negativePower() {
    polynomial.addTerm(12, -10);
  }

  @Test
  public void testZeroOnlyCoefficient() {
    polynomial.addTerm(0, 10);
    assertEquals("0", polynomial.toString());
  }

  @Test
  public void testOutOfOrderWithZero() {
    polynomial.addTerm(-5, 2);
    polynomial.addTerm(3, 3);
    polynomial.addTerm(0, 100);
    assertEquals("3x^3 -5x^2", polynomial.toString());
  }

  @Test
  public void onePositiveCoefficient() {
    polynomial.addTerm(5, 7);
    assertEquals("5x^7", polynomial.toString());
  }

  @Test
  public void oneNegativeCoefficient() {
    polynomial.addTerm(-60, 12);
    assertEquals("-60x^12", polynomial.toString());
  }

  @Test
  public void veryHighCoefficient() {
    polynomial.addTerm(100000, 1);
    assertEquals("100000x^1", polynomial.toString());
  }

  @Test
  public void veryLowCoefficient() {
    polynomial.addTerm(-20000, 5);
    assertEquals("-20000x^5", polynomial.toString());
  }

  @Test
  public void veryHighPower() {
    polynomial.addTerm(20000, 10000);
    assertEquals("20000x^10000", polynomial.toString());
  }

  @Test
  public void testingTwoPositiveOneNegative() {
    polynomial.addTerm(3, 2);
    polynomial.addTerm(-15, 5);
    polynomial.addTerm(10, 3);
    assertEquals("-15x^5 +10x^3 +3x^2", polynomial.toString());
  }

  @Test
  public void addPosCoefficientToExistingPower() {
    polynomial.addTerm(3, 2);
    polynomial.addTerm(-15, 5);
    polynomial.addTerm(10, 3);
    polynomial.addTerm(4, 3);
    assertEquals("-15x^5 +14x^3 +3x^2", polynomial.toString());
  }

  @Test
  public void addNegCoefficientToExistingPower() {
    polynomial.addTerm(3, 2);
    polynomial.addTerm(-15, 5);
    polynomial.addTerm(10, 3);
    polynomial.addTerm(-4, 3);
    assertEquals("-15x^5 +6x^3 +3x^2", polynomial.toString());
  }

  @Test
  public void addNegCoefficientToExistingPowerWithNegCoefficient() {
    polynomial.addTerm(3, 2);
    polynomial.addTerm(-15, 5);
    polynomial.addTerm(10, 3);
    polynomial.addTerm(-6, 5);
    assertEquals("-21x^5 +10x^3 +3x^2", polynomial.toString());
  }

  @Test
  public void addPosCoefficientToExistingPowerWithNegCoefficient() {
    polynomial.addTerm(3, 2);
    polynomial.addTerm(-15, 5);
    polynomial.addTerm(10, 3);
    polynomial.addTerm(18, 5);
    assertEquals("3x^5 +10x^3 +3x^2", polynomial.toString());
  }

  @Test
  public void testToStringThreeTermsNotAddedInOrder() {
    polynomial.addTerm(4, 4);
    polynomial.addTerm(-3, 3);
    polynomial.addTerm(10, 8);
    assertEquals("10x^8 +4x^4 -3x^3", polynomial.toString());
  }

  // Test To String

  @Test
  public void testToStringOneTerm() {
    polynomial.addTerm(4, 4);
    assertEquals("4x^4", polynomial.toString());
  }

  @Test
  public void testToStringTwoTermsOneNeg() {
    polynomial.addTerm(4, 4);
    polynomial.addTerm(-3, 3);
    assertEquals("4x^4 -3x^3", polynomial.toString());
  }

  @Test
  public void polyZeroDegree() {
    polynomial.addTerm(5, 0);
    assertEquals("5", polynomial.toString());
  }

  @Test
  public void toStringZero() {
    polynomial.addTerm(0, 3);
    assertEquals("0", polynomial.toString());
  }

  // Test Remove Term

  @Test
  public void removeTerm() {
    polynomial.addTerm(4, 4);
    polynomial.addTerm(3, 3);
    polynomial.addTerm(-1, 4);
    polynomial.removeTerm(4);
    assertEquals("3x^3", polynomial.toString());
  }

  @Test
  public void removeTermDownToZero() {
    polynomial.addTerm(5, 5);
    polynomial.addTerm(4, 4);
    polynomial.addTerm(3, 3);
    polynomial.removeTerm(4);
    polynomial.removeTerm(5);
    polynomial.removeTerm(3);
    assertEquals("0", polynomial.toString());
  }

  @Test
  public void removeTermThatsBeenRemoved() {
    polynomial.addTerm(4, 10);
    polynomial.addTerm(-3, 3);
    polynomial.removeTerm(10);
    assertEquals("-3x^3", polynomial.toString());
    polynomial.removeTerm(10);
    assertEquals("-3x^3", polynomial.toString());
  }

  @Test
  public void removeTermWithNegativeCoefficent(){
    PolynomialImpl fromString = new PolynomialImpl("3x^100 +5x^3 -1x^1");
    fromString.removeTerm(1);
    assertEquals("3x^100 +5x^3", fromString.toString());
  }

  @Test
  public void removeMiddle(){
    PolynomialImpl fromString = new PolynomialImpl("3x^100 +5x^3 -1x^1");
    fromString.removeTerm(3);
    assertEquals("3x^100 -1x^1", fromString.toString());
  }

  @Test
  public void removeFirst(){
    PolynomialImpl fromString = new PolynomialImpl("3x^100 +5x^3 -1x^1");
    fromString.removeTerm(100);
    assertEquals("5x^3 -1x^1", fromString.toString());
  }

  // Test Evaluate

  @Test
  public void testEvaluate() {
    polynomial.addTerm(3, 3);
    polynomial.addTerm(2, 2);
    assertEquals(159.42, polynomial.evaluate(3.55), 0.01);
  }

  @Test
  public void testEvaluateEmptyPoly() {
    assertEquals(0, polynomial.evaluate(10), 0.01);
  }

  @Test
  public void testEvaluateWithNegCoefficent() {
    polynomial.addTerm(-4, 5);
    assertEquals(-4096, polynomial.evaluate(4), 0.01);
  }

  @Test
  public void testWithNegativeX() {
    polynomial.addTerm(4, 4);
    polynomial.addTerm(4, 3);
    polynomial.addTerm(10, 2);
    assertEquals(10, polynomial.evaluate(-1), 0.01);
  }

  @Test
  public void moreEval(){
    PolynomialImpl poly = new PolynomialImpl("10x^30 -1x^15");
    assertEquals(834657.7536, poly.evaluate(1.459), 0.01);
  }


  // Test GetDegree

  @Test
  public void testGetDegree() {
    polynomial.addTerm(5, 3);
    polynomial.addTerm(6, 5);
    assertEquals(5, polynomial.getDegree());
  }

  @Test
  public void testGetDegreeEmptyPoly() {
    assertEquals(0, polynomial.getDegree());
  }

  @Test
  public void testGetDegreeAfterRemovingNode() {
    polynomial.addTerm(10, 10);
    polynomial.addTerm(9, 9);
    polynomial.removeTerm(10);
    assertEquals(9, polynomial.getDegree());
  }

  // Test Get Coefficent

  @Test
  public void testGetCoefficient() {
    polynomial.addTerm(5, 3);
    polynomial.addTerm(6, 3);
    assertEquals(11, polynomial.getCoefficient(3));
  }

  @Test
  public void testGetCoefficentAfterDeletingNode() {
    polynomial.addTerm(5, 5);
    polynomial.removeTerm(5);
    assertEquals(0, polynomial.getCoefficient(5));
  }

  @Test
  public void testGetCoeffientOfNonExistantDegree() {
    polynomial.addTerm(4, 10);
    assertEquals(0, polynomial.getCoefficient(15));
  }


}