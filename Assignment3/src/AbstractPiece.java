/**
 * This abstract class represent a chess piece that is passed a row, column, and color. This is
 * extended by the Pawn, Rook, Knight, Bishop, and Queen classes.
 */
public abstract class AbstractPiece implements IChessPiece {

  protected int row;
  protected int column;
  protected Color color;

  /**
   * Construct an AbstractPiece object that is passed a row, column, and color.
   *
   * @param row an integer value representing the row the piece is in (0-7)
   * @param column an integer value representing the column the piece is in (0-7)
   * @param color an enumerator representing the color of the piece, BLACK or WHITE
   */
  public AbstractPiece(int row, int column, Color color) {
    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Returns the row of the chess piece.
   *
   * @return the row of the chess piece
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Returns the column of the chess piece.
   *
   * @return the column of the chess piece
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Returns the color of the chess piece.
   *
   * @return the color of the chess piece
   */
  @Override
  public Color getColor() {
    return this.color;
  }

}