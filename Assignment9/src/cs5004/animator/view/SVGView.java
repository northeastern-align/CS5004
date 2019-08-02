package cs5004.animator.view;

import java.util.List;

public class SVGView implements IView {

  private List<IViewShape> shapes;

  private SVGView(java.util.List<IViewShape> shapes) {
    this.shapes = shapes;
  }

  @Override
  public void render(List<IViewShape> shapes) {

  }
}
