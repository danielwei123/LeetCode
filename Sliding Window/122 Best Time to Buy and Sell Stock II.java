// 122. Best Time to Buy and Sell Stock II

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length - 1; i++) {
            if (prices[i] > buyPrice && prices[i + 1] >= prices[i]) {
                continue;
            } else if (prices[i] > buyPrice && prices[i + 1] < prices[i]) {
                profit += prices[i] - buyPrice;
                buyPrice = prices[i + 1];
            } else {
                buyPrice = prices[i];
            }
        }
        
        profit += Math.max(prices[prices.length - 1] - buyPrice, 0);
        
        return profit;
    }
}