
/**
 * This is an interface for chess pieces.
 */

public interface IChessPiece {

  // Set board parameters
  int boardMin = 0;
  int boardMax = 7;

  // Get functions
  int getRow();

  int getColumn();

  Color getColor();

  boolean canMove(int row, int col);

  boolean canKill(AbstractPiece piece);

}
