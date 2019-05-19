import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;
  private Email email;

  @Before
  public void setUp() {
    email = new Email("test", "google.com");
    john = new Person("John", "Doe", 1945, 5555555, email);
  }

  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());

  }

  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  @Test
  public void testYearOfBirth() {
    assertEquals(1945, john.getYearOfBirth());
  }

  @Test
  public void testPhoneNumber() {
    assertEquals(5555555, john.getPhoneNumber());
  }

  @Test
  public void testEmail() {
    assertEquals(email, john.getEmail());
  }

}