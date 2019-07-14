package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.hw02.model.MarbleSolitaireModel;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class implements the attributes stored in the MarbleSolitaireController as a game of Marble
 * Solitaire. It is constructed by providing a readable and appendable and controls the flow of the
 * application execution. The readable contains instructions for the game while the outcome is
 * stored in the appendable.
 */

public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  final Readable in;
  final Appendable out;

  /**
   * A constructor that creates a controller for a Marble Solitaire game. This controller will
   * ultimately run a game of Marble Solitaire by receiving input and printing the game state.
   *
   * @param rd a source of characters to feed input/moves to the Marble Solitaire game
   * @param ap a destination of characters to record the outcome of the Marble Solitaire game
   * @throws IllegalArgumentException thrown if the readable or appendable are null
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap) throws IllegalArgumentException {

    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Constructor input and output must not be null!");
    }

    this.in = rd;
    this.out = ap;
  }

  /**
   * A function that takes in the game state from the MarbleSolitaireModelImpl.java class to append
   * the results. This function adds the current score of the game using a getter from the Model
   * class.
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalStateException thrown if unable to append to appendable
   */
  private void gameState(MarbleSolitaireModel model) throws IllegalStateException {
    Scanner in = new Scanner(model.getGameState());
    try {
      while (in.hasNextLine()) {
        out.append(in.nextLine() + "\n");
      }
      out.append("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Unable to write to appendable in game state!");
    }
  }

  /**
   * A function that is called when the game is quit (readable contains a Q/q). This function prints
   * that the game has been quit, shows the current game board, and final score.
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalStateException thrown if unable to append to appendable
   */
  private void gameQuit(MarbleSolitaireModel model) throws IllegalStateException {
    try {
      this.out.append("Game quit!\nState of game when quit:\n");
      this.out.append(model.getGameState() + "\n");
      this.out.append("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Unable to write to appendable in quit game!");
    }
  }

  /**
   * A function that is called when the game is determined to be over using the isGameOver function
   * from the Marble Solitaire model class. This function prints a message that the game is over,
   * shows the current game board, and final score.
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalStateException thrown if unable to append to appendable
   */
  private void gameOver(MarbleSolitaireModel model) throws IllegalStateException {
    try {
      this.out.append("Game over!\n");
      this.out.append(model.getGameState() + "\n");
      this.out.append("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("Unable to write to appendable in game over!");
    }
  }

  /**
   * A function that is called evaluate and execute the list of moves provided in a readable. This
   * evaluates each character of the readable and determines if the move is considered valid.
   * Non-valid moves include illegal characters, non-positive integers, or locations that are not on
   * the board or do not abide by the model rules. If the move is valid, the game state is updated
   * and monitored the conclusion.
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalStateException are thrown for multiple conditions. If the readable input list
   *          has been entirely read, an IllegalStateException will be thrown. If the appendable is
   *          unable to be appended to.
   */
  private void gameMove(MarbleSolitaireModel model) throws IllegalStateException {
    // Takes in readable
    Scanner input = new Scanner(this.in);

    // Variable initialization
    String moveStr;
    int moveInt;
    int index = 0;
    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol;

    while (true) {
      // Evaluates end of readable list
      try {
        moveStr = input.next();
      } catch (NoSuchElementException n) {
        throw new IllegalStateException("Input list has been completed");
      }

      // Determines if game is quit
      if (moveStr.contentEquals("q") || moveStr.contentEquals("Q")) {
        gameQuit(model);
        break;
      }

      // Determines if the readable contains valid integers
      try {
        moveInt = Integer.parseInt(moveStr);
      } catch (NumberFormatException n) {
        try {
          out.append(moveStr + " is an unrecognized character, please enter a valid positive"
              + " integer!\n");
          continue;
        } catch (IOException e) {
          throw new IllegalStateException("Unable to write to appendable for illegal character!\n");
        }
      }

      // Sets the row and column values accordingly while monitoring for illegal moves
      if (moveInt > 0) {
        if (index == 0) {
          fromRow = moveInt - 1;
          index++;
        } else if (index == 1) {
          fromCol = moveInt - 1;
          index++;
        } else if (index == 2) {
          toRow = moveInt - 1;
          index++;
        } else {
          toCol = moveInt - 1;
          try {
            model.move(fromRow, fromCol, toRow, toCol);
            gameState(model);
          } catch (IllegalArgumentException a) {
            try {
              out.append("Invalid move. Play again.\n");
            } catch (IOException e) {
              throw new IllegalStateException(
                  "Unable to write to appendable for illegal character!");
            }
          }
          index = 0;
        }
      } else {
        try {
          out.append(moveInt + " is out of bounds, please enter a valid positive integer!\n");
          continue;
        } catch (IOException e) {
          throw new IllegalStateException(
              "Unable to write to appendable for illegal character!");
        }
      }

      // Monitors for game ending conditions
      if (model.isGameOver()) {
        gameOver(model);
        break;
      }
    }
  }

  /**
   * This function initiates the gameState and gameMove functions, while also ensuring the passed
   * model is valid (not null).
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalArgumentException if the model is null
   */
  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model does not exist!");
    }
    gameState(model);
    gameMove(model);
  }
}
