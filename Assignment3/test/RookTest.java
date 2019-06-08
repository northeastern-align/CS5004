import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * JUnit test class for Rook.
 */

public class RookTest {

  private AbstractPiece rookW;
  private AbstractPiece rookB;

  @Before
  public void setUp() {
    rookW = new Rook(5, 1, Color.WHITE);
    rookB = new Rook(5, 6, Color.BLACK);
  }

  // For tests of abstract methods see PawnTest

  @Test
  public void testWhiteMoveUp1() {
    assertTrue(rookW.canMove(6, 1));
  }

  @Test
  public void testWhiteMoveF() {
    assertTrue(rookW.canMove(7, 1));
  }

  @Test
  public void testWhiteMoveFR() {
    assertFalse(rookW.canMove(6, 2));
  }

  @Test
  public void testWhiteMoveR() {
    assertTrue(rookW.canMove(5, 7));
  }

  @Test
  public void testWhiteMoveBR() {
    assertFalse(rookW.canMove(4, 2));
  }

  @Test
  public void testWhiteMoveB() {
    assertTrue(rookW.canMove(3, 1));
  }

  @Test
  public void testWhiteMoveBL() {
    assertFalse(rookW.canMove(4, 0));
  }

  @Test
  public void testWhiteMoveL() {
    assertTrue(rookW.canMove(5, 0));
  }

  @Test
  public void testWhiteBoundary() {
    assertFalse(rookW.canMove(8, 1));
  }

  @Test
  public void testBlackMoveF1() {
    assertTrue(rookB.canMove(4, 6));
  }

  @Test
  public void testBlackMoveF() {
    assertTrue(rookB.canMove(0, 6));
  }

  @Test
  public void testBlackMoveFR() {
    assertFalse(rookB.canMove(4, 5));
  }

  @Test
  public void testBlackMoveR() {
    assertTrue(rookB.canMove(5, 0));
  }

  @Test
  public void testBlackMoveBR() {
    assertFalse(rookB.canMove(6, 5));
  }

  @Test
  public void testBlackMoveB() {
    assertTrue(rookB.canMove(6, 6));
  }

  @Test
  public void testBlackMoveBL() {
    assertFalse(rookB.canMove(6, 7));
  }

  @Test
  public void testBlackMoveL() {
    assertTrue(rookW.canMove(5, 7));
  }

  @Test
  public void testBlackBoundary() {
    assertFalse(rookB.canMove(8, 6));
  }

  @Test
  public void testMoveRandom() {
    assertFalse(rookB.canMove(1,1));
  }

  @Test
  public void testMoveSame() {
    assertTrue(rookB.canMove(5, 6));
  }

  @Test
  public void testWhiteKill() {
    assertTrue(rookW.canKill(rookB));
  }

  @Test
  public void testBlackKill() {
    assertTrue(rookB.canKill(rookW));
  }

  @Test
  public void testIllegalKillDirection() {
    Bishop temp = new Bishop(3, 4, Color.BLACK);
    assertFalse(rookW.canKill(temp));
  }

  @Test
  public void testIllegalKillDistance() {
    Pawn temp = new Pawn(3, 7, Color.BLACK);
    assertFalse(rookW.canKill(temp));
  }

  @Test
  public void testIllegalKillColor() {
    Rook temp = new Rook(5, 3, Color.WHITE);
    assertFalse(rookW.canKill(temp));
  }

  @Test
  public void testKillSameSpace() {
    Queen temp = new Queen(5, 1, Color.BLACK);
    assertTrue(rookW.canKill(temp));
  }


  @Test
  public void testKillOtherPiece() {
    Knight temp = new Knight(5, 7, Color.BLACK);
    assertTrue(rookW.canKill(temp));
  }

  @Test
  public void testIllegalKillOtherPiece() {
    Knight temp = new Knight(3, 3, Color.WHITE);
    assertFalse(rookW.canKill(temp));
  }

}