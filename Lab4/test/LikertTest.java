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
    assertEquals("Strongly Agree", likertRequired.getAnswer());
  }

  @Test
  public void testAgree() {
    likertRequired.answer("Agree");
    assertEquals("Agree", likertRequired.getAnswer());
  }

  @Test
  public void testNeither() {
    likertRequired.answer("Neither Agree nor Disagree");
    assertEquals("Neither Agree nor Disagree", likertRequired.getAnswer());
  }

  @Test
  public void testDisagree() {
    likertRequired.answer("Disagree");
    assertEquals("Disagree", likertRequired.getAnswer());
  }

  @Test
  public void testStronglyDisagree() {
    likertRequired.answer("Strongly Disagree");
    assertEquals("Strongly Disagree", likertRequired.getAnswer());
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