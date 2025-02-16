class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy=prices[0];
        int max = 0;
for(int i = 1 ; i<prices.length;i++){
    profit = prices[i]-buy;
buy = Math.min(prices[i],buy);
max = Math.max(profit,max);

}
   return max;
    }
}



    /* for(int i = 0 ; i<prices.length;i++){
            for(int j = i+1; j <prices.length;j++){
profit = prices[j]-prices[i];
max = Math.max(max,profit);
            }
        }
        return max;
*/