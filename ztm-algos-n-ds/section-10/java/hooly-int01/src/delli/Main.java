package delli;

import java.util.HashSet;

public class Main {

  /**
    The goal is to find a pair present in the array where the sum of
    those is equal to a provided amount

    data sets:

    [1, 2, 3, 9] Sum = 8 -> no
    [1, 2, 4, 4] Sum = 8 -> yes
  */

  private static boolean hasCoupleToSum(int[] arr1, int targetSum) {
    HashSet<Integer> seenElements = new HashSet<Integer>();
    for (int i = 0; i < arr1.length; i++) {
      seenElements.add(arr1[i]);
      int complement = targetSum - arr1[i];
      if (seenElements.contains(complement)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    /**
     * a naive approach would be to iterate the array n^2 times to compare each
     * element with the others, that is to find a couple that matches the
     * provided sum
     *
     * a more efficient approach would be to save the seen elements and look
     * into them when looking for the complement of the current element and
     * the provided sum
     * */

    int targetSum = 8;

    int[] arr1 = {1,2,3,9};
    int[] arr2 = {1,2,4,4};

    boolean result = false;
    result = hasCoupleToSum(arr2, targetSum);

    System.out.println(result);
  }
}
