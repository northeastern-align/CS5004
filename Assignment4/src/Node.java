public class Node {
  private int coefficient;
  private int degree;
  private Node next;
  private Node previous;

  public Node (int coefficient, int degree) {
    this.coefficient = coefficient;
    this.degree = degree;
    this.next = null;
    this.previous = null;
  }

  void setNext (Node next) {
    this.next = next;
  }

  void setPrevious (Node previous) {
    this.previous = previous;
  }

  Node getNext() {
    return this.next;
  }

  Node getPrevious() {
    return this.previous;
  }

  int getDegree() { return this.degree; }

  int getCoefficient() { return this.coefficient; }

  void setCoefficient(int coefficient) {
    this.coefficient += coefficient;
  }

}
