package delli;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.search(new int[] {4,5,6,7,0,1,2}, 1);
  }

  public int search(int[] nums, int target) {
    return helper(nums, 0, target);
  }

  /**
   * Using binary search and dynamic programming try to consider only half of the
   * array each time you are adding a call to the stack
   * time complexity: O(log n) -> because the input halves each time
   * space complexity: O(1) -> only single values variables are in memory
   * */
  public static int helper(int[] nums, int leftIndex, int target) {
    if (nums.length < 4) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          return leftIndex + i;
        }
      }
      return -1;
    }

    int lLeft = leftIndex;
    int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);

    int rLeft = nums.length / 2;
    int[] right = Arrays.copyOfRange(nums, rLeft, nums.length);

    int result = helper(left, lLeft, target);
    if (result == -1) {
      result = helper(right, rLeft + leftIndex, target);
    }

    return result;
  }
}
