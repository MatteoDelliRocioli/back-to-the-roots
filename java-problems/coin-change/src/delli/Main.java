package delli;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  /**
   * https://leetcode.com/problems/coin-change/
   * */
  public static void main(String[] args) {
  }

  /**
   * Greedy approach, failing approach
   * */
//  public int coinChange(int[] coins, int amount) { //amount = 0, [1]
//    if (amount == 0) {
//      return 0;
//    }
//
//    List<Integer> coinsList = new ArrayList<>();
//
//    for (int i = 0; i < coins.length; i++) {
//      coinsList.add(coins[i]);
//    }
//
//    Collections.sort(coinsList, Collections.reverseOrder());
//
//    int i = 0;
//    int sum = 0;
//    while (amount >= 0 && i < coinsList.size()) {
//      sum += amount / coinsList.get(i);
//      amount %= coinsList.get(i);
//      i++;
//    }
//
//    if (amount > 0) {
//      return -1;
//    }
//
//    return sum;
//  }
}
