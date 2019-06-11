public interface IPolynomial {
  IPolynomial addTerm(int coefficient, int power);
  IPolynomial removeTerm(int power);
  int getDegree();
  int getCoefficient(int power);
  double evaluate (double number);
  IPolynomial add (PolynomialImpl polynomial);
}
