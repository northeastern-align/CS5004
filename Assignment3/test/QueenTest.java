import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit test class for Queen.
 */
public class QueenTest {

  private AbstractPiece queenW;
  private AbstractPiece queenB;

  @Before
  public void setUp() {
    queenW = new Queen(4, 4, Color.WHITE);
    queenB = new Queen(6, 6, Color.BLACK);
  }

// For tests of abstract methods see PawnTest

}