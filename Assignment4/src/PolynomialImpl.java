/**
 * This class represents a Polynomial Implementation that extends the IPolynomial interface. A
 * Polynomial has a Node type start and end
 */

public class PolynomialImpl implements Polynomial {

  private Node start;
  private Node end;

  /**
   * Construct a PolynomialImpl object that is set by default to contain one Node with a coefficient
   * and degree of 0.
   */
  public PolynomialImpl() {
    this.start = new Node(0, 0);
    this.end = start;
  }

  /**
   * Construct a PolynomialImpl object that is passed a string and converted to a matching
   * Polynomial.
   *
   * @param s a string representing a polynomial
   */
  public PolynomialImpl(String s) throws IllegalArgumentException {

    int i;
    Node currentNode = new Node(0, 0);

    if (!(s.equals(""))) {
      // Split the string across the spaces
      String[] polyArr = s.split(" ");

      // Iterate through array
      for (i = 0; i < polyArr.length; i++) {

        // Split array by x^
        String[] termArr = polyArr[i].split("x\\^");
        String coefficient = termArr[0];
        String power;

        // Handle cases when power is 0 (i.e. 5x^1 +2)
        if (termArr.length < 2) {
          power = "0";
        } else if (termArr.length > 2) {
          throw new IllegalArgumentException("Polynomial format is incorrect!");
        } else {
          power = termArr[1];
        }

        int numPower;
        int numCoefficient;

        try {
          numCoefficient = Integer.parseInt(coefficient);
          numPower = Integer.parseInt(power);
        } catch (Exception e) {
          throw new IllegalArgumentException("Polynomial format is incorrect!");
        }

        if (numPower < 0) {
          throw new IllegalArgumentException("Power can't be negative!");
        }

        if (numCoefficient == 0) {
          continue;
        }

        if (i == 0) {
          this.start = new Node(numCoefficient, numPower);
          currentNode = this.start;
          this.end = start;
        } else if (i == polyArr.length - 1) {
          Node newNode = new Node(numCoefficient, numPower);
          this.end = newNode;
          currentNode.setNext(this.end);
          this.end.setPrevious(currentNode);

        } else {
          Node newNode = new Node(numCoefficient, numPower);
          newNode.setPrevious(currentNode);
          currentNode.setNext(newNode);
          currentNode = newNode;
          this.end = currentNode;
        }
      }
    } else {
      this.start = new Node(0, 0);
      this.end = start;
    }

  }

  /**
   * Converts a Polynomial list to a concatenated string and returns the resulting string.
   *
   * @return the string conversion of a Polynomial
   */
  @Override
  public String toString() {

    Node temp = this.start;
    String output = "";

    while (temp.getDegree() >= 0) {

      if (temp.getCoefficient() != 0) {
        if (temp.getDegree() == 0) {
          output += temp.getCoefficient();
        } else {
          output += temp.getCoefficient() + "x^" + temp.getDegree();
        }
      }
      if (temp.getNext() != null) {
        temp = temp.getNext();
        if (temp.getCoefficient() < 0) {
          output += " ";
        } else if (temp.getCoefficient() > 0) {
          output += " +";
        }
      } else {
        if (output.equals("")) {
          output += "0";
        }
        break;
      }


    }
    return output;
  }

  /**
   * Adds a new term to a Polynomial object and returns the updated Polynomial.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power the power of the term to be added
   * @return the Polynomial object with the term added
   * @throws IllegalArgumentException if the power of the term to be added is negative
   */
  @Override
  public Polynomial addTerm(int coefficient, int power) throws IllegalArgumentException {
    Node temp = this.end;
    Node newNode = new Node(coefficient, power);

    if (power < 0) {
      throw new IllegalArgumentException("Power must be a non-negative number!");
    }

    // A coefficient of zero is essentially an empty term that has a value of zero.
    if (coefficient == 0) {
      return this;
    }

    if (power > this.start.getDegree()) {
      this.start.setPrevious(newNode);
      newNode.setNext(this.start);
      this.start = newNode;
      return this;
    }

    while (power > temp.getDegree() && temp.getPrevious() != null) {
      temp = temp.getPrevious();
    }

    // If the power already exists in the Polynomial, updates the coefficient.
    if (power == temp.getDegree()) {
      temp.setCoefficient(coefficient);
      return this;
    }

    // Temp (left) and Temp2 (right) bookend where node will get added
    Node temp2 = temp.getNext();
    temp2.setPrevious(newNode);
    temp.setNext(newNode);
    newNode.setNext(temp2);
    newNode.setPrevious(temp);

    return this;
  }

  /**
   * Removes a term in a polynomial by a specific power and returns the updated Polynomial.
   *
   * @param power the power of the term to be removed
   * @return the updated Polynomial with the corresponding term removed
   */
  @Override
  public Polynomial removeTerm(int power) {
    Node temp = this.end;
    while (power >= temp.getDegree()) {
      if (power == temp.getDegree()) {
        if (temp.getPrevious() == null) {
          this.start = temp.getNext();
          this.start.setPrevious(null);
          return this;
        }
        if (temp.getNext() == null) {
          temp.getPrevious().setNext(null);
          this.end = temp.getPrevious();
          return this;
        }
        Node temp2 = temp.getNext();
        temp = temp.getPrevious();
        temp2.setPrevious(temp);
        temp.setNext(temp2);
        return this;
      } else if (temp.getPrevious() == null) {
        return this;
      }
      temp = temp.getPrevious();
    }
    return this;
  }

  /**
   * Returns the highest power of the Polynomial.
   *
   * @return the highest power of the Polynomial
   */
  @Override
  public int getDegree() {
    return this.start.getDegree();
  }

  /**
   * Returns the coefficient of a specified term in the Polynomial.
   *
   * @param power the power of the term to find the coefficient of
   * @return the coefficient of the specified term
   */
  @Override
  public int getCoefficient(int power) {
    Node temp = this.end;
    while (power != temp.getDegree() && temp.getPrevious() != null) {
      temp = temp.getPrevious();
    }
    if (power == temp.getDegree()) {
      return temp.getCoefficient();
    }
    return 0;
  }

  /**
   * Returns the start of the Polynomial linked list.
   *
   * @return the start of the Polynomial linked list
   */
  @Override
  public Node getStart() {
    return this.start;
  }

  /**
   * When provided an x value, evaluates the total summation of the Polynomial and returns the
   * result.
   *
   * @param x a double value of x in the Polynomial
   * @return the total summation of the terms in the Polynomial
   */
  @Override
  public double evaluate(double x) {
    double total = 0;
    Node temp = this.end;

    while (temp != null) {
      total += temp.getCoefficient() * Math.pow(x, temp.getDegree());
      temp = temp.getPrevious();
    }

    return total;
  }

  /**
   * Combines the terms of two polynomials and returns the result as a new Polynomial object.
   *
   * @param polynomial the polynomial to be added
   * @return a new Polynomial object that is the combination of two polynomials
   */
  @Override
  public Polynomial add(Polynomial polynomial) throws IllegalArgumentException {
    if (!(polynomial instanceof Polynomial)) {
      throw new IllegalArgumentException("Argument must be Polynomial object!");
    }

    Node clone = polynomial.getStart();
    PolynomialImpl total = new PolynomialImpl();

    while (clone != null) {
      total.addTerm(clone.getCoefficient(), clone.getDegree());
      clone = clone.getNext();
    }

    Node temp = this.end;

    while (temp.getPrevious() != null) {
      total.addTerm(temp.getCoefficient(), temp.getDegree());
      temp = temp.getPrevious();
    }
    total.addTerm(temp.getCoefficient(), temp.getDegree());
    return total;
  }


}
