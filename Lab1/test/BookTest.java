import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test class for the Book class.
 */
public class BookTest {

  private Book book;
  private Person john;

  @Before
  public void setUp() {

    book = new Book("Martian", john, 15.00f);

  }

  @Test
  public void testTitle() {
    assertEquals("Martian", book.getTitle());

  }

  @Test
  public void testPrice() {
    assertEquals(15.00f, book.getPrice(), 0.0001);
  }

  @Test
  public void testAuthor() {
    assertEquals(john, book.getAuthor());
  }

}