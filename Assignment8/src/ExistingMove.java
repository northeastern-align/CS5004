public class ExistingMove {

  public static boolean validMove(IMotion shape, int t1, int t2) {
    if (t1 >= shape.getStartTime() && t1 < shape.getEndTime()) {
      return false;
    }

    if (t1 < shape.getStartTime() && t2 > shape.getStartTime()) {
      return false;
    }
    return true;
  }
}