package delli;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    findMin(new int[] {4,5,6,7,0,1,2});
  }

  /**
   * By using binary search we are able to reduce the time complexity to O(log n)
   * The space complexity here would be O(m) where m is the number of call stacks
   * that we have to run
   * */
  public static int findMin(int[] nums) {
    if (nums.length < 4) {
      int min = nums[0];
      for (int i = 0; i < nums.length; i++) {
        min = Math.min(min, nums[i]);
      }
      return min;
    }

    int leftPtr = 0;
    int middlePtr = nums.length / 2;
    int rightPtr = nums.length - 1;

    if (nums[leftPtr] < nums[middlePtr] && nums[middlePtr] < nums[rightPtr]) { // ordered array
      return nums[leftPtr];
    }

    if (nums[leftPtr] >= nums[middlePtr]) { // search left
      return findMin(Arrays.copyOfRange(nums, leftPtr, middlePtr + 1));
    }
    else { // search right
      return findMin(Arrays.copyOfRange(nums, middlePtr, rightPtr + 1));
    }
  }

  // First attempt
  public static int findMin_01(int[] nums) {
    if (nums.length < 4) {
      int min = nums[0];
      for (int i = 0; i < nums.length; i++) {
        min = Math.min(min, nums[i]);
      }

      return min;
    }

    int leftPtr = 0;
    int middlePtr = nums.length / 2;
    int rightPtr = nums.length - 1;

    if (nums[leftPtr] < nums[middlePtr] && nums[middlePtr] < nums[rightPtr]) { // left sub
      return nums[leftPtr];
    }

    if (nums[leftPtr] > nums[middlePtr] && nums[middlePtr] < nums[rightPtr]) { // inner sub
      return findMin(Arrays.copyOfRange(nums, leftPtr + 1, middlePtr));
    }

    if (nums[leftPtr] < nums[middlePtr] && nums[middlePtr] > nums[rightPtr]) { // outer sub
      // int[] newArr = Arrays.copyOfRange(nums, middlePtr - 1, rightPtr);
      // newArr[0] = nums[leftPtr];
      // return findMin(newArr);
      return findMin(Arrays.copyOfRange(nums, middlePtr, rightPtr));
      // return findMin(Arrays.addAll(nums[leftPtr], Arrays.copyOfRange(nums, middlePtr, rightPtr)));
    }

    if (nums[leftPtr] < nums[middlePtr] && nums[middlePtr] < nums[rightPtr]) { // right sub
      return findMin(Arrays.copyOfRange(nums, middlePtr, rightPtr));
    }

    return nums[0];
  }
}
