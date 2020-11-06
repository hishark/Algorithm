// ref: https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/solution/mian-shi-ti-63-gu-piao-de-zui-da-li-run-dong-tai-2/
class Solution {
    public int maxProfit(int[] prices) {
        // 判空
        if (prices.length == 0)
            return 0;

        // 状态数组
        // dp[i] 表示以 prices[i] 结尾的子数组的最大利润（也就是前i天的最大利润）
        int[] dp = new int[prices.length];

        // 前几日的最低价格
        int minPrice = Integer.MAX_VALUE;
        // 股票的最大利润
        int maxProfit = 0;

        // 边界值
        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            // 遍历的同时更新股票的最低价格
            minPrice = Math.min(minPrice, prices[i]);
            // 当前最大利润为【前一天的最大利润】和【当日股价 - 前几日中的最低股价】中的较大者
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
            // 更新最大利润
            maxProfit = Math.max(dp[i], maxProfit);
        }

        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // 前几日的股票最低价格
        int minPrice = Integer.MAX_VALUE;
        // 股票的最大利润
        int maxProfit = 0;

        // 遍历股价
        for (int price : prices) {
            // 更新股票最低价格
            minPrice = Math.min(minPrice, price);
            // 更新最大利润，当前最大利润为【前一天的最大利润】和【当日股价 - 前几日中的最低股价】中的较大者
            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}