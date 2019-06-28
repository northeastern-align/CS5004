package cs3500.marblesolitaire.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the attributes stored in the MarbleSolitaireModel as a game of Marble
 * Solitaire. It is constructed by providing the empty space on the board and complies with the
 * board geometry.
 */

public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  List<IRule> allPossibleCommands = new ArrayList<IRule>();
  private IBoard board;

  /**
   * A constructor that creates a gameboard with a start space location at 3, 3. This constructor
   * stores the rules to a list of all possible commands.
   */
  public MarbleSolitaireModelImpl() {
    this.board = new Board(3, 3);
    allPossibleCommands.add(new HorizontalMove());
    allPossibleCommands.add(new VerticalMove());
  }

  /**
   * A constructor that creates a gameboard and the provided row/column integers serves as the
   * starting point. This constructor stores the rules to a list of all possible commands.
   *
   * @param row an integer representing the row of the game
   * @param col an integer representing the column of the game
   */
  public MarbleSolitaireModelImpl(int row, int col) {
    this.board = new Board(row, col);
    allPossibleCommands.add(new HorizontalMove());
    allPossibleCommands.add(new VerticalMove());
  }

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow the row number of the position to be moved to (starts at 0)
   * @param toCol the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException thrown when a non-legal move is used
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    for (IRule rule : allPossibleCommands) {
      if (rule.validMove(fromRow, fromCol, toRow, toCol, board)) {
        board.setPiece(fromRow, fromCol, Piece.X);
        board.setPiece((fromRow + toRow) / 2, (fromCol + toCol) / 2, Piece.X);
        board.setPiece(toRow, toCol, Piece.O);
        return;
      }
    }
    throw new IllegalArgumentException("Not a legal move!");
  }

  /**
   * Returns a boolean value on whether or not the game is over. Checks if the final game score is
   * reached and all possible moves from existing marbles have been completed.
   *
   * @return a boolean stating whether or not the game is considered to be done.
   */
  @Override
  public boolean isGameOver() {
    int i;
    int j;

    if (this.getScore() == 1) {
      return true;
    }
    for (i = 0; i < board.getRowLength(); i++) {
      for (j = 0; j < board.getColLength(); j++) {
        if (board.getSpace(i, j) == Piece.O) {
          for (IRule rule : allPossibleCommands) {
            if ((rule.validMove(i, j, i + 2, j, board))
                || (rule.validMove(i, j, i - 2, j, board))
                || (rule.validMove(i, j, i, j + 2, board))
                || (rule.validMove(i, j, i, j - 2, board))) {
              return false;
            }
          }
        }
      }
    }
    return true;

  }

  /**
   * Returns a string print out of the gameboard. Enums X and O print a corresponding string, while
   * Empty spaces return a space.
   *
   * @return a string describing the state of the gameboard
   */
  @Override
  public String getGameState() {
    int i;
    int j;

    String gameState = "";

    for (i = 0; i < board.getRowLength(); i++) {
      if (i > 0) {
        gameState += "\n";
      }
      for (j = 0; j < board.getColLength(); j++) {

        if (board.getSpace(i, j) == Piece.E) {
          if (j > 0) {
            gameState += " ";
          }
          gameState += " ";

        } else if (board.getSpace(i, j) == Piece.O) {
          if (j > 0) {
            gameState += " ";
          }
          gameState += "O";
        } else if (board.getSpace(i, j) == Piece.X) {
          if (j > 0) {
            gameState += " ";
          }
          gameState += "X";
        } else {
          break;
        }
      }
    }

    return gameState;
  }

  /**
   * Returns the score of the game, counted by how many marbles remain on the board (1 is winning,
   * 32 is when the game begins).
   *
   * @return an integer value representing the count of marbles on the board
   */
  @Override
  public int getScore() {
    int count = 0;

    for (int i = 0; i < board.getRowLength(); i++) {
      for (int j = 0; j < board.getColLength(); j++) {
        if (board.getSpace(i, j) == Piece.O) {
          count += 1;
        }
      }
    }
    return count;
  }
}

