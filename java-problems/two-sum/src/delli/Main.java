package delli;

import java.util.HashMap;
import java.util.HashSet;

public class Main {

  /**
   * https://leetcode.com/problems/two-sum/
   * */
  public static void main(String[] args) {
    int target = 9;
    int[] input = {2,7,11,15};
  }

  public static int[] solveNaive(int target, int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int z = i + 1; z < nums.length; z++) {
        if (nums[i] + nums[z] == target) {
          return new int[] {i, z};
        }
      }
    }

    return new int[] {};
  }

  public static int[] solve(int target, int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    map.put(nums[0], 0);

    for (int i = 1; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }

    return new int[] {};
  }
}
