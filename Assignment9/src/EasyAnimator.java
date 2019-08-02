import java.io.IOException;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.IAnimationModel;
import cs5004.animator.util.AnimationFileReader;
import cs5004.animator.util.TweenModelBuilder;


/**
 * EasyAnimator class as an example of how to use the animator.
 */
public class EasyAnimator {
  /**
   * EasyAnimator class as an example of how to use the animator.
   * @param args arguments
   */
  public static void main(String[] args) {

    IAnimationModel model = null;

    TweenModelBuilder<IAnimationModel> builder = AnimationModel.getBuilder();

    AnimationFileReader fileReader = new AnimationFileReader();

    try {
      model = fileReader.readFile("./toh-3.txt", builder);
    } catch (IOException e){
      System.err.println("Not a valid file!");
    }

    System.out.println(model.getState());

  }
}
