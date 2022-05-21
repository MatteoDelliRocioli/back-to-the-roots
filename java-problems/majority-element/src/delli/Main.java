package delli;

import java.util.HashMap;
import java.util.Map;

public class Main {

public static void main(String[] args) {
// write your code here
}

  /**
   * Bruteforce solution using a map,
   *
   * time complexity: O(n)
   * space complexity: O(n)
   * */
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int checkPoint = nums.length / 2;

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);

        if (map.get(nums[i]) > checkPoint) {
          return nums[i];
        }
      }
      else {
        map.put(nums[i], 1);
      }
    }

    return nums[0];
  }
}
