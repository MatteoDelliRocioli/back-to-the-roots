package delli;

public class Main {

  /**
   * https://leetcode.com/problems/container-with-most-water/submissions/
   * */
  public static void main(String[] args) {
//    bruteForceSolve(new int[] {1,8,6,2,5,4,8,3,7});
    maxArea(new int[] {1,8,6,2,5,4,8,3,7});
  }

  /**
   * That approach involves the use of two pointers where we keep track of the
   * leftest element and rightest element and update those pointers according to
   * the values of height at those pointers. The pointers are going to move one
   * towards the other till they overlap or meet at the middle.
   *
   * The updated pointer will always be the pointer where the height is the lowest
   * because given the fact that the area is the product of the distance between
   * two pointers and the lowest of the heights at the two pointers, maintaining
   * the lower height would mean that other than decreasing the distance there is
   * no chance of increasing the area whereas moving this pointer could lead to
   * encountering a new higher height (which could lead to a higher area as well)
   *
   * We are iterating the elements of the input only once so the
   * time complexity: O(n)
   * space complexity: O(1) since we are only using single valued variables
   * */
  public static int maxArea(int[] height) {
    int result = 0;
    int lowPtr = 0, hiPtr = height.length - 1;

    while (lowPtr < hiPtr) {
      int distance = hiPtr - lowPtr;

      int area = distance * Math.min(height[hiPtr], height[lowPtr]);

      result = Math.max(area, result);

      //update the pointers
      if (height[lowPtr] > height[hiPtr]) {
        hiPtr--;
      }
      else {
        lowPtr++;
      }
    }
    return result;
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
