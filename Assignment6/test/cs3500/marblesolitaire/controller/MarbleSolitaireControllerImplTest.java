package cs3500.marblesolitaire.controller;

import static org.junit.Assert.assertEquals;

import cs3500.marblesolitaire.hw02.model.MarbleSolitaireModel;
import cs3500.marblesolitaire.hw02.model.MarbleSolitaireModelImpl;
import java.io.StringReader;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit test for the MarbleSolitaireControllerImpl class.
 */
public class MarbleSolitaireControllerImplTest {

  MarbleSolitaireModel game;
  Appendable appendable;

  @Before
  public void setUp() {
    game = new MarbleSolitaireModelImpl();
    appendable = new StringBuilder();
  }

  @Test
  public void firstMoveUpperQuit() {
    Readable readable = new StringReader("Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void firstMoveLowerQuit() {
    Readable readable = new StringReader("4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void firstMoveDown() {
    Readable readable = new StringReader("2 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O X O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O X O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n", appendable.toString());
  }

  @Test
  public void firstMoveLeft() {
    Readable readable = new StringReader("4 6 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O X X O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O X X O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n", appendable.toString());
  }

  @Test
  public void firstMoveUp() {
    Readable readable = new StringReader("6 4 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n", appendable.toString());
  }

  @Test
  public void firstMoveRight() {
    Readable readable = new StringReader("4 2 4 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n", appendable.toString());
  }

  @Test
  public void testFullGame() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 7 3 5 3 7 5 7 3 4 3 6 3 7 3 5 3 2 3 4"
        + " 3 3 1 3 3 5 1 3 1 3 4 3 2 3 1 3 3 3 6 3 4 1 5 3 5 1 3 1 5 4 5 2 5 1 5 3 5 6 5 4 5 5 7 5"
        + " 5 3 7 5 7 5 4 5 6 5 7 5 5 3 4 3 6 3 6 5 6 5 6 5 4 5 4 5 2 5 2 3 2 3 2 3 4 4 4 4 2 2 4 4"
        + " 4 4 5 4 3 4 2 4 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X O O\n" +
        "Score: 29\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    O X X\n" +
        "Score: 28\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O X O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O X X\n" +
        "Score: 27\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O X O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 26\n" +
        "    O O O\n" +
        "    X O O\n" +
        "O O X O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 25\n" +
        "    O O O\n" +
        "    X O O\n" +
        "X X O O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 24\n" +
        "    O O O\n" +
        "    X O O\n" +
        "O X O O O O O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 23\n" +
        "    O O O\n" +
        "    X O O\n" +
        "O O X X O O O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 22\n" +
        "    O O O\n" +
        "    X O O\n" +
        "X X O X O O O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 21\n" +
        "    O O O\n" +
        "    X O O\n" +
        "X X O O X X O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 20\n" +
        "    O O X\n" +
        "    X O X\n" +
        "X X O O O X O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 19\n" +
        "    X X O\n" +
        "    X O X\n" +
        "X X O O O X O\n" +
        "X O O O O O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 18\n" +
        "    X X O\n" +
        "    X O O\n" +
        "X X O O X X O\n" +
        "X O O O X O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 17\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X O\n" +
        "X O O O X O O\n" +
        "X X O O O O O\n" +
        "    X X O\n" +
        "    X X X\n" +
        "Score: 16\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X O\n" +
        "X O O O O O O\n" +
        "X X O O X O O\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 15\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X O\n" +
        "X O O O O O O\n" +
        "X X O O O X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 14\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X X\n" +
        "X O O O O O X\n" +
        "X X O O O X O\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 13\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X X\n" +
        "X O O O O O X\n" +
        "X X O X X O O\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 12\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O O O X X\n" +
        "X O O O O O X\n" +
        "X X O X O X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 11\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O X X O X\n" +
        "X O O O O O X\n" +
        "X X O X O X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 10\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O X X X X\n" +
        "X O O O O X X\n" +
        "X X O X O O X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 9\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O X X X X\n" +
        "X O O O O X X\n" +
        "X X O O X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 8\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X O X X X X\n" +
        "X O O O O X X\n" +
        "X O X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 7\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X O O X X X X\n" +
        "X X O O O X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 6\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X X O X X X\n" +
        "X X O O O X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 5\n" +
        "    X X X\n" +
        "    X O X\n" +
        "X X X O X X X\n" +
        "X O X X O X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 4\n" +
        "    X X X\n" +
        "    X X X\n" +
        "X X X X X X X\n" +
        "X O X O O X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 3\n" +
        "    X X X\n" +
        "    X X X\n" +
        "X X X X X X X\n" +
        "X O O X X X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 2\n" +
        "    X X X\n" +
        "    X X X\n" +
        "X X X X X X X\n" +
        "X X X O X X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 1\n" +
        "Game over!\n" +
        "    X X X\n" +
        "    X X X\n" +
        "X X X X X X X\n" +
        "X X X O X X X\n" +
        "X X X X X X X\n" +
        "    X X X\n" +
        "    X X X\n" +
        "Score: 1\n", appendable.toString());
  }

  @Test
  public void testPartialGame() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 7 3 5 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X O O\n" +
        "Score: 29\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O O O O O\n" +
        "    X X O\n" +
        "    X O O\n" +
        "Score: 29\n", appendable.toString());
  }

  @Test
  public void invalidChars() {
    Readable readable = new StringReader("A b C d E f G h I j K l M n O p Q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "A is an unrecognized character, please enter a valid positive integer!\n" +
        "b is an unrecognized character, please enter a valid positive integer!\n" +
        "C is an unrecognized character, please enter a valid positive integer!\n" +
        "d is an unrecognized character, please enter a valid positive integer!\n" +
        "E is an unrecognized character, please enter a valid positive integer!\n" +
        "f is an unrecognized character, please enter a valid positive integer!\n" +
        "G is an unrecognized character, please enter a valid positive integer!\n" +
        "h is an unrecognized character, please enter a valid positive integer!\n" +
        "I is an unrecognized character, please enter a valid positive integer!\n" +
        "j is an unrecognized character, please enter a valid positive integer!\n" +
        "K is an unrecognized character, please enter a valid positive integer!\n" +
        "l is an unrecognized character, please enter a valid positive integer!\n" +
        "M is an unrecognized character, please enter a valid positive integer!\n" +
        "n is an unrecognized character, please enter a valid positive integer!\n" +
        "O is an unrecognized character, please enter a valid positive integer!\n" +
        "p is an unrecognized character, please enter a valid positive integer!\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void validMovesWithIllegalChar() {
    Readable readable = new StringReader("4 2 4 4 A 4 5 4 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "A is an unrecognized character, please enter a valid positive integer!\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void validMovesWithNegative() {
    Readable readable = new StringReader("4 2 4 4 -2 4 5 4 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "-2 is out of bounds, please enter a valid positive integer!\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void validMovesWithNegativeInDiffPosition() {
    Readable readable = new StringReader("4 2 4 4 4 5 4 -2 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "-2 is out of bounds, please enter a valid positive integer!\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void wrongStringFormat() {
    Readable readable = new StringReader("42444543 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void wrongStringFormatCommas() {
    Readable readable = new StringReader("4, 2, 4, 4, q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "4, is an unrecognized character, please enter a valid positive integer!\n" +
        "2, is an unrecognized character, please enter a valid positive integer!\n" +
        "4, is an unrecognized character, please enter a valid positive integer!\n" +
        "4, is an unrecognized character, please enter a valid positive integer!\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void illegalMove() {
    Readable readable = new StringReader("1 1 1 1 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "Invalid move. Play again.\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void fromIllegalLocation() {
    Readable readable = new StringReader("0 4 2 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "0 is out of bounds, please enter a valid positive integer!\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void mixOfIllegalandLegal() {
    Readable readable = new StringReader("6 0 4 -2 4 a 4 '5' 5 3, 2 $ 5 -2b! 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "0 is out of bounds, please enter a valid positive integer!\n" +
        "-2 is out of bounds, please enter a valid positive integer!\n" +
        "a is an unrecognized character, please enter a valid positive integer!\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "'5' is an unrecognized character, please enter a valid positive integer!\n" +
        "3, is an unrecognized character, please enter a valid positive integer!\n" +
        "$ is an unrecognized character, please enter a valid positive integer!\n" +
        "-2b! is an unrecognized character, please enter a valid positive integer!\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void testMultipleQuits() {
    Readable readable = new StringReader("4 4 Q q Q q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n", appendable.toString());
  }

  @Test
  public void testValidThenInvalid1() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 3 3 3 5 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Invalid move. Play again.\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void testValidThenInvalid2() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 5 2 5 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Invalid move. Play again.\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void testValidThenInvalid3() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 4 4 2 4 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Invalid move. Play again.\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void testValidThenInvalid4() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 5 2 5 3 5 5 5 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Invalid move. Play again.\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 29\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 29\n", appendable.toString());
  }

  @Test
  public void testValidThenInvalid5() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 10 5 5 3 q");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "Invalid move. Play again.\n" +
        "Game quit!\n" +
        "State of game when quit:\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n", appendable.toString());
  }

  @Test
  public void testLostGame() {
    Readable readable = new StringReader("6 4 4 4 3 4 5 4 1 4 3 4 4 2 4 4 4 5 4 3 4 7 4 5");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
    assertEquals("    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O O O\n" +
        "    O O O\n" +
        "Score: 32\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O O O O O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 31\n" +
        "    O O O\n" +
        "    O O O\n" +
        "O O O X O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 30\n" +
        "    O X O\n" +
        "    O X O\n" +
        "O O O O O O O\n" +
        "O O O X O O O\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 29\n" +
        "    O X O\n" +
        "    O X O\n" +
        "O O O O O O O\n" +
        "O X X O O O O\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 28\n" +
        "    O X O\n" +
        "    O X O\n" +
        "O O O O O O O\n" +
        "O X O X X O O\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 27\n" +
        "    O X O\n" +
        "    O X O\n" +
        "O O O O O O O\n" +
        "O X O X O X X\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 26\n" +
        "Game over!\n" +
        "    O X O\n" +
        "    O X O\n" +
        "O O O O O O O\n" +
        "O X O X O X X\n" +
        "O O O O O O O\n" +
        "    O X O\n" +
        "    O O O\n" +
        "Score: 26\n", appendable.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testAlmostFullGameNoQuit() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4 7 3 5 3 7 5 7 3 4 3 6 3 7 3 5 3 2 3 4"
        + " 3 3 1 3 3 5 1 3 1 3 4 3 2 3 1 3 3 3 6 3 4 1 5 3 5 1 3 1 5 4 5 2 5 1 5 3 5 6 5 4 5 5 7 5"
        + " 5 3 7 5 7 5 4 5 6 5 7 5 5 3 4 3 6 3 6 5 6 5 6 5 4 5 4 5 2 5 2 3 2 3 2 3 4 4 4 4 2 2 4 4"
        + " 4 4 5 4 3 4 2 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullRd() {
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(null, appendable);
    controller.playGame(game);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNullAp() {
    Readable readable = new StringReader("6 4 4 4 5 2 5 4");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, null);
    controller.playGame(game);
  }

  @Test(expected = IllegalStateException.class)
  public void testEmptyString() {
    Readable readable = new StringReader("");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(readable, appendable);
    controller.playGame(game);
  }

}