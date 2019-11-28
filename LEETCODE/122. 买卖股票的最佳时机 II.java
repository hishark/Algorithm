//一直暴力一直爽 然后就超出时间限制了哈哈哈哈艹.jpg
//明天再来贪心 看电影去886
class Solution {
    public int maxProfit(int[] prices) {
        //获得从0开始的最大利润
        return getMaxProfit(prices, 0);
    }
    
    public int getMaxProfit(int[] prices, int start){
        if(start>=prices.length){
            return 0;
        }
        int maxProfit = 0;
        for(int s = start;s<prices.length;s++){
            int curMaxProfit = 0;
            for(int i=s+1;i<prices.length;i++){
                if(prices[s] < prices[i]){
                    int profit = getMaxProfit(prices, i+1) + prices[i] - prices[s];
                    if(profit > curMaxProfit){
                        curMaxProfit = profit;
                    }
                }
                if(curMaxProfit > maxProfit){
                    maxProfit = curMaxProfit;
                }
            }
        }
        return maxProfit;
    }
}
