/**
 * This class represents the chess piece Bishop that extends the AbstractPiece class. This piece is
 * passed a row, column, and piece color.
 */

public class Bishop extends AbstractPiece {

  private int row;
  private int column;
  private Color color;

  /**
   * Construct a Bishop object that is passed a row, column, and piece color.
   *
   * @param row an integer value representing the row the piece is in (0-7)
   * @param column an integer value representing the column the piece is in (0-7)
   * @param color an enumerator representing the color of the piece, BLACK or WHITE
   * @throws IllegalArgumentException if the coordinates are outside the chessboard (0-7) or are not
   * the correct color
   */
  public Bishop(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);

    if (row > boardMax || row < boardMin || column > boardMax || column < boardMin) {
      throw new IllegalArgumentException("Coordinates do not fit on chessboard!");
    }

    if (!(color == Color.BLACK || color == Color.WHITE)) {
      throw new IllegalArgumentException("Colors can only be BLACK and WHITE!");
    }

    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Returns a boolean value if a Bishop can legally move to a target (row, column).
   *
   * @param row the target row for the piece to move to
   * @param column the target column for the piece to move to
   * @return a boolean if the target is a valid location based on movement rules for the piece
   */
  @Override
  public boolean canMove(int row, int column) {
    if (this.row == row && this.column == column) {
      return true;
    }

    if (row < boardMin || column < boardMin || row > boardMax || column > boardMax) {
      return false;
    }

    return (Math.abs(this.column - column) == Math.abs(this.row - row));
  }

  /**
   * Returns a boolean value if a Bishop can legally move and kill a target (row, column).
   *
   * @param piece the target of the function, the piece has its own row, column, and color
   * @return a boolean if the target can be legally killed based on rules for the piece
   */
  @Override
  public boolean canKill(AbstractPiece piece) {

    if (this.color != piece.getColor()) {
      if ( this.row == piece.getRow() && this.column == piece.getColumn()) {
        return true;
      }
      return (Math.abs(this.column - piece.getColumn()) ==
          Math.abs(this.row - piece.getRow()));
    }

    return false;
  }
}
