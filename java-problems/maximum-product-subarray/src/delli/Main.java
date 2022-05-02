package delli;

public class Main {

  /**
   * https://leetcode.com/problems/maximum-product-subarray/
   *
   * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
   *
   * The test cases are generated so that the answer will fit in a 32-bit integer.
   *
   * A subarray is a contiguous subsequence of the array.
   *
   *
   *
   * Example 1:
   *
   * Input: nums = [2,3,-2,4]
   * Output: 6
   * Explanation: [2,3] has the largest product 6.
   * Example 2:
   *
   * Input: nums = [-2,0,-1]
   * Output: 0
   * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
   *
   *
   * Constraints:
   *
   * 1 <= nums.length <= 2 * 104
   * -10 <= nums[i] <= 10
   * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
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
