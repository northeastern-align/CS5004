package cs5004.animator.view;

public class ViewShape implements IViewShape{
  private int x;
  private int y;
  private int w;
  private int h;

  public ViewShape(int x, int y, int w, int h){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getW() {
    return this.w;
  }

  @Override
  public int getH() {
    return this.h;
  }
}
