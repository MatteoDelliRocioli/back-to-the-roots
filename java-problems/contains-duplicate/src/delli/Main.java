package delli;

import java.util.HashSet;

public class Main {

  public static void main(String[] args) {
    int[] input = new int[] {1,2,3,4,5,2};

    solve(input);
  }

  public static boolean solve(int[] nums) {

    // time complexity: O(n^2)
    // space complexity: O(1)
//     for (int i = 0; i < nums.length; i++) {
//         for (int z = 0; z < nums.length; z++) {
//             if (nums[i] == nums[z] && i != z) {
//                 return true;
//             }
//         }
//     }

//     return false;

    // time complexity: O(n)
    // space complexity: O(n)
    HashSet<Integer> mySet = new HashSet<>();

    for (int i = 0; i < nums.length; i++) {
      if (!mySet.contains(nums[i])) {
        mySet.add(nums[i]);
      }
      else {
        return true;
      }
    }
    return false;
  }
}
