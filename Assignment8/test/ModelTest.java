import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {

  private IAnimationModel model;

  @Before
  public void setup() {
    model = new AnimationModel();
  }

  @Test
  public void createRectangle1() {
    model.addShape("Rectangle1", ShapeType.RECTANGLE, 0, 100 ,0, 0, 10, 10, 200, 100, 200);
    assertEquals("Shapes:\n"
        + "Name: Rectangle1\n"
        + "Type: rectangle\n"
        + "Corner: (0, 0), Width: 10, Height: 10, Color: (200, 100, 200)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n\n", model.getState());
  }

  @Test
  public void createRectangle2() {
    model.addShape("Rectangle2", ShapeType.RECTANGLE,  10, 11, 10, 3, 5, 13, 41, 62, 73);
    assertEquals("Shapes:\n"
        + "Name: Rectangle2\n"
        + "Type: rectangle\n"
        + "Corner: (10, 3), Width: 5, Height: 13, Color: (41, 62, 73)\n"
        + "Appears at t=10\n"
        + "Disappears at t=11\n\n", model.getState());
  }

  @Test
  public void rectangleMove1() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE,  0, 75, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", 3, 17, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle3\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=0\n"
        + "Disappears at t=75\n\n"
        + "Shape Rectangle3 moves from (5, 5) to (20, 20) from t=3 to t=17\n",model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove1() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE,  13, 77,5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", 10, 5, 20, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove2() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE, 21, 25, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", -5, 5, 20, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove3() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE, 44, 96, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", 0, 0, 20, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove4() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE, 14, 16, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", 0, 10, 5, 5);
  }

  @Test
  public void rectangleResize1() {
    model.addShape("Rectangle4", ShapeType.RECTANGLE, 81, 100, 5, 5, 20, 10, 100, 100, 100);
    model.addScaleMotion("Rectangle4", 0, 100, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle4\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=81\n"
        + "Disappears at t=100\n\n"
        + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",model.getState());
  }

  @Test
  public void rectangleResize2() {
    model.addShape("Rectangle4", ShapeType.RECTANGLE, 37, 75, 5, 5, 20, 10, 100, 100, 100);
    model.addScaleMotion("Rectangle4", 0, 100, 20, 20);
    model.addColorChangeMotion("Rectangle4", 0, 99, 20, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle4\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=37\n"
        + "Disappears at t=75\n\n"
        + "Shape Rectangle4 changes color from (100, 100, 100) to (20, 20, 20) from t=0 to t=99\n"
        + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",model.getState());
  }

  @Test
  public void rectangleResize3() {
    model.addShape("Rectangle4", ShapeType.RECTANGLE,  0, 100,5, 5, 20, 10, 100, 100, 100);
    model.addScaleMotion("Rectangle4", 0, 100, 20, 20);
    model.addColorChangeMotion("Rectangle4", 0, 100, 20, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle4\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n\n"
        + "Shape Rectangle4 changes color from (100, 100, 100) to (20, 20, 20) from t=0 to t=100\n"
        + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",model.getState());
  }


  @Test
  public void rectangleChangeColor1() {
    model.addShape("Rectangle5", ShapeType.RECTANGLE, 0, 1,5, 5, 20, 10, 100, 100, 100);
    model.addColorChangeMotion("Rectangle5", 20, 21, 20, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle5\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=0\n"
        + "Disappears at t=1\n\n"
        + "Shape Rectangle5 changes color from (100, 100, 100) to (20, 20, 20) from t=20 to t=21\n",model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleOverlapMoves() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 0, 19, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle6", 0, 20, 20, 20);
    model.addMoveMotion("Rectangle6", 10, 30, 20, 20);
  }

  @Test
  public void rectangleMoves() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 74, 77,5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle6", 0, 20, 20, 20);
    model.addMoveMotion("Rectangle6", 21, 40, 30, 30);
    model.addMoveMotion("Rectangle6", 41, 60, 5, 5);
    assertEquals("Shapes:\n"
        + "Name: Rectangle6\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=74\n"
        + "Disappears at t=77\n\n"
        + "Shape Rectangle4 moves from (5, 5) to (20, 20) from t=0 to t=20\n"
        + "Shape Rectangle4 moves from (30, 30) to (50, 20) from t=0 to t=20\n"
        + "Shape Rectangle4 moves from (20, 20) to (30, 30) from t=21 to t=40\n",model.getState());
  }

  @Test
  public void createTriangle1() {
    model.addShape("Triangle1", ShapeType.TRIANGLE, 13, 113,0, 0, 10, 10, 200, 100, 200);
    assertEquals("Shapes:\n"
        + "Name: Triangle1\n"
        + "Type: triangle\n"
        + "Corner: (0, 0), Width: 10, Height: 10, Color: (200, 100, 200)\n"
        + "Appears at t=13\n"
        + "Disappears at t=113\n\n", model.getState());
  }

  @Test
  public void createTriangle2() {
    model.addShape("Triangle2", ShapeType.TRIANGLE, 0, 44,17, 4, 5, 12, 0, 0, 20);
    assertEquals("Shapes:\n"
        + "Name: Triangle2\n"
        + "Type: triangle\n"
        + "Corner: (17, 4), Width: 5, Height: 12, Color: (0, 0, 20)\n"
        + "Appears at t=0\n"
        + "Disappears at t=44\n\n", model.getState());
  }

  @Test
  public void createEllipse1() {
    model.addShape("Ellipse1", ShapeType.ELLIPSE, 13, 17, 0, 0, 10, 10, 200, 100, 200);
    assertEquals("Shapes:\n"
        + "Name: Ellipse1\n"
        + "Type: Circle\n"  // ellipse?
        + "Center: (0, 0), Width: 10, Height: 10, Color: (200, 100, 200)\n"
        + "Appears at t=13\n"
        + "Disappears at t=17\n\n", model.getState());
  }

  @Test
  public void createEllipse2() {
    model.addShape("Ellipse2", ShapeType.ELLIPSE, 30, 40, 22, 32, 15, 27, 150, 32, 3);
    assertEquals("Shapes:\n"
        + "Name: Ellipse2\n"
        + "Type: Circle\n"  // ellipse?
        + "Center: (22, 32), Width: 15, Height: 27, Color: (150, 32, 3)\n"
        + "Appears at t=30\n"
        + "Disappears at t=40\n\n", model.getState());
  }

}