import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Pawn.
 */
public class PawnTest {

  private AbstractPiece pawnW;
  private AbstractPiece pawnB;

  @Before
  public void setUp() {
    pawnW = new Pawn(1, 1, Color.WHITE);
    pawnB = new Pawn(2, 2, Color.BLACK);
  }

  // Abstract class tests - performed only once for all extensions of AbstractPiece
  @Test
  public void testGetRow() {
    assertEquals(1, pawnW.getRow());
  }

  @Test
  public void testGetColumn() {
    assertEquals(1, pawnW.getColumn());
  }

  @Test
  public void testGetColorWhite() {
    assertEquals(Color.WHITE, pawnW.getColor());
  }

  @Test
  public void testGetColorBlack() {
    assertEquals(Color.BLACK, pawnB.getColor());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRow() {
    Pawn temp = new Pawn(-1, 1, Color.WHITE);
    assertEquals(-1, temp.getRow());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumn() {
    Pawn temp = new Pawn(1, -1, Color.BLACK);
    assertEquals(-1, temp.getColumn());
  }

  @Test
  public void testWhiteMoveUp1() {
    assertTrue(pawnW.canMove(2, 1));
  }

  @Test
  public void testWhiteMoveUp2() {
    assertFalse(pawnW.canMove(3, 1));
  }

  @Test
  public void testWhiteMoveDiagonal() {
    assertFalse(pawnW.canMove(2, 2));
  }

  @Test
  public void testWhiteMoveSideways1() {
    assertFalse(pawnW.canMove(1, 2));
  }

  @Test
  public void testWhiteMoveBack1() {
    assertFalse(pawnW.canMove(1, 0));
  }

  @Test
  public void testWhiteBoundary() {
    Pawn temp = new Pawn(7, 1, Color.WHITE);
    assertFalse(temp.canMove(8, 1));
  }

  @Test
  public void testBlackMoveDown1() {
    assertTrue(pawnB.canMove(1, 2));
  }

  @Test
  public void testBlackMoveDown2() {
    assertFalse(pawnB.canMove(0, 2));
  }

  @Test
  public void testBlackMoveSideways1() {
    assertFalse(pawnB.canMove(2, 1));
  }

  @Test
  public void testBlackMoveDiagonal() {
    assertFalse(pawnB.canMove(3, 3));
  }

  @Test
  public void testBlackMoveBack1() {
    assertFalse(pawnB.canMove(3, 2));
  }

  @Test
  public void testBlackBoundary() {
    Pawn temp = new Pawn(0, 2, Color.BLACK);
    assertFalse(temp.canMove(-1, 2));
  }

  @Test
  public void testMoveSame() {
    assertTrue(pawnB.canMove(2, 2));
  }

  @Test
  public void testWhiteKill() {
    assertTrue(pawnW.canKill(pawnB));
  }

  @Test
  public void testBlackKill() {
    assertTrue(pawnB.canKill(pawnW));
  }

  @Test
  public void testIllegalKillDirection() {
    Pawn temp = new Pawn(2, 1, Color.BLACK);
    assertFalse(pawnW.canKill(temp));
  }

  @Test
  public void testIllegalKillDistance() {
    Pawn temp = new Pawn(3, 3, Color.BLACK);
    assertFalse(pawnW.canKill(temp));
  }

  @Test
  public void testIllegalKillColor() {
    Pawn temp = new Pawn(2, 2, Color.WHITE);
    assertFalse(pawnW.canKill(temp));
  }

  @Test
  public void testKillSameSpace() {
    Pawn temp = new Pawn(1, 1, Color.BLACK);
    assertTrue(pawnW.canKill(temp));
  }

  @Test
  public void testKillOtherPiece() {
    Queen temp = new Queen(2, 2, Color.BLACK);
    assertTrue(pawnW.canKill(temp));
  }

  @Test
  public void testIllegalKillOtherPiece() {
    Knight temp = new Knight(2, 2, Color.WHITE);
    assertFalse(pawnW.canKill(temp));
  }

}


