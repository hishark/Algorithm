class Solution {
    fun numWays(n: Int): Int {
        // dp
        // 状态数组
        val dp = IntArray(n + 1)

        // 边界值
        if (n == 0 || n == 1)
            return 1

        dp[0] = 1
        dp[1] = 1

        // 状态转移方程
        for (i in 2..n) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
        }

        return dp[n]
    }
}