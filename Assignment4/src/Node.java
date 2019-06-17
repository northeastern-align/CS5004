/**
 * This class represents a Node that has an integer coefficient and degree, as well as two linked
 * Nodes, a next and previous.
 */

public class Node {

  private int coefficient;
  private int degree;
  private Node next;
  private Node previous;

  /**
   * Construct a Node object that is passed a coefficient and degree. When constructed, a Node
   * points to null for it's next and previous Nodes.
   *
   * @param coefficient the coefficient (leading term) of the node
   * @param degree the power of the node
   */
  public Node(int coefficient, int degree) throws IllegalArgumentException {
    this.coefficient = coefficient;
    if (degree < 0) {
      throw new IllegalArgumentException("Node needs a non-negative degree!");
    }
    this.degree = degree;
    this.next = null;
    this.previous = null;
  }

  /**
   * A getter that returns the next Node.
   *
   * @return the next Node
   */
  Node getNext() {
    return this.next;
  }

  /**
   * A setter that is passed a Node to set as the next linked Node.
   *
   * @param next the Node to be set as next
   */
  void setNext(Node next) {
    this.next = next;
  }

  /**
   * A getter that returns the previous Node.
   *
   * @return the previous Node
   */
  Node getPrevious() {
    return this.previous;
  }

  /**
   * A setter that is passed a Node to set as the previous linked Node.
   *
   * @param previous the Node to be set as previous
   */
  void setPrevious(Node previous) {
    this.previous = previous;
  }

  /**
   * A getter that returns the degree/power of the Node.
   *
   * @return the degree of the Node
   */
  int getDegree() {
    return this.degree;
  }

  /**
   * A getter that returns the coefficient of the Node.
   *
   * @return the coefficient of the Node
   */
  int getCoefficient() {
    return this.coefficient;
  }

  /**
   * Updates the coefficient of a term when passed a term of the same power.
   *
   * @param coefficient the coefficient to be added to the term
   */
  void setCoefficient(int coefficient) {
    this.coefficient += coefficient;
  }

}
