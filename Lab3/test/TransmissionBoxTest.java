import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for TransmissionBox.
 */

public class TransmissionBoxTest {

  private TransmissionBox transmission;

  @Before
  public void setUp() {

    transmission = new TransmissionBox(34, 10, 20, 35,
        50);
  }

  @Test
  public void testGetSpeed() {
    assertEquals(34, transmission.getSpeed());
  }

  @Test
  public void testGetGear() {
    assertEquals(3, transmission.getGear());
  }

  @Test
  public void testSpeedUp() {
    TransmissionBox expected = new TransmissionBox(36, 10, 20,
        35, 50);
    assertEquals(expected, transmission.speedUp());
  }

  @Test
  public void testGetCurrentGear() {
    TransmissionBox newTransmission = transmission.speedUp();
    assertEquals(4, newTransmission.getCurrentGear());
  }

  @Test
  public void testSlowDown() {
    TransmissionBox expected = new TransmissionBox(32, 10, 20,
        35, 50);
    assertEquals(expected, transmission.slowDown());
  }

  @Test
  public void testToString() {
    assertEquals("Current speed is 34 and current gear is 3.", transmission.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalLowSpeed() {
    transmission = new TransmissionBox(-20, 10, 20, 35,
        60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalHighSpeed() {
    transmission = new TransmissionBox(150, 10, 20, 35,
        60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGearSpeeds() {
    transmission = new TransmissionBox(20, 20, 20, 35,
        60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGearThresholds() {
    transmission = new TransmissionBox(50, 10, 20, 35,
        42);
  }

}