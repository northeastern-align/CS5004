import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Email class.
 */
public class EmailTest {

  private Email email;

  @Before
  public void setUp() {

    email = new Email("test", "google.com");

  }

  @Test
  public void testUsername() {
    assertEquals("test", email.getUsername());
  }

  @Test
  public void testAddress() {
    assertEquals("google.com", email.getAddress());
  }

}