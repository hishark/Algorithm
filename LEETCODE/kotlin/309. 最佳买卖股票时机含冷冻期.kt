class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 0)
            return 0

        // 总天数
        val n = prices.size

        // 状态数组
        // max(dp[i][0], dp[i][1], dp[i][2])表示第i天结束之后的累计最大收益
        val dp = Array(n) { IntArray(3) }

        // 边界值
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        dp[0][2] = 0

        // 状态转移方程
        for (i in 1 until n) {
            // 目前持有一支股票
            // 这支股票可能是前一天持有的 dp[i-1][0]
            // 也可能是今天刚买的，那么前一天一定不处于冷冻期 dp[i-1][2] - prices[i]
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i])

            // 目前没股票，在冷冻期
            // 在冷冻期说明当日卖出了一支股票，所以前一天一定有一支股票
            dp[i][1] = dp[i - 1][0] + prices[i]

            // 目前没股票，也不在冷冻期
            // 说明当日即没有买也没有卖，啥也没干，那么前一天什么状态都有可能
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]))
        }

        // 最后一天手里还有股票也没啥意思了，所以只要取dp[n - 1][1]和dp[n - 1][2]里的较大值就可以了
        return Math.max(dp[n - 1][1], dp[n - 1][2])
    }
}
