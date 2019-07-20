package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractBoard;

/**
 * This class implements the attributes stored in the IBoard interface as a board for Marble
 * Solitaire. It is constructed by creating a [7][7] double array and associating the appropriate
 * enumerated pieces to each location.
 */

public class Board extends AbstractBoard implements IBoard {

  private Piece[][] board;

  public Board() {

    board = new Piece[7][7];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if ((i < 2 || i > 4) && j < 2) {
          board[i][j] = Piece.E;
        } else if (i == 3 && j == 3) {
          board[i][j] = Piece.X;
        } else if ((i > 1 && i < 5) || j < 5) {
         board[i][j] = Piece.O;
        }
      }
    }
  }

  public Board(int width) throws IllegalArgumentException {
    int sideLength = width - 1;
    board = new Piece[width + (2 * sideLength)][width + (2 * sideLength)];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (( i < sideLength || i > (sideLength * 2)) && j < sideLength) {
          board[i][j] = Piece.E;
        } else if (i == width && j == width) {
          board[i][j] = Piece.X;
        } else if ((i > (sideLength - 1) && i < (sideLength + width)) || j < (sideLength + width)) {
          board[i][j] = Piece.O;
        }
      }
    }

  }

  /**
   * A constructor that creates a gameboard and the provided row/column integers serves as the
   * starting point.
   *
   * @param row an integer representing the row of the game
   * @param col an integer representing the column of the game
   * @throws IllegalArgumentException if row and column pair are out of bounds
   */
  public Board(int row, int col) throws IllegalArgumentException {
    board = new Piece[7][7];

    if ((row < 2 || row > 4) && (col < 2 || col > 4)) {
      throw new IllegalArgumentException("Blank space is out of bounds!");
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if ((i < 2 || i > 4) && j < 2) {
          board[i][j] = Piece.E;
        } else if (i == row && j == col) {
          board[i][j] = Piece.X;
        } else if ((i > 1 && i < 5) || j < 5) {
          board[i][j] = Piece.O;
        }
      }
    }
  }

}
