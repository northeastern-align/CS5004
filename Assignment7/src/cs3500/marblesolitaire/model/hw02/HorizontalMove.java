package cs3500.marblesolitaire.model.hw02;

/**
 * This class implements the attributes stored in the IRule interface as a rule for Marble
 * Solitaire. This rule determines if a horizontal move is valid per game policy.
 */

public class HorizontalMove implements IRule {

  /**
   * Determines if the move to and from a location is valid based on the configuration of a
   * gameboard. The validity of a move is determined from four factors - if the spaces are two
   * horizontal units away, there is a piece in between the spots, and the destination location
   * is empty, and both locations are in bounds.
   *
   * @param fromRow the starting row
   * @param fromCol the starting column
   * @param toRow the destination row
   * @param toCol the destination column
   * @param board the gameboard to be used to determine if the move is valid
   * @return a boolean showing if the move is considered valid or invalid based on locations and
   *          board configuration
   */
  @Override
  public boolean validMove(int fromRow, int fromCol, int toRow, int toCol, IBoard board) {
    if (board.isOutOfBounds(fromRow, fromCol) || board.isOutOfBounds(toRow, toCol)) {
      return false;
    }

    if (board.getSpace(fromRow, fromCol) != Piece.O) {
      return false;
    }
    if (fromRow == toRow) {
      if (Math.abs(fromCol - toCol) == 2) {
        if (!(board.isEmpty(toRow, (fromCol + toCol) / 2))) {
          return board.isEmpty(toRow, toCol);
        }
      }
    }
    return false;
  }
}
