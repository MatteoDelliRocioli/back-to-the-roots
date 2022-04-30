package delli;

public class Main {

  /**
   * https://leetcode.com/problems/robot-bounded-in-circle/submissions/
   * */
  public static void main(String[] args) {
    Main main = new Main();

//    String instructions = "GGLLGG";
    String instructions = "GLRLLGLL";
    boolean result = main.isRobotBounded(instructions);

    System.out.println(result);
  }

  public boolean isRobotBounded(String instructions) {
    Robot robot = new Robot();

    for (int i = 0; i < instructions.length(); i++) {
      char current = instructions.charAt(i);

      switch(current) {
        case 'G':
          move(robot);
          break;
        case 'L':
          changeDir(robot, true);
          break;
        case 'R':
          changeDir(robot, false);
          break;
        default:
          break;
      }
    }

    if(robot.x == 0 && robot.y == 0) {
      return true;
    }
    else if(robot.dir != Direction.NORTH){
      return true;
    }

    return false;
  }

  public static void move(Robot robot) {
    switch(robot.dir) {
      case NORTH:
        robot.y++;
        break;
      case WEST:
        robot.x--;
        break;
      case EAST:
        robot.x++;
        break;
      case SOUTH:
        robot.y--;
        break;
      default:
        break;
    }
  }

  public static void changeDir(Robot robot, boolean goLeft) {

    if(goLeft) {
      switch(robot.dir) {
        case NORTH:
          robot.dir = Direction.WEST;
          break;
        case WEST:
          robot.dir = Direction.SOUTH;
          break;
        case SOUTH:
          robot.dir = Direction.EAST;
          break;
        case EAST:
          robot.dir = Direction.NORTH;
          break;
      }
    }
    else {
      switch(robot.dir) {
        case NORTH:
          robot.dir = Direction.EAST;
          break;
        case EAST:
          robot.dir = Direction.SOUTH;
          break;
        case SOUTH:
          robot.dir = Direction.WEST;
          break;
        case WEST:
          robot.dir = Direction.NORTH;
          break;
      }
    }
  }

  class Robot {
    int x = 0;
    int y = 0;

    Direction dir = Direction.NORTH;
  }

  enum Direction {
    NORTH,
    WEST,
    EAST,
    SOUTH
  }
}
