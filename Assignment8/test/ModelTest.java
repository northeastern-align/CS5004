import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for Model.
 */
public class ModelTest {

  private IAnimationModel model;

  @Before
  public void setup() {
    model = new AnimationModel();
  }

  @Test
  public void createRectangle1() {
    model.addShape("Rectangle1", ShapeType.RECTANGLE, 0, 100, 0, 0, 10, 10, 200, 100, 200);
    assertEquals("Shapes:\n"
        + "Name: Rectangle1\n"
        + "Type: rectangle\n"
        + "Corner: (0, 0), Width: 10, Height: 10, Color: (200, 100, 200)\n"
        + "Appears at t=0\n"
        + "Disappears at t=100\n\n", model.getState());
  }

  @Test
  public void createRectangle2() {
    model.addShape("Rectangle2", ShapeType.RECTANGLE, 10, 11, 10, 3, 5, 13, 41, 62, 73);
    assertEquals("Shapes:\n"
        + "Name: Rectangle2\n"
        + "Type: rectangle\n"
        + "Corner: (10, 3), Width: 5, Height: 13, Color: (41, 62, 73)\n"
        + "Appears at t=10\n"
        + "Disappears at t=11\n\n", model.getState());
  }

  @Test
  public void rectangleMove1() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE, 0, 75, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle3", 3, 17, 20, 20);
    assertEquals("Shapes:\n"
        + "Name: Rectangle3\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=0\n"
        + "Disappears at t=75\n\n"
        + "Shape Rectangle3 moves from (5, 5) to (20, 20) from t=3 to t=17\n", model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove1() {
    model.addShape("Rectangle3", ShapeType.RECTANGLE, 13, 77, 5, 5, 20, 10, 100, 100, 100);
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
            + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",
        model.getState());
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
            + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",
        model.getState());
  }

  @Test
  public void rectangleResize3() {
    model.addShape("Rectangle4", ShapeType.RECTANGLE, 0, 100, 5, 5, 20, 10, 100, 100, 100);
    model.addScaleMotion("Rectangle4", 0, 100, 20, 20);
    model.addColorChangeMotion("Rectangle4", 0, 100, 20, 20, 20);
    assertEquals("Shapes:\n"
            + "Name: Rectangle4\n"
            + "Type: rectangle\n"
            + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
            + "Appears at t=0\n"
            + "Disappears at t=100\n\n"
            + "Shape Rectangle4 changes color from (100, 100, 100) to (20, 20, 20) from t=0 to t=100\n"
            + "Shape Rectangle4 scales from (20, 10) to (20, 20) from t=0 to t=100\n",
        model.getState());
  }


  @Test
  public void rectangleChangeColor1() {
    model.addShape("Rectangle5", ShapeType.RECTANGLE, 0, 1, 5, 5, 20, 10, 100, 100, 100);
    model.addColorChangeMotion("Rectangle5", 20, 21, 20, 20, 20);
    assertEquals("Shapes:\n"
            + "Name: Rectangle5\n"
            + "Type: rectangle\n"
            + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
            + "Appears at t=0\n"
            + "Disappears at t=1\n\n"
            + "Shape Rectangle5 changes color from (100, 100, 100) to (20, 20, 20) from t=20 to t=21\n",
        model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleOverlapMoves() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 0, 19, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle6", 0, 20, 20, 20);
    model.addMoveMotion("Rectangle6", 10, 30, 20, 20);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleOverlapColorChange() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 0, 19, 5, 5, 20, 10, 100, 100, 100);
    model.addColorChangeMotion("Rectangle6", 0, 20, 20, 20, 20);
    model.addColorChangeMotion("Rectangle6", 10, 30, 30, 30, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleOverlapScaleChange() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 0, 19, 5, 5, 20, 10, 100, 100, 100);
    model.addScaleMotion("Rectangle6", 0, 20, 20, 20);
    model.addScaleMotion("Rectangle6", 10, 30, 30, 30);
  }

  @Test
  public void rectangleMoves() {
    model.addShape("Rectangle6", ShapeType.RECTANGLE, 74, 77, 5, 5, 20, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle6", 0, 20, 20, 20);
    model.addMoveMotion("Rectangle6", 41, 60, 5, 5);
    model.addMoveMotion("Rectangle6", 21, 40, 30, 30);
    assertEquals("Shapes:\n"
        + "Name: Rectangle6\n"
        + "Type: rectangle\n"
        + "Corner: (5, 5), Width: 20, Height: 10, Color: (100, 100, 100)\n"
        + "Appears at t=74\n"
        + "Disappears at t=77\n\n"
        + "Shape Rectangle6 moves from (5, 5) to (20, 20) from t=0 to t=20\n"
        + "Shape Rectangle6 moves from (20, 20) to (30, 30) from t=21 to t=40\n"
        + "Shape Rectangle6 moves from (30, 30) to (5, 5) from t=41 to t=60\n", model.getState());
  }

  @Test
  public void rectangleMultipleAnimations() {
    model.addShape("Rectangle7", ShapeType.RECTANGLE, 0, 100, 10, 10, 10, 10, 100, 100, 100);
    model.addMoveMotion("Rectangle7", 0, 80, 20, 20);
    model.addColorChangeMotion("Rectangle7", 0, 80, 255, 0, 255);
    model.addScaleMotion("Rectangle7", 0, 80, 20, 20);
    model.addMoveMotion("Rectangle7", 81, 100, 10, 10);
    model.addColorChangeMotion("Rectangle7", 81, 100, 0, 0, 255);
    model.addScaleMotion("Rectangle7", 81, 100, 20, 10);
    assertEquals("Shapes:\n"
            + "Name: Rectangle7\n"
            + "Type: rectangle\n"
            + "Corner: (10, 10), Width: 10, Height: 10, Color: (100, 100, 100)\n"
            + "Appears at t=0\n"
            + "Disappears at t=100\n"
            + "\n"
            + "Shape Rectangle7 changes color from (100, 100, 100) to (255, 0, 255) from t=0 to t=80\n"
            + "Shape Rectangle7 moves from (10, 10) to (20, 20) from t=0 to t=80\n"
            + "Shape Rectangle7 scales from (10, 10) to (20, 20) from t=0 to t=80\n"
            + "Shape Rectangle7 changes color from (255, 0, 255) to (0, 0, 255) from t=81 to t=100\n"
            + "Shape Rectangle7 moves from (20, 20) to (10, 10) from t=81 to t=100\n"
            + "Shape Rectangle7 scales from (20, 20) to (20, 10) from t=81 to t=100\n",
        model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalTime1() {
    model.addShape("Rectangle8", ShapeType.RECTANGLE, 0, 20, 10, 10, 10, 10, 10, 10, 10);
    model.addMoveMotion("Rectangle8", 10, 21, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalTime2() {
    model.addShape("Rectangle8", ShapeType.RECTANGLE, 10, 20, 10, 10, 10, 10, 10, 10, 10);
    model.addMoveMotion("Rectangle8", 5, 15, 5, 5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMove() {
    model.addShape("Rectangle8", ShapeType.RECTANGLE, 0, 20, 10, 10, 10, 10, 10, 10, 10);
    model.addMoveMotion("Rectangle8", 5, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation1() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, -5, 20, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation2() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 4, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation3() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 0, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation4() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 10, 0, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation5() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 10, 10, -1, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation6() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 10, 10, 0, 256, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalCreation7() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 10, 10, 0, 255, 256);
  }

  @Test(expected = IllegalArgumentException.class)
  public void rectangleIllegalMotion() {
    model.addShape("Rectangle9", ShapeType.RECTANGLE, 5, 10, 10, 10, 10, 10, 0, 255, 255);
    model.addMoveMotion("Rectangle9", 6, 5, 20, 20);
  }

  @Test
  public void createTriangle1() {
    model.addShape("Triangle1", ShapeType.TRIANGLE, 13, 113, 0, 0, 10, 10, 200, 100, 200);
    assertEquals("Shapes:\n"
        + "Name: Triangle1\n"
        + "Type: triangle\n"
        + "Corner: (0, 0), Width: 10, Height: 10, Color: (200, 100, 200)\n"
        + "Appears at t=13\n"
        + "Disappears at t=113\n\n", model.getState());
  }

  @Test
  public void createTriangle2() {
    model.addShape("Triangle2", ShapeType.TRIANGLE, 0, 44, 17, 4, 5, 12, 0, 0, 20);
    assertEquals("Shapes:\n"
        + "Name: Triangle2\n"
        + "Type: triangle\n"
        + "Corner: (17, 4), Width: 5, Height: 12, Color: (0, 0, 20)\n"
        + "Appears at t=0\n"
        + "Disappears at t=44\n\n", model.getState());
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation1() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, -5, 20, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation2() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 4, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation3() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 10, 10, 10, 0, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation4() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 10, 10, 10, 10, 0, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation5() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 10, 10, 10, 10, 10, -1, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation6() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 10, 10, 10, 10, 10, 0, 256, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void triangleIllegalCreation7() {
    model.addShape("Triangle3", ShapeType.TRIANGLE, 5, 10, 10, 10, 10, 10, 0, 255, 256);
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

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation1() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, -5, 20, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation2() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 4, 10, 10, 10, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation3() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 10, 10, 10, 0, 10, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation4() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 10, 10, 10, 10, 0, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation5() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 10, 10, 10, 10, 10, -1, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation6() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 10, 10, 10, 10, 10, 0, 256, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void ellipseIllegalCreation7() {
    model.addShape("Ellipse3", ShapeType.ELLIPSE, 5, 10, 10, 10, 10, 10, 0, 255, 256);
  }

}