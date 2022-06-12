package delli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  /**
   * https://leetcode.com/problems/coin-change/
   * */
  public static void main(String[] args) {
    Main main = new Main();
    main.coinChange(new int[] {1,2,5}, 11);
  }

  public int coinChange(int[] coins, int amount) {
    // starting from 0 we try to see what's the minimum viable solution
    // for each new number till we reach our amount
    // that's the bottom up approach

    // so for 1 we check if there is any coin lower than that to try to subtract it
    // to our amount, if yes and the remaining minus the value of dp at the remaining position
    // is zero then compare the result with the minimum at current dp position

    // we have to take into account the map with results
    // the coins we are going to use for each position in dp

    //first we create dp and fill it with max values, since the coins are positive integers
    // we cannot have less than 1 in coin value thus the max will be amount + 1

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    // 2 nested loops since we are going to check each coin for each dp position
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    return dp[amount] > amount ? -1 : dp[amount];
  }
  
  /**
   * Brute force approach, TLE but correct approach
   * I'm using recursion in order to check all the possible paths to count the number
   * of coins we would need to make up the provided amount
   *
   * time complexity: is proportional to the number of coins in the exponential way O(S^n) where S 
   *    is the amount and n is the number of coins
   * space complexity: O(n) where n is the max height of the recursion stack call
   */
//  public int coinChange(int[] coins, int amount) {
//    //for each amount we call the same funciton looking for a zero
//    // if more than zero we call the function again
//    // if less than zero it means that we do not consider that path
//
//    if (amount == 0) return 0;
//
//    helper(amount, coins, 0);
//
//    return result == Integer.MAX_VALUE ? -1: result;
//  }
//
//  public void helper(int amount, int[] coins, int counter) {
//
//    for(int i = 0; i < coins.length; i++) {
//      int tmp = amount - coins[i];
//
//      if (tmp < 0) {
//        continue;
//      }
//
//      if (tmp == 0) {
//        // check result
//        result = Math.min(result, counter + 1);
//
//      }
//
//      if (tmp > 0) {
//        //recursion calling checking for the remaining amount
//        helper(tmp, coins, counter + 1);
//      }
//    }
//  }

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
  
  /**
   * Top-down recursive approach (DP)
   */
  /*
  public class Solution {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    return coinChange(coins, amount, new int[amount]);
  }

  private int coinChange(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min)
        min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }
}
  */
}
