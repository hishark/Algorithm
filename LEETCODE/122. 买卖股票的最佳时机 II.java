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

// ↑。。你可真是暴力小公主
// 贪心
// ref：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
class Solution {
    public int maxProfit(int[] prices) {
        // 最大利润
        int maxprofit = 0;
        // 总共的天数
        int days = prices.length;
        // 遍历每一天的价格
        for (int i = 1; i < days; i++) {
            // 如果当天的价格比前一天更高，说明可以带来更大的价值，就加到结果里去
            maxprofit += Math.max(0, prices[i] - prices[i - 1]);
        }
        // 返回最大利润
        return maxprofit;
    }
}

// 动态规划
class Solution {
    public int maxProfit(int[] prices) {
        // 总共的天数
        int n = prices.length;

        // 状态数组
        // 每天交易结束后只可能存在手里有一支股票或者没有股票的状态
        // dp[i][0] 表示第 i 天后交易完手里没有股票的最大利润
        // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
        // i 从 0 开始
        int[][] dp = new int[n][2];

        // 边界值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        // 遍历剩下的价格
        for (int i = 1; i < n; ++i) {
            // 【前一天手里没股票的最大利润，前一天手里有股票然后今天卖掉的总利润】二者取较大值即为【今天手里没股票的最大利润】
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 【前一天手里有股票今天没卖的利润，前一天手里没股票今天买了一只股票的利润】二者取较大值即为【今天手里有股票的最大利润】
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 最后返回最后一天的利润即可
        // dp[n-1][0] 肯定是要比 dp[n-1][1] 更大的，手里压着一个股票没卖出去肯定钱更少嘛
        return dp[n - 1][0];
    }
}