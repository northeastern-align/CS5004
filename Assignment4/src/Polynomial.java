/**
 * This is an interface for polynomials.
 */

public interface Polynomial {

  /**
   * Returns the Polynomial with a specified added term.
   *
   * @param coefficient the coefficient of the term to add
   * @param power the power of the term to add
   * @return the updated Polynomial with an added term
   */
  Polynomial addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Returns the Polynomial with a specified term removed.
   *
   * @param power the power of the term to be removed
   * @return the updated Polynomial with the term removed
   */
  Polynomial removeTerm(int power);

  /**
   * A getter that returns the highest power of the Polynomial.
   *
   * @return the highest power of the Polynomial
   */
  int getDegree();

  /**
   * A getter that returns the coefficient of a specified term of the Polynomial.
   *
   * @param power the power of the term to find the coefficient of
   * @return the coefficient of the specified term
   */
  int getCoefficient(int power);

  /**
   * Calculates the value of the polynomial when plugging in a double x.
   *
   * @param x the value to plug into the polynomial
   * @return the total summation of the polynomial
   */
  double evaluate(double x);

  /**
   * Combines two polynomials into a new Polynomial.
   *
   * @param polynomial the polynomial to add
   * @return a new Polynomial object that is the combination of two polynomials
   */
  Polynomial add(Polynomial polynomial);

  /**
   * Returns the first node in a Polynomial linked list.
   *
   * @return the first node in the Polynomial
   */
  Node getStart();
}
