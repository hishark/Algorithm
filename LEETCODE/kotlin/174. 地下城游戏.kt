class Solution {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        // 重点：从右下往左上计算
        val n = dungeon.size
        val m = dungeon[0].size

        // 状态数组
        // dp[i][j]表示从(i,j)到终点的最低初始值
        val dp = Array(n + 1) { IntArray(m + 1) }

        // 无效值赋值为最大值
        for (i in 0..n) {
            Arrays.fill(dp[i], Integer.MAX_VALUE)
        }

        // 计算dp[n-1][m-1]时要用到的两个值，需要赋值为1
        dp[n][m - 1] = 1
        dp[n - 1][m] = 1

        // 状态方程
        for (i in n - 1 downTo 0) {
            for (j in m - 1 downTo 0) {
                val min = Math.min(dp[i + 1][j], dp[i][j + 1])
                dp[i][j] = Math.max(min - dungeon[i][j], 1)
            }
        }

        return dp[0][0]
    }
}
