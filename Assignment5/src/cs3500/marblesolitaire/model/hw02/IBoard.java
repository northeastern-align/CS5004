package cs3500.marblesolitaire.model.hw02;

/**
 * This interface represents the operations offered by the marble solitaire board class. One object
 * represents one board for marble solitaire.
 */
public interface IBoard {

  /**
   * A setter that takes in a row and column location and places a corresponding piece at that
   * location on the gameboard.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @param piece a enumerated Piece object (X, O, or E for empty)
   */
  void setPiece(int row, int col, Piece piece);

  /**
   * Returns a boolean if a specific location on the board is empty (true) or not empty (false).
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return a boolean value if the the specified location is empty or not
   */
  boolean isEmpty(int row, int col);

  /**
   * Returns a boolean on whether or not a specific location is outside the geometry limits of the
   * board.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return a boolean value if the the specified location is out of bounds
   */
  boolean isOutOfBounds(int row, int col);

  /**
   * A getter that returns the number of columns in a row - used for for-loop iteration.
   *
   * @return an integer representing the total number of values in a row
   */
  int getRowLength();

  /**
   * A getter that returns the number of rows in a column - used for for-loop iteration.
   *
   * @return an integer representing the total number of values in a column
   */
  int getColLength();

  /**
   * A getter that returns the Piece type of a specified space.
   *
   * @param row an integer representing the row of the board
   * @param col an integer representing the column of the board
   * @return the enumerated type that is at the specified location
   */
  Piece getSpace(int row, int col);
}
