package delli;

public class Main {

  public static void main(String[] args) {
    solve(new int[] {1,2,3,5,6,7,3,2,1});
  }

  /**
   * time complexity: O(n), we iterate the input at most once
   * space complexity: O(1), we only have a few variables storing one value
   */
  public static int solve(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int maxProfit = 0;
    int minPrice = 0;

    for (int i = 0; i < prices.length; i++) {
      if (i == 0) {
        minPrice = prices[i];
      }

      if (prices[i] < minPrice) {
        minPrice = prices[i];
        continue;
      }

      // int profit = prices[i] - minPrice;
      maxProfit = (prices[i] - minPrice) > maxProfit ? prices[i] - minPrice : maxProfit;
      // if ((prices[i] - minPrice) > maxProfit) {
      //     maxProfit = profit;
      // }
    }

    return maxProfit;
  }
}
