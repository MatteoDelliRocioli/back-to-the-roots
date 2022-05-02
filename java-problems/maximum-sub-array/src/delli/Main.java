package delli;

public class Main {

  /**
   * https://leetcode.com/problems/maximum-subarray/
   * */
  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[] {-3, -4}));
  }

  // Kadane's algorithm
  // We take note only of sums of subarrays that are positive
  // Once the sum is negative, reset to 0 (zero)
  // If the current element is greater than the max, re-assign max
  public static int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;
    int currentMax = 0;

    for (int i = 0; i < nums.length; i++) {
      currentMax += nums[i];

      if (nums[i] > max) {
        max = nums[i];
      }

      if (currentMax < 0) {
        currentMax = 0;
        continue;
      }

      max = Math.max(currentMax, max);
    }

    return max;
  }

  // Bruteforce solution, TLE
  // time complexity: O(n^2) -> two nested for loops
  // space complexity: O(1) -> only few variables with single updating value
  public static int maxProduct_bruteForce(int[] nums) {
    int maxProduct = nums[0];
    for (int i = 0; i < nums.length; i++) {
      int tempProduct = nums[i];

      // System.out.println("tempProduct_before: " + tempProduct);
      for (int x = i + 1; x < nums.length; x++) {
        tempProduct *= nums[x];

        // System.out.println("nums[x]: " + nums[x]);
        // System.out.println("tempProduct: " + tempProduct);

        if (tempProduct > maxProduct) {
          maxProduct = tempProduct;
        }
      }

      if (nums[i] > maxProduct) {
        maxProduct = nums[i];
      }
    }

    return maxProduct;
  }
}
