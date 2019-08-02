package cs5004.animator.view;

import cs5004.animator.model.IMotion;
import java.util.List;
import java.util.Map;

public class TextView {

  private List<IViewShape> shapes;

  private TextView(java.util.List<IViewShape> shapes) {
    this.shapes = shapes;
  }

  /**
   * Prints out the toString methods of the shapes and animations.
   *
   * @return a string listing out the shapes and animations
   */
  @Override
  public String getState() {

    StringBuilder endString = new StringBuilder();
    endString.append("Shapes:\n");

    for (String key : shapes.keySet()) {
      endString.append("Name: " + key + "\n");
      endString.append(shapes.get(key).toString() + "\n");
    }

    for (Map.Entry<IMotion, String> entry : motions.entrySet()) {
      endString.append("Shape " + entry.getValue() + " " + entry.getKey() + "\n");
    }

    return endString.toString();

  }

}
