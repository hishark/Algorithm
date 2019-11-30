//一直暴力一直爽 然后就超出时间限制了哈哈哈哈艹.jpg
//明天再来贪心 看电影去886
class Solution {
    public int maxProfit(int[] prices) {
        //获得从第1天到最后一天的最大利润
        return getMaxProfit(prices, 0);
    }
    
    public int getMaxProfit(int[] prices, int start){
        //越界返回0
        if(start>=prices.length){
            return 0;
        }
        //初始化最大利润为0
        int maxProfit = 0;
       
        //遍历0到prices.length-1
        for(int s = start;s<prices.length;s++){            
            //遍历s+1到prices.length-1
            for(int i=s+1;i<prices.length;i++){
                //仅当当日股票价格比买入股票价格贵时，才叠加利润
                if(prices[s] < prices[i]){
                    //第i天的最大利润 = 第i+1天的最大利润 + 第i天的利润
                    //第i天的利润 = 第i天的股票价格 - 股票的买入价格
                    int profit = getMaxProfit(prices, i+1) + prices[i] - prices[s];
                    
                    //更新最大利润
                    if(profit > maxProfit){
                        maxProfit = profit;
                    }
                }
            }
        }
        return maxProfit;
    }
}
