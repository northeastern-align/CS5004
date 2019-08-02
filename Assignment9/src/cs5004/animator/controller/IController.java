package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;

public interface IController {

  void playAnimation(AnimationModel model) throws IllegalArgumentException;

}
