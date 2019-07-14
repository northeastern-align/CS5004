package cs3500.marblesolitaire.hw02.model;

/**
 * This interface represents the rules offered by the marble solitaire board game. Each rule will
 * define what a valid move is and allows for the game to become more modular.
 */

public interface IRule {

  /**
   * Determines if the move to and from a location is valid based on the configuration of a
   * gameboard.
   *
   * @param fromRow the starting row
   * @param fromCol the starting column
   * @param toRow the destination row
   * @param toCol the destination column
   * @param board the gameboard to be used to determine if the move is valid
   * @return a boolean showing if the move is considered valid or invalid based on locations and
   *          board configuration
   */
  boolean validMove(int fromRow, int fromCol, int toRow, int toCol, IBoard board);
}
