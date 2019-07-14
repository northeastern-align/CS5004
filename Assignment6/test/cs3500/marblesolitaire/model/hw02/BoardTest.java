package cs3500.marblesolitaire.model.hw02;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test class for the Marble Solitaire board. This test attempts to show functionality for all
 * components of the Board class.
 */

public class BoardTest {

  private Board board;

  @Before
  public void setup() {
    board = new Board(3, 3);
  }

  @Test
  public void testSetPieceO() {
    assertEquals(Piece.X, board.getSpace(3, 3));
    board.setPiece(3, 3, Piece.O);
    assertEquals(Piece.O, board.getSpace(3,3));
  }

  @Test
  public void testSetPieceX() {
    assertEquals(Piece.O, board.getSpace(4, 4));
    board.setPiece(4, 4, Piece.X);
    assertEquals(Piece.X, board.getSpace(4,4));
  }

  @Test
  public void testSetPieceE() {
    assertEquals(Piece.O, board.getSpace(4, 4));
    board.setPiece(4, 4, Piece.E);
    assertEquals(Piece.E, board.getSpace(4,4));
  }

  @Test
  public void testIsEmptyTrue() {
    assertEquals(true, board.isEmpty(3, 3));
    assertEquals(true, board.isEmpty(6, 6));
    assertEquals(true, board.isEmpty(0,0));
  }

  @Test
  public void testIsEmptyFalse() {
    assertEquals(false, board.isEmpty(0, 3));
    assertEquals(false, board.isEmpty(6, 3));
  }

  @Test
  public void testIsOutBoundsTrue() {
    assertEquals(true, board.isOutOfBounds(0,0));
    assertEquals(true, board.isOutOfBounds(6, 6));
  }

  @Test
  public void testIsOutBoundsFalse() {
    assertEquals(false, board.isOutOfBounds(2, 2));
    assertEquals(false, board.isOutOfBounds(4, 6));
  }

  @Test
  public void testGetRowLength() {
    assertEquals(7, board.getRowLength());
  }

  @Test
  public void testGetColLength() {
    assertEquals(7, board.getColLength());
  }

  @Test
  public void testGetPieceX() {
    assertEquals(Piece.X, board.getSpace(3, 3));
  }

  @Test
  public void testGetPieceO() {
    assertEquals(Piece.O, board.getSpace(1, 4));
  }


}