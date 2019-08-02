package cs5004.animator.view;

public interface IView {
  void render(java.util.List<IViewShape> shapes);
  Appendable getState();
}
