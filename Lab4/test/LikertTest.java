import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Likert.
 */

public class LikertTest {

  private Likert likertRequired;
  private Likert likertOptional;

  @Before
  public void setUp() {
    likertRequired = new Likert("You learned a lot in the course?", true);
    likertOptional = new Likert("You enjoyed the course?", false);
  }

  @Test
  public void testGetQuestionText() {
    assertEquals("You learned a lot in the course?", likertRequired.getQuestionText());
  }

  @Test
  public void testNoQuestionText() {
    Likert temp = new Likert("", true);
    assertEquals("", temp.getQuestionText());
  }

  @Test
  public void testRequired() {
    assertTrue(likertRequired.getQuestionRequired());
  }

  @Test
  public void testOptional() {
    assertFalse(likertOptional.getQuestionRequired());
  }

  @Test
  public void testStronglyAgree() {
    likertRequired.answer("Strongly Agree");
  }

  @Test
  public void testAgree() {
    likertRequired.answer("Agree");
  }

  @Test
  public void testNeither() {
    likertRequired.answer("Neither Agree nor Disagree");
  }

  @Test
  public void testDisagree() {
    likertRequired.answer("Disagree");
  }

  @Test
  public void testStronglyDisagree() {
    likertRequired.answer("Strongly Disagree");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoAnswer() {
    likertRequired.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLowerCase() {
    likertRequired.answer("agree");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUpperCase() {
    likertRequired.answer("AGREE");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOtherString() {
    likertRequired.answer("True");
  }

}