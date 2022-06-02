package delli;

import java.util.ArrayList;
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
  
  /**
   * Brute force approach, TLE but correct approach
   * I'm using recursion in order to check all the possible paths to count the number
   * of coins we would need to make up the provided amount
   *
   * time complexity: is proportional to the number of coins in the exponential way O(S^n) where S 
   *    is the amount and n is the number of coins
   * space complexity: O(n) where n is the max height of the recursion stack call
   */
  public int coinChange(int[] coins, int amount) {
    //for each amount we call the same funciton looking for a zero
    // if more than zero we call the function again
    // if less than zero it means that we do not consider that path 
    
    if (amount == 0) return 0;
    
    helper(amount, coins, 0);
    
    return result == Integer.MAX_VALUE ? -1: result;
  }
  
  public void helper(int amount, int[] coins, int counter) {
    
    for(int i = 0; i < coins.length; i++) {
      int tmp = amount - coins[i];
      
      if (tmp < 0) {
        continue;
      }
      
      if (tmp == 0) {
        // check result
        result = Math.min(result, counter + 1);
        
      }
      
      if (tmp > 0) {
        //recursion calling checking for the remaining amount
        helper(tmp, coins, counter + 1);
      }
    }
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
