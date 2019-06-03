import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for YesNo.
 */

public class YesNoTest {

  private YesNo yesNoRequired;
  private YesNo yesNoOptional;

  @Before
  public void setUp() {
    yesNoRequired = new YesNo("You learned a lot in the course?", true);
    yesNoOptional = new YesNo("You enjoyed the course?", false);
  }

  @Test
  public void testGetQuestionText() {
    assertEquals("You learned a lot in the course?", yesNoRequired.getQuestionText());
  }

  @Test
  public void testNoQuestionText() {
    YesNo temp = new YesNo("", true);
    assertEquals("", temp.getQuestionText());
  }

  @Test
  public void testRequired() {
    assertTrue(yesNoRequired.getQuestionRequired());
  }

  @Test
  public void testOptional() {
    assertFalse(yesNoOptional.getQuestionRequired());
  }

  @Test
  public void testYes() {
    yesNoRequired.answer("Yes");
  }

  @Test
  public void testNo() {
    yesNoRequired.answer("No");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNoAnswer() {
    yesNoRequired.answer("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLowerCase() {
    yesNoRequired.answer("yes");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testUpperCase() {
    yesNoRequired.answer("YES");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOtherString() {
    yesNoRequired.answer("True");
  }

}