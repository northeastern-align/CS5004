package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.IBoard;
import cs3500.marblesolitaire.model.hw02.Piece;

public abstract class AbstractBoard implements IBoard {

  protected Piece[][] board;

  @Override
  public void setPiece(int row, int col, Piece piece)  {
    board[row][col] = piece;
  }

  @Override
  public boolean isEmpty(int row, int col)  {
    return (board[row][col] != Piece.O);
  }

  @Override
  public boolean isOutOfBounds(int row, int col) {
    try {
      return board[row][col] != Piece.X && board[row][col] != Piece.O;
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return true;
    }
  }

  @Override
  public int getRowLength()  {
    return board.length;
  }

  @Override
  public int getColLength()  {
    return board[0].length;
  }


  @Override
  public Piece getSpace(int row, int col)  {
    return board[row][col];
  }
}
