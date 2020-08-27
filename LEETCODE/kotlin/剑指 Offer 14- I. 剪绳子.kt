// ref: lcof
//dp
class Solution {
    fun cuttingRope(n: Int): Int {
        // 边界值
        if (n < 2)
            return 0
        else if (n == 2)
            return 1
        else if (n == 3)
            return 2

        // 状态数组
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 0
        dp[2] = 2
        dp[3] = 3

        // 状态转移方程
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        // dp[n] = max(dp[j] * dp[n-j]) 其中j的范围为：[1,n-1]
        for (i in 4..n) {
            // 当前绳子长度为i
            // 乘积的最大值↓
            var maxValue = 0

            // j从1开始是因为剪一刀子下去长度最少为1
            // j最大为i因为当前绳子的长度为i
            // 这里的循环条件可以改为j<=i/2，因为i/2之后算出来的就是重复的乘积了，当n特别特别大的时候，只算到i/2可以节省时间
            for (j in 1..i) {
                // 当前乘积
                val product = dp[j] * dp[i - j]
                if (product > maxValue)
                    maxValue = product
            }
            // 把最大值存入dp数组
            dp[i] = maxValue
        }

        // 返回结果
        return dp[n]
    }
}