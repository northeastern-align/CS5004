public class PolynomialImpl implements IPolynomial {
  private Node start;
  private Node end;

  public PolynomialImpl() {
    this.start = new Node(0,0);
    this.end = start;
  }

  public String toString() {
    Node temp = end;
    String output = "";
    while ( temp.getDegree() >= 0 && temp.getPrevious() != null ) {
      output += temp.getCoefficient() + "x^" + temp.getDegree();
      temp = temp.getPrevious();
      if ( temp.getCoefficient() < 0 ) {
        output += " ";
      }
      if ( temp.getCoefficient() > 0 ) {
        output += " +";
      }
    }
    return output;
  }

  @Override
  public IPolynomial addTerm(int coefficient, int power) throws IllegalArgumentException {
    Node temp = this.start;
    Node newNode = new Node(coefficient, power);

    if ( power < 0 ) {
      throw new IllegalArgumentException("Power must be a non-negative number!");
    }

    if ( coefficient == 0 ) {
      return this;
    }

    if ( power > this.end.getDegree()) {
      this.end.setNext(newNode);
      newNode.setPrevious(this.end);
      this.end = newNode;
      return this;
    }

    while ( power > temp.getDegree() && temp.getNext() != null ) {
      temp = temp.getNext();
    }

    if ( power == temp.getDegree() ) {
      temp.setCoefficient(coefficient);
      return this;
    }

    Node temp2 = temp.getPrevious();
    temp2.setNext(newNode);
    temp.setPrevious(newNode);
    newNode.setPrevious(temp2);
    newNode.setNext(temp);

    return this;
  }

  @Override
  public IPolynomial removeTerm(int power) {
    Node temp = this.start;
    while (power >= temp.getDegree()) {
      if ( power == temp.getDegree() ) {
        if ( temp.getNext() == null ) {
          end = temp.getPrevious();
          end.setNext(null);
          return this;
        }
        Node temp2 = temp.getPrevious();
        temp = temp.getNext();
        temp2.setNext(temp);
        temp.setPrevious(temp2);
        return this;
      }
      else if ( temp.getNext() == null ) {
        return this;
      }
      temp = temp.getNext();
    }
    return this;
  }

  @Override
  public int getDegree() {
    return end.getDegree();
  }

  @Override
  public int getCoefficient(int power) {
    Node temp = start;
    while ( power != temp.getDegree() && temp.getNext() != null) {
      temp = temp.getNext();
    }
    if ( power == temp.getDegree() ) {
      return temp.getCoefficient();
    }
    return 0;
  }

  @Override
  public double evaluate(double number) {
    return 0;
  }

  @Override
  public IPolynomial add(PolynomialImpl polynomial) {
    IPolynomial total = new PolynomialImpl();
    Node temp1 = this.start;
    Node temp2 = polynomial.start;

    while ( temp1.getNext() != null && temp2.getNext() != null) {
      total.addTerm(temp1.getCoefficient(), temp1.getDegree());
      total.addTerm(temp2.getCoefficient(), temp2.getDegree());
      temp1 = temp1.getNext();
      temp2 = temp2.getNext();
    }
    total.addTerm(temp1.getCoefficient(), temp1.getDegree());
    total.addTerm(temp2.getCoefficient(), temp2.getDegree());
    return total;
  }

}
