package delli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    threeSum(new int[] {[-2,0,1,1,2]});
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums.length == 0) {
      return result;
    }

    // Sort the array to make use of the two pointers technique
    // For this operation using Arrays.sort() ->
    // time complexity: O(n log(n)) and space complexity O(1)
    Arrays.sort(nums);

    int prevFirst = nums[0];

    for (int i = 0; i < nums.length; i++) {
      // We use two pointers in order to keep searching for a valid triplet
      int left = i + 1;
      int right = nums.length - 1;
      int first = nums[i];

      if (first == prevFirst && i != 0) {
        prevFirst = first;
        continue;
      }

      while (left < right) {
        int leftVal = nums[left];
        int rightVal = nums[right];
        int sum = first + leftVal + rightVal;

        if (sum == 0) { // valid triplet found

          List<Integer> newTriplet = new ArrayList<>();
          // if (result.get(result.size() - 1).get(0))

          newTriplet.add(first);
          newTriplet.add(leftVal);
          newTriplet.add(rightVal);
          result.add(newTriplet);
          left++;
          right--;
        }
        else { // keep searching for triplets, update the pointers
          if (sum < 0) {
            // since the array is sorted, the right pointer already points to the highest value
            // so the only chance to increase the sum value is to move the left pointer to the
            // right, considering higher values

            while (left < right && leftVal == nums[left + 1]) {
              left++;
            }
            left++;
          }
          else {
            // we do the opposite here, moving the right towards lower values
            // hoping to find a match for a valid triplet

            while (right > i && rightVal == nums[right - 1]) {
              right--;
            }
            right--;
          }
        }
      }
    }

    return result;
  }
}
