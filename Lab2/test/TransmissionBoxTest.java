import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for TransmissionBox
 */

public class TransmissionBoxTest {

  private TransmissionBox transmission;

  @Before
  public void setUp() {

    transmission = new TransmissionBox(29, 10, 20, 30,
        40);
  }

  @Test
  public void testGetSpeed() {
    assertEquals(29, transmission.getSpeed());
  }

  @Test
  public void testGetGear() {
    assertEquals(3, transmission.getGear());
  }

  @Test
  public void testSpeedUp() {
    TransmissionBox expected = new TransmissionBox(31, 10, 20,
        30, 40);
    assertEquals(expected, transmission.speedUp());
  }

  @Test
  public void testGetCurrentGear() {
    TransmissionBox newTransmission = transmission.speedUp();
    assertEquals(4, newTransmission.getCurrentGear());
  }

  @Test
  public void testSlowDown() {
    TransmissionBox expected = new TransmissionBox(27, 10, 20,
        30, 40);
    assertEquals(expected, transmission.slowDown());
  }

  @Test
  public void testToString() {
    assertEquals("Current speed is 29 and current gear is 3.", transmission.toString());
  }


}