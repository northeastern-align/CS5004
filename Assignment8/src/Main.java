
public class Main {
  public static void main(String[] args) {
    IAnimationModel model = new AnimationModel();

    // Example of adding a shape
    model.addShape("Rectangle1", ShapeType.RECTANGLE, 0, 100, 0, 0, 10, 10, 200, 100, 200);
    model.addShape("Ellipse1", ShapeType.ELLIPSE, 0, 30,20, 20, 20, 20, 100, 200, 100);
    model.addShape("Triangle1", ShapeType.TRIANGLE, 45, 250, 50, 50, 5, 5, 50, 100, 50);
    model.addShape("Triangle2", ShapeType.TRIANGLE, 0, 0,100, 100, 15, 15, 100, 100, 100);

    // Example of adding a motion to that shape
    // I think it would be really useful to think of a way that we don't need to ask for the
    // "from locations" and just use the last location of the shape, that way we don't
    // allow the user to try to move something "from" a place that it isn't located in.
    model.addMoveMotion("Rectangle1", 0, 30, 20, 20);
    model.addScaleMotion("Rectangle1", 60, 100, 50, 50);
    model.addColorChangeMotion("Rectangle1", 0, 30, 50, 200, 100);
    model.addScaleMotion("Ellipse1", 5, 25,  60, 60);
    model.addColorChangeMotion("Triangle1", 50, 90, 200, 200, 200);

    System.out.println(model.getState());

  }
}
