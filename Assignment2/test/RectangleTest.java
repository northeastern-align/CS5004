import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Rectangle.
 */

public class RectangleTest {

  private Rectangle rectangle;

  @Before
  public void setUp() {
    rectangle = new Rectangle(0, 0, 10, 10);
  }

  @Test
  public void testOverlap() {
    Rectangle test = new Rectangle(9, 9, 10, 10);
    assertEquals(true, rectangle.overlap(test));
  }

  @Test
  public void testOverlapSameRectangle() {
    Rectangle test = new Rectangle(0, 0, 10, 10);
    assertEquals(true, rectangle.overlap(test));
  }

  @Test
  public void testOverlapCorner() {
    Rectangle test = new Rectangle(-10, -10, 10, 10);
    assertEquals(false, rectangle.overlap(test));
  }

  @Test
  public void testNoXYOverlap() {
    Rectangle test = new Rectangle(11, 11, 10, 10);
    assertEquals(false, rectangle.overlap(test));
  }

  @Test
  public void testNoXOverlap() {
    Rectangle test = new Rectangle(11, 0, 5, 10);
    assertEquals(false, rectangle.overlap(test));
  }

  @Test
  public void testNoYOverlap() {
    Rectangle test = new Rectangle(0, 11, 3, 3);
    assertEquals(false, rectangle.overlap(test));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testZeroWidth() {
    Rectangle test = new Rectangle(0, 0, 0, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeWidth() {
    Rectangle test = new Rectangle(0, 0, -2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testZeroHeight() {
    Rectangle test = new Rectangle(0, 0, 5, 0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeHeight() {
    Rectangle test = new Rectangle(0, 0, 5, -5);
  }

  @Test
  public void testIntersect() {
    Rectangle test = new Rectangle(9, 9, 10, 10);
    Rectangle intersect = new Rectangle(9, 9, 1, 1);
    assertEquals(intersect, rectangle.intersect(test));
  }

  @Test
  public void testIntersectSameRectangle() {
    Rectangle test = new Rectangle(0, 0, 10, 10);
    Rectangle intersect = new Rectangle(0, 0, 10, 10);
    assertEquals(intersect, rectangle.intersect(test));
  }

  @Test(expected = NoSuchElementException.class)
  public void testIntersectCorner() {
    Rectangle test = new Rectangle(-10, -10, 10, 10);
    rectangle.intersect(test);
  }

  @Test(expected = NoSuchElementException.class)
  public void testNoXYIntersect() {
    Rectangle test = new Rectangle(11, 11, 10, 10);
    rectangle.intersect(test);
  }

  @Test(expected = NoSuchElementException.class)
  public void testNoXIntersect() {
    Rectangle test = new Rectangle(11, 0, 5, 10);
    rectangle.intersect(test);
  }

  @Test(expected = NoSuchElementException.class)
  public void testNoYIntersect() {
    Rectangle test = new Rectangle(0, 11, 3, 3);
    rectangle.intersect(test);
  }

  @Test
  public void testUnion() {
    Rectangle test = new Rectangle(9, 9, 10, 10);
    Rectangle union = new Rectangle(0, 0, 19, 19);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testUnionSameRectangle() {
    Rectangle test = new Rectangle(0, 0, 10, 10);
    Rectangle union = new Rectangle(0, 0, 10, 10);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testUnionCorner() {
    Rectangle test = new Rectangle(-10, -10, 10, 10);
    Rectangle union = new Rectangle(-10, -10, 20, 20);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testNoXYUnion() {
    Rectangle test = new Rectangle(11, 11, 10, 10);
    Rectangle union = new Rectangle(0, 0, 21, 21);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testNoXUnion() {
    Rectangle test = new Rectangle(11, 0, 5, 10);
    Rectangle union = new Rectangle(0, 0, 16, 10);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testNoYUnion() {
    Rectangle test = new Rectangle(0, 11, 3, 3);
    Rectangle union = new Rectangle(0, 0, 10, 14);
    assertEquals(union, rectangle.union(test));
  }

  @Test
  public void testToString() {
    assertEquals("x:0, y:0, w:10, h:10", rectangle.toString());
  }

  @Test
  public void testToStringNegative() {
    Rectangle test = new Rectangle(-10, -10, 10, 10);
    assertEquals("x:-10, y:-10, w:10, h:10", test.toString());
  }

}