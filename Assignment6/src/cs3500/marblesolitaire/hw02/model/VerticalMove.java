package cs3500.marblesolitaire.hw02.model;

/**
 * This class implements the attributes stored in the IRule interface as a rule for Marble
 * Solitaire. This rule determines if a vertical move is valid per movement policy.
 */

public class VerticalMove implements IRule {

  /**
   * Determines if the move to and from a location is valid based on the configuration of a
   * gameboard. The validity of a move is determined from four factors - if the spaces are two
   * vertical units away, there is a piece in between the spots, the destination location
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
    if (fromCol == toCol) {
      if (Math.abs(fromRow - toRow) == 2) {
        if (!(board.isEmpty((fromRow + toRow) / 2, toCol))) {
          return board.isEmpty(toRow, toCol);
        }
      }
    }
    return false;
  }
}
