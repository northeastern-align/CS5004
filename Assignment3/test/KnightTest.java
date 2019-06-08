import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test class for Knight.
 */
public class KnightTest {

  private AbstractPiece knightW;
  private AbstractPiece knightB;

  @Before
  public void setUp() {
    knightW = new Knight(2, 2, Color.WHITE);
    knightB = new Knight(3, 4, Color.BLACK);
  }

  // For tests of abstract methods see PawnTest

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRow() {
    Knight temp = new Knight(-1, 1, Color.WHITE);
    assertEquals(-1, temp.getRow());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumn() {
    Knight temp = new Knight(1, -1, Color.BLACK);
    assertEquals(-1, temp.getColumn());
  }

  @Test
  public void testWhiteMoveFR() {
    assertTrue(knightW.canMove(4, 3));
  }

  @Test
  public void testWhiteMoveFL() {
    assertTrue(knightW.canMove(3, 0));
  }

  @Test
  public void testWhiteMoveBR() {
    assertTrue(knightW.canMove(1, 4));
  }

  @Test
  public void testWhiteMoveBL() {
    assertTrue(knightW.canMove(0, 1));
  }

  @Test
  public void testWhiteMoveForward() {
    assertFalse(knightW.canMove(3, 2));
  }

  @Test
  public void testWhiteMoveDiagonal() {
    assertFalse(knightW.canMove(3, 3));
  }

  @Test
  public void testWhiteMoveRight() {
    assertFalse(knightW.canMove(2, 7));
  }

  @Test
  public void testWhiteMoveBack() {
    assertFalse(knightW.canMove(1, 2));
  }

  @Test
  public void testWhiteMoveLeft() {
    assertFalse(knightW.canMove(2, 1));
  }

  @Test
  public void testWhiteBoundary() {
    Knight temp = new Knight(1, 1, Color.WHITE);
    assertFalse(temp.canMove(0, -1));
  }

  @Test
  public void testBlackMoveFR() {
    assertTrue(knightB.canMove(2, 2));
  }

  @Test
  public void testBlackMoveFL() {
    assertTrue(knightB.canMove(1, 5));
  }

  @Test
  public void testBlackMoveBR() {
    assertTrue(knightB.canMove(5, 3));
  }

  @Test
  public void testBlackMoveBL() {
    assertTrue(knightB.canMove(4, 6));
  }

  @Test
  public void testBlackMoveForward() {
    assertFalse(knightB.canMove(2, 4));
  }

  @Test
  public void testBlackMoveDiagonal() {
    assertFalse(knightB.canMove(2, 3));
  }

  @Test
  public void testBlackMoveRight() {
    assertFalse(knightB.canMove(3, 0));
  }

  @Test
  public void testBlackMoveBack() {
    assertFalse(knightB.canMove(7, 4));
  }

  @Test
  public void testBlackMoveLeft() {
    assertFalse(knightB.canMove(3, 7));
  }

  @Test
  public void testBlackBoundary() {
    Knight temp = new Knight(6, 6, Color.BLACK);
    assertFalse(temp.canMove(7, 8));
  }

  @Test
  public void testMoveSame() {
    assertTrue(knightB.canMove(3, 4));
  }

  @Test
  public void testWhiteKill() {
    assertTrue(knightW.canKill(knightB));
  }

  @Test
  public void testBlackKill() {
    assertTrue(knightB.canKill(knightW));
  }

  @Test
  public void testIllegalKillDirection() {
    Knight temp = new Knight(3, 3, Color.BLACK);
    assertFalse(knightW.canKill(temp));
  }

  @Test
  public void testIllegalKillDistance() {
    Knight temp = new Knight(4, 6, Color.BLACK);
    assertFalse(knightW.canKill(temp));
  }

  @Test
  public void testIllegalKillColor() {
    Bishop temp = new Bishop(3, 4, Color.WHITE);
    assertFalse(knightW.canKill(temp));
  }

  @Test
  public void testKillSameSpace() {
    Knight temp = new Knight(2, 2, Color.BLACK);
    assertTrue(knightW.canKill(temp));
  }


  @Test
  public void testKillOtherPiece() {
    Queen temp = new Queen(4, 1, Color.BLACK);
    assertTrue(knightW.canKill(temp));
  }

  @Test
  public void testIllegalKillOtherPiece() {
    Rook temp = new Rook(3, 1, Color.WHITE);
    assertFalse(knightW.canKill(temp));
  }
}
