package cs3500.marblesolitaire.controller;

import cs3500.marblesolitaire.hw02.model.MarbleSolitaireModel;

/**
 * This interface represents the operations offered by the marble solitaire controller. The
 * controller is used to run and dictate flow of the Marble Solitaire program.
 */
public interface MarbleSolitaireController {

  /**
   * This function initiates the gameState and gameMove functions, effectively playing the game,
   * while also ensuring the passed model is valid (not null).
   *
   * @param model the model of the Marble Solitaire game being played
   * @throws IllegalArgumentException if the model is null
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException;

}
