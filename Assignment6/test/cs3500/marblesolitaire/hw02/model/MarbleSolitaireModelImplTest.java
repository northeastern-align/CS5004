package cs3500.marblesolitaire.hw02.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Junit test class for the implementation of the Marble Solitaire game. This test attempts to show
 * functionality for all components of the MarbleSolitaire ModelImpl.
 */

public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModelImpl game;

  @Before
  public void setup() {
    game = new MarbleSolitaireModelImpl(3, 3);
  }

  @Test
  public void testStandardStart() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O X O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", game.getGameState());
  }

  @Test
  public void testDefaultConstructor() {
    game = new MarbleSolitaireModelImpl();
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O X O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", game.getGameState());
  }

  @Test
  public void testStartRow6Col4() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O X", new MarbleSolitaireModelImpl(6, 4).getGameState());
  }

  @Test
  public void testStartRow0Col2() {
    assertEquals("    X O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", new MarbleSolitaireModelImpl(0, 2).getGameState());
  }

  @Test
  public void testStartRow3Col0() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "X O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", new MarbleSolitaireModelImpl(3, 0).getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartRow0Col0() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", new MarbleSolitaireModelImpl(0, 0).getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStartRow5Col5() {
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "O O O O O O O\n"
        + "    O O O\n"
        + "    O O O", new MarbleSolitaireModelImpl(5, 5).getGameState());
  }

  @Test
  public void testGameScore() {
    assertEquals(32, game.getScore());
  }

  @Test
  public void testGameOver() {
    assertEquals(false, game.isGameOver());
  }

  @Test
  public void gameStateAtEnd() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(6, 2, 4, 2);
    game.move(6, 4, 6, 2);
    game.move(3, 2, 5, 2);
    game.move(6, 2, 4, 2);
    game.move(1, 2, 3, 2);
    game.move(2, 0, 2, 2);
    game.move(4, 0, 2, 0);
    game.move(2, 3, 2, 1);
    game.move(2, 0, 2, 2);
    game.move(2, 5, 2, 3);
    game.move(0, 4, 2, 4);
    game.move(0, 2, 0, 4);
    game.move(3, 4, 1, 4);
    game.move(0, 4, 2, 4);
    game.move(5, 4, 3, 4);
    game.move(4, 6, 4, 4);
    game.move(2, 6, 4, 6);
    game.move(4, 3, 4, 5);
    game.move(4, 6, 4, 4);
    game.move(2, 3, 2, 5);
    game.move(2, 5, 4, 5);
    game.move(4, 5, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    game.move(2, 1, 2, 3);
    game.move(3, 3, 3, 1);
    game.move(1, 3, 3, 3);
    game.move(3, 4, 3, 2);
    game.move(3, 1, 3, 3);
    assertEquals("    X X X\n"
        + "    X X X\n"
        + "X X X X X X X\n"
        + "X X X O X X X\n"
        + "X X X X X X X\n"
        + "    X X X\n"
        + "    X X X", game.getGameState());
  }

  @Test
  public void gameStateThroughOut() {
    assertEquals(32, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(5, 3, 3, 3);

    assertEquals(31, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 1, 4, 3);

    assertEquals(30, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(6, 2, 4, 2);

    assertEquals(29, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(6, 4, 6, 2);

    assertEquals(28, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(3, 2, 5, 2);

    assertEquals(27, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(6, 2, 4, 2);

    assertEquals(26, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(1, 2, 3, 2);

    assertEquals(25, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 0, 2, 2);

    assertEquals(24, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 0, 2, 0);

    assertEquals(23, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 3, 2, 1);

    assertEquals(22, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 0, 2, 2);

    assertEquals(21, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 5, 2, 3);

    assertEquals(20, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(0, 4, 2, 4);

    assertEquals(19, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(0, 2, 0, 4);

    assertEquals(18, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(3, 4, 1, 4);

    assertEquals(17, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(0, 4, 2, 4);

    assertEquals(16, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(5, 4, 3, 4);

    assertEquals(15, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 6, 4, 4);

    assertEquals(14, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 6, 4, 6);

    assertEquals(13, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 3, 4, 5);

    assertEquals(12, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 6, 4, 4);

    assertEquals(11, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 3, 2, 5);

    assertEquals(10, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 5, 4, 5);

    assertEquals(9, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 5, 4, 3);

    assertEquals(8, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 3, 4, 1);

    assertEquals(7, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(4, 1, 2, 1);

    assertEquals(6, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(2, 1, 2, 3);

    assertEquals(5, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(3, 3, 3, 1);

    assertEquals(4, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(1, 3, 3, 3);

    assertEquals(3, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(3, 4, 3, 2);

    assertEquals(2, game.getScore());
    assertEquals(false, game.isGameOver());
    game.move(3, 1, 3, 3);
    assertEquals("    X X X\n"
        + "    X X X\n"
        + "X X X X X X X\n"
        + "X X X O X X X\n"
        + "X X X X X X X\n"
        + "    X X X\n"
        + "    X X X", game.getGameState());
    assertEquals(true, game.isGameOver());
    assertEquals(1, game.getScore());
  }

  @Test
  public void testLostGame() {
    game.move(5, 3, 3, 3);
    game.move(2, 3, 4, 3);
    game.move(0, 3, 2, 3);
    game.move(3, 1, 3, 3);
    game.move(3, 4, 3, 2);
    game.move(3, 6, 3, 4);
    assertEquals("    O X O\n"
        + "    O X O\n"
        + "O O O O O O O\n"
        + "O X O X O X X\n"
        + "O O O O O O O\n"
        + "    O X O\n"
        + "    O O O", game.getGameState());
    assertEquals(true, game.isGameOver());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveVert1() {
    game.move(2, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveHoriz1() {
    game.move(3, 4, 3, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveVert2() {
    game.move(4, 5, 2, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveHoriz2() {
    game.move(6, 3, 6, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOverSpace1() {
    game.move(5, 3, 3, 3);
    game.move(3, 3, 5, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveOverSpace2() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(4, 3, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTooFar() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(4, 4, 4, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveTooClose() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(4, 3, 4, 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveSameLocation() {
    game.move(5, 3, 5, 3);

  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveDiagonal() {
    game.move(3, 5, 3, 3);
    game.move(1, 4, 3, 4);
    game.move(4, 2, 2, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testOutOfBounds() {
    game.move(0, 3, 0, 5);
  }

  @Test
  public void testPartiallyPlayed() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);

    assertEquals(25, game.getScore());
    assertEquals(false, game.isGameOver());
    assertEquals("    O O O\n"
        + "    O O O\n"
        + "O O O O O O O\n"
        + "O X O X X X O\n"
        + "O O O X O X X\n"
        + "    X O O\n"
        + "    O O O", game.getGameState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPartiallyPlayedIllegalMove1() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);
    game.move(0, 3, 2, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPartiallyPlayedIllegalMove2() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);
    game.move(2, 3, 4, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPartiallyPlayedIllegalMove3() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);
    game.move(4, 3, 4, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPartiallyPlayedIllegalMove4() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);
    game.move(2, 2, 3, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPartiallyPlayedIllegalMove5() {
    game = new MarbleSolitaireModelImpl();
    game.move(3, 1, 3, 3);
    game.move(5, 2, 3, 2);
    game.move(4, 4, 4, 2);
    game.move(2, 3, 4, 3);
    game.move(3, 5, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(4, 6, 4, 4);
    game.move(3, 6, 3, 8);
  }

  @Test
  public void testGameStateBeforeLosing() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(6, 2, 4, 2);
    game.move(6, 4, 6, 2);
    game.move(3, 2, 5, 2);
    game.move(6, 2, 4, 2);
    game.move(1, 2, 3, 2);
    game.move(2, 0, 2, 2);
    game.move(4, 0, 2, 0);
    game.move(2, 3, 2, 1);
    game.move(2, 0, 2, 2);
    game.move(2, 5, 2, 3);
    game.move(0, 4, 2, 4);
    game.move(0, 2, 0, 4);
    game.move(3, 4, 1, 4);
    game.move(0, 4, 2, 4);
    game.move(5, 4, 3, 4);
    game.move(4, 6, 4, 4);
    game.move(2, 6, 4, 6);
    game.move(4, 3, 4, 5);
    game.move(4, 6, 4, 4);
    game.move(2, 3, 2, 5);
    game.move(2, 5, 4, 5);
    game.move(4, 5, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    game.move(2, 1, 2, 3);
    game.move(3, 3, 3, 1);

    assertEquals(4, game.getScore());
    assertEquals(false, game.isGameOver());
    assertEquals("    X X X\n"
        + "    X O X\n"
        + "X X X O X X X\n"
        + "X O X X O X X\n"
        + "X X X X X X X\n"
        + "    X X X\n"
        + "    X X X", game.getGameState());
  }

  @Test
  public void testGameStateLastMove() {
    game.move(5, 3, 3, 3);
    game.move(4, 1, 4, 3);
    game.move(6, 2, 4, 2);
    game.move(6, 4, 6, 2);
    game.move(3, 2, 5, 2);
    game.move(6, 2, 4, 2);
    game.move(1, 2, 3, 2);
    game.move(2, 0, 2, 2);
    game.move(4, 0, 2, 0);
    game.move(2, 3, 2, 1);
    game.move(2, 0, 2, 2);
    game.move(2, 5, 2, 3);
    game.move(0, 4, 2, 4);
    game.move(0, 2, 0, 4);
    game.move(3, 4, 1, 4);
    game.move(0, 4, 2, 4);
    game.move(5, 4, 3, 4);
    game.move(4, 6, 4, 4);
    game.move(2, 6, 4, 6);
    game.move(4, 3, 4, 5);
    game.move(4, 6, 4, 4);
    game.move(2, 3, 2, 5);
    game.move(2, 5, 4, 5);
    game.move(4, 5, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    game.move(2, 1, 2, 3);
    game.move(3, 3, 3, 1);
    game.move(2, 3, 0, 3);

    assertEquals(3, game.getScore());
    assertEquals(true, game.isGameOver());
    assertEquals("    X O X\n"
        + "    X X X\n"
        + "X X X X X X X\n"
        + "X O X X O X X\n"
        + "X X X X X X X\n"
        + "    X X X\n"
        + "    X X X", game.getGameState());
  }

}