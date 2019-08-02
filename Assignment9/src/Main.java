
public class Main {
  public static void main(String[] args) {
    IAnimationModel model = new AnimationModel();

    // Example of adding a shape
    model.addShape("Rectangle1", ShapeType.RECTANGLE, 0, 100, 0, 0, 10,
            10, 200, 100, 200);
    model.addShape("Ellipse1", ShapeType.ELLIPSE, 0, 30, 20, 20, 20, 20,
            100, 200, 100);
    model.addShape("Triangle1", ShapeType.TRIANGLE, 45, 250, 50, 50, 5, 5,
            50, 100, 50);
    model.addShape("Triangle2", ShapeType.TRIANGLE, 0, 0, 100, 100, 15, 15,
            100, 100, 100);

    model.addMoveMotion("Rectangle1", 0, 20, 20, 20);
    model.addMoveMotion("Rectangle1", 41, 60, 5, 5);
    model.addMoveMotion("Rectangle1", 21, 40, 30, 30);
    model.addScaleMotion("Ellipse1", 5, 25, 60, 60);
    model.addScaleMotion("Ellipse1", 4, 5, 100, 100);
    model.addScaleMotion("Ellipse1", 41, 60, 15, 15);
    model.addColorChangeMotion("Triangle1", 50, 90, 200, 200, 200);
    model.addScaleMotion("Rectangle1", 6, 30, 900, 900);

//    System.out.println(model.getState());

  }
}
