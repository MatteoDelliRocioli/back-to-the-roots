package delli;

public class Main {

  public static void main(String[] args) {
  }

  /**
   * https://leetcode.com/problems/counting-bits/
   *
   *  time complexity: O(n^2) because for each number we are going to re-do the same process of
   *    countinh the bits
   *  space complexity: O(n) since we are only using an array of size n+1
   * */
  public int[] countBits(int n) {
    int[] res = new int[n+1];

    for (int i = 0; i <= n; i++) {
      int result = i;
      int count = 0;

      while (result >= 1) {
        if (result % 2 > 0) {
          count++;
        }

        result = result / 2;
      }

      res[i] = count;
    }

    return res;

    /**
     * time complexity: O(n^2) since for each number in the sequence from 1 to n
     *    we have to loop those numbers in order to build res[i]
     * space complexity: O(n) where n is the size of res[] -> n+1
     * */
//    int[] res = new int[n + 1];
//    res[0] = 0;
//
//    for (int i = 1; i < res.length; i++) {
//      res[i] = helper(i);
//    }
//    return res;
  }

//  public int helper(int n) {
//    int sum = 0;
//    while (n>=0) {
//      sum += n%2;
//      n /= 2;
//
//      if (n == 0) {
//        n--;
//      }
//    }
//    return sum;
//  }
}
