package delli;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  /**
   * Link to the leetcode problem:
   * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
   *
   * First brute force approach: take the rightest element and iterate from
   * right to left updating the greatest profit
   * At the end of the iterations we should have the highest profit
   * If no profit then print 0 (zero)
   * */
  public static void main(String[] args) {
  // write your code here
//    int[] prices = {7,1,5,3,6,4};
    int[] prices = {7,6,4,3,1};

//    maxProfit_BruteForce(prices);
    int result = maxProfitFinal(prices);

    System.out.println(result);
  }

  public static int maxProfit_BruteForce(int[] prices) {

    //Map<Integer, Integer, Integer> test = new ConcurrentHashMap<>();
    int maxProfit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      for (int z = i - 1; z >= 0; z--) {
        int currentProfit = prices[i] - prices[z];
        System.out.println(String.format("z+i = %d (profit = %d)", z+i, currentProfit));
        if (currentProfit > maxProfit) {
          maxProfit = currentProfit;
        }
      }
    }

    return maxProfit;
  }

  /**
   * Linear time complexity
   * Constant space complexity
   * */
  public static int maxProfitFinal(int[] prices) {

    int lowestPrice = prices[0];
    int maxProfit = 0;
    int currentProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < lowestPrice) {
        lowestPrice = prices[i];
      }

      currentProfit = prices[i] - lowestPrice;
      if (currentProfit > maxProfit) {
        maxProfit = currentProfit;
      }
    }

    return maxProfit;
  }
}
