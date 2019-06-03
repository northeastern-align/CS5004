import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Essay.
 */

public class EssayTest {

  private Essay essayRequired;
  private Essay essayOptional;

  @Before
  public void setUp() {
    essayRequired = new Essay("You learned a lot in the course?", true);
    essayOptional = new Essay("You enjoyed the course?", false);
  }

  @Test
  public void testGetQuestionText() {
    assertEquals("You learned a lot in the course?", essayRequired.getQuestionText());
  }

  @Test
  public void testNoQuestionText() {
    Essay temp = new Essay("", true);
    assertEquals("", temp.getQuestionText());
  }

  @Test
  public void testRequired() {
    assertTrue(essayRequired.getQuestionRequired());
  }

  @Test
  public void testOptional() {
    assertFalse(essayOptional.getQuestionRequired());
  }

  @Test
  public void testShort() {
    essayRequired.answer("1");
  }

  @Test
  public void testLong() {
    essayRequired.answer("This is exactly 140 characters. I have tested it using lettercount.com."
        + " One more letter would return an illegal argument exception. Hooray!!");
  }

  @Test
  public void testLongLowerCase() {
    essayRequired.answer("this is exactly 140 characters. i have tested it using lettercount.com."
        + " one more letter would return an illegal argument exception. hooray!!");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoAnswer() {
    essayRequired.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTooLong() {
    essayRequired.answer("This is exactly 141 characters. I have tested it using lettercount.com."
        + " One more letter would return an illegal argument exception. Hooray!!!");
  }

}