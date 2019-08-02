package cs5004.animator.controller;

import cs5004.animator.model.AnimationModel;
import java.util.Timer;

public class Controller implements IController {

  final Readable in;
  final Appendable out;
  Timer timer;

  public Controller(Readable in, Appendable out) throws IllegalArgumentException {
    if ( in == null || out == null ) {
      throw new IllegalArgumentException("Constructor input and output must not be null!");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void playAnimation(AnimationModel model) throws IllegalArgumentException {
    timer.start();
  }
}
