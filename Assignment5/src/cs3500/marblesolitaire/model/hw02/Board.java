package cs3500.marblesolitaire.model.hw02;

/**
 * This class implements the attributes stored in the IBoard interface as a board for Marble
 * Solitaire. It is constructed by creating a [7][7] double array and associating the appropriate
 * enumerated pieces to each location.
 */

public class Board implements IBoard {

  private Piece[][] board;

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

  /**
   * A setter that takes in a row and column location and places a corresponding piece at that
   * location on the gameboard.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @param piece a enumerated Piece object (X, O, or E for empty)
   */
  @Override
  public void setPiece(int row, int col, Piece piece) {
    board[row][col] = piece;
  }

  /**
   * Returns a boolean if a specific location on the board is empty (true) or not empty (false).
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return a boolean value if the the specified location is empty or not
   */
  @Override
  public boolean isEmpty(int row, int col) {
    return board[row][col] == Piece.X;
  }

  /**
   * Returns a boolean on whether or not a specific location is outside the geometry limits of the
   * board.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return a boolean value if the the specified location is out of bounds
   */
  @Override
  public boolean isOutOfBounds(int row, int col) {
    try {
      return board[row][col] != Piece.X && board[row][col] != Piece.O;
    }
    catch (ArrayIndexOutOfBoundsException e) {
      return true;
    }
  }

  /**
   * A getter that returns the number of columns in a row - used for for-loop iteration.
   *
   * @return an integer representing the total number of values in a row
   */
  @Override
  public int getRowLength() {
    return board.length;
  }

  /**
   * A getter that returns the number of rows in a column - used for for-loop iteration.
   *
   * @return an integer representing the total number of values in a column
   */
  @Override
  public int getColLength() {
    return board[0].length;
  }

  /**
   * A getter that returns the Piece type of a specified space.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return the enumerated type that is at the specified location
   */
  @Override
  public Piece getSpace(int row, int col) {
    return board[row][col];
  }


}
