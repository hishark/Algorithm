class Solution {
    fun climbStairs(n: Int): Int {
        if(n==0) return 0

        // 状态数组
        var dp = IntArray(n+1)

        // 临界值
        dp[0] = 1
        dp[1] = 1

        // 状态方程
        for (i in 2..n) {
            dp[i] = dp[i-1] + dp[i-2]
        }

        return dp[n]
    }
}