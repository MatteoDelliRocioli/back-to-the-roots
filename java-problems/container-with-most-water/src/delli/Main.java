package delli;

public class Main {

  /**
   * https://leetcode.com/problems/container-with-most-water/submissions/
   * */
  public static void main(String[] args) {
    bruteForceSolve(new int[] {1,8,6,2,5,4,8,3,7});
  }

  /**
   * By using this approach we certainly can find the container with most water
   * but it's not efficient at all since we are iterating the input array n times
   * where n is the length of the input
   *
   * time complexity: O(n^2)
   * space complexity: O(n)
   * */
  public static int bruteForceSolve(int[] height) {
    int result = 0;
    int upper = height.length;
    int lower = 0;

    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        int distance = j - i;

        if (distance < 1) {
          continue;
        }
        // System.out.println("i: " + i + ", j: " + j);
        int minHeight = Math.min(height[i], height[j]);

        int temp = minHeight * distance;

        result = Math.max(temp, result);
      }
    }

    return result;
  }
}
