package delli;

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
    int[] prices = {7,1,5,3,6,4};
//    int[] prices = {7,6,4,3,1};

    maxProfit(prices);
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;
    for (int i = prices.length - 1; i >= 0; i--) {
      for (int z = i - 1; z >= 0; z--) {
        int currentProfit = prices[i] - prices[z];
        if (currentProfit > maxProfit) {
          maxProfit = currentProfit;
        }
      }
    }

    return maxProfit;
  }
}
