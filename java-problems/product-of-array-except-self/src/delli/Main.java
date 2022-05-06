package delli;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    int[] result = productExceptSelf(new int[] {1,2,3,4});

    System.out.println(Arrays.toString(result));
  }

  /**
   * Naive method
   * Saving all the products from left to right and all the products form right
   * to left allows to use dynamic programming knowing at each point what is the
   * product af all elements before the current one and the product of all elements
   * after the current one.
   *
   * The time complexity is O(3n) -> O(n)
   * the space complexity is O(3n) -> O(n)
   * */
  public static int[] productExceptSelf(int[] nums) {
    Map<String, Integer> products = new HashMap<>();
    Map<String, Integer> productsRev = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    // Store products from left to right
    products.put(String.format("%d,%d", 0, 0), nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (products.containsKey(String.format("%d,%d", 0, i - 1))) {
        int prevProduct = products.get(String.format("%d,%d", 0, i - 1));
        products.put(String.format("%d,%d", 0, i), prevProduct * nums[i]);
      }
    }

    // Store products from right to left
    int size = nums.length - 1;
    productsRev.put(String.format("%d,%d", nums.length - 1, nums.length - 1), nums[nums.length - 1]);
    for (int i = nums.length - 2; i >= 0; i--) {
      if (productsRev.containsKey(String.format("%d,%d", size, nums.length - 1))) {
        int afterProduct = productsRev.get(String.format("%d,%d", size--, nums.length - 1));
        productsRev.put(String.format("%d,%d", i, nums.length - 1), afterProduct * nums[i]);
      }
    }

    // Build result
    for (int i = 0; i < nums.length; i++) {
      int prevProduct = i == 0 ? 1 : products.get(String.format("%d,%d", 0, i - 1));
      int afterProduct = i == nums.length - 1 ? 1 : productsRev.get(String.format("%d,%d", i + 1, nums.length - 1));
      result.add(prevProduct * afterProduct);
    }

    return result.stream().mapToInt(i->i).toArray();
  }
}
