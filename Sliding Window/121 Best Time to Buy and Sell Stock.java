// 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;  // least so far
        int profit_if_sold_today = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
          lsf = Math.min(lsf, prices[i]);
          profit_if_sold_today = prices[i] - lsf;
          maxProfit = Math.max(maxProfit, profit_if_sold_today);
        }

        return maxProfit;
    }
}