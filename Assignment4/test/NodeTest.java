import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Node.
 */

public class NodeTest {

  private Node newNode1;
  private Node newNode2;
  private Node newNode3;

  @Before
  public void setUp() {
    newNode1 = new Node(0, 0);
    newNode2 = new Node(3, 3);
    newNode3 = new Node(-6, 20);
  }

  @Test
  public void testSetGetNext() {
    newNode2.setNext(newNode1);
    assertEquals(newNode1, newNode2.getNext());
  }

  @Test
  public void testSetGetNextOpposite() {
    newNode1.setNext(newNode2);
    assertEquals(newNode2, newNode1.getNext());
  }

  @Test
  public void testSetGetPrevious() {
    newNode2.setPrevious(newNode1);
    assertEquals(newNode1, newNode2.getPrevious());
  }

  @Test
  public void testSetGetPreviousOpposite() {
    newNode1.setPrevious(newNode2);
    assertEquals(newNode2, newNode1.getPrevious());
  }

  @Test
  public void testGetNextNull() {
    assertEquals(null, newNode1.getNext());
  }

  @Test
  public void testGetPreviousNull() {
    assertEquals(null, newNode1.getPrevious());
  }

  @Test
  public void testGetSetNextPrevious() {
    newNode2.setPrevious(newNode1);
    newNode2.setNext(newNode3);

    assertEquals(newNode1, newNode2.getPrevious());
    assertEquals(newNode3, newNode2.getNext());
  }

  @Test
  public void testGetDegree() {
    assertEquals(0, newNode1.getDegree());
    assertEquals(3, newNode2.getDegree());
    assertEquals(20, newNode3.getDegree());
  }

  @Test
  public void testGetCoefficient() {
    assertEquals(0, newNode1.getCoefficient());
    assertEquals(3, newNode2.getCoefficient());
    assertEquals(-6, newNode3.getCoefficient());
  }

  @Test
  public void testSetCoefficient() {
    newNode2.setCoefficient(4);
    assertEquals(7, newNode2.getCoefficient());
  }

  @Test
  public void testSetNegCoefficient() {
    newNode2.setCoefficient(-4);
    assertEquals(-1, newNode2.getCoefficient());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegDegree() {
    Node temp = new Node(0, -5);
  }

}