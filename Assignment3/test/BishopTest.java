import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Bishop.
 */
public class BishopTest {

  private AbstractPiece bishopW;
  private AbstractPiece bishopB;

  @Before
  public void setUp() {
    bishopW = new Bishop(2, 2, Color.WHITE);
    bishopB = new Bishop(5, 5, Color.BLACK);
  }

  // For tests of abstract methods see PawnTest

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRow() {
    Bishop temp = new Bishop(-1, 1, Color.WHITE);
    assertEquals(-1, temp.getRow());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIllegalColumn() {
    Bishop temp = new Bishop(1, -1, Color.BLACK);
    assertEquals(-1, temp.getColumn());
  }

  @Test
  public void testWhiteMoveDiagonalFR() {
    assertTrue(bishopW.canMove(3, 3));
  }

  @Test
  public void testWhiteMoveDiagonalFR3() {
    assertTrue(bishopW.canMove(5, 5));
  }

  @Test
  public void testWhiteMoveDiagonalBL() {
    assertTrue(bishopW.canMove(0, 0));
  }

  @Test
  public void testWhiteMoveDiagonalBR() {
    assertTrue(bishopW.canMove(1, 3));
  }

  @Test
  public void testWhiteMoveDiagonalFL() {
    assertTrue(bishopW.canMove(4, 0));
  }

  @Test
  public void testWhiteMoveForward1() {
    assertFalse(bishopW.canMove(3, 2));
  }

  @Test
  public void testWhiteMoveRight() {
    assertFalse(bishopW.canMove(2, 7));
  }

  @Test
  public void testWhiteMoveLeft() {
    assertFalse(bishopW.canMove(2, 0));
  }

  @Test
  public void testWhiteMoveBack() {
    assertFalse(bishopW.canMove(0, 2));
  }

  @Test
  public void testWhiteBoundary() {
    assertFalse(bishopW.canMove(-1, -1));
  }

  @Test
  public void testWhiteMoveRandom() {
    assertFalse(bishopW.canMove(7, 3));
  }

  @Test
  public void testBlackMoveDiagonalFR() {
    assertTrue(bishopB.canMove(3, 3));
  }

  @Test
  public void testBlackMoveDiagonalFR3() {
    assertTrue(bishopB.canMove(5, 5));
  }

  @Test
  public void testBlackMoveDiagonalBL() {
    assertTrue(bishopB.canMove(7, 7));
  }

  @Test
  public void testBlackMoveDiagonalBR() {
    assertTrue(bishopB.canMove(6, 4));
  }

  @Test
  public void testBlackMoveDiagonalFL() {
    assertTrue(bishopB.canMove(4, 6));
  }

  @Test
  public void testBlackMoveForward1() {
    assertFalse(bishopB.canMove(4, 5));
  }

  @Test
  public void testBlackMoveRight() {
    assertFalse(bishopB.canMove(5, 4));
  }

  @Test
  public void testBlackMoveLeft() {
    assertFalse(bishopB.canMove(5, 6));
  }

  @Test
  public void testBlackMoveBack() {
    assertFalse(bishopB.canMove(6, 5));
  }

  @Test
  public void testBlackMoveRandom() {
    assertFalse(bishopB.canMove(2, 6));
  }

  @Test
  public void testBlackBoundary() {
    assertFalse(bishopB.canMove(8, 8));
  }

  @Test
  public void testMoveSame() {
    assertTrue(bishopB.canMove(5, 5));
  }

  @Test
  public void testWhiteKill() {
    assertTrue(bishopW.canKill(bishopB));
  }

  @Test
  public void testBlackKill() {
    assertTrue(bishopB.canKill(bishopW));
  }

  @Test
  public void testIllegalKillDirection() {
    Bishop temp = new Bishop(3, 4, Color.BLACK);
    assertFalse(bishopW.canKill(temp));
  }

  @Test
  public void testIllegalKillDistance() {
    Bishop temp = new Bishop(3, 7, Color.BLACK);
    assertFalse(bishopW.canKill(temp));
  }

  @Test
  public void testIllegalKillColor() {
    Bishop temp = new Bishop(2, 2, Color.WHITE);
    assertFalse(bishopW.canKill(temp));
  }

  @Test
  public void testKillSameSpace() {
    Bishop temp = new Bishop(2, 2, Color.BLACK);
    assertTrue(bishopW.canKill(temp));
  }


  @Test
  public void testKillOtherPiece() {
    Queen temp = new Queen(2, 2, Color.BLACK);
    assertTrue(bishopW.canKill(temp));
  }

  @Test
  public void testIllegalKillOtherPiece() {
    Knight temp = new Knight(2, 2, Color.WHITE);
    assertFalse(bishopW.canKill(temp));
  }


}
