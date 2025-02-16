class Solution {
    public int maxProfit(int[] prices) {
        // idea: find all increment segments, add diff to profit
        int profit = 0;
        for (int index = 0; index < prices.length - 1; index++) {
            if (prices[index] < prices[index + 1]) {
                profit = profit + prices[index + 1] - prices[index];
            }
        }
        
        return profit;
    }

}