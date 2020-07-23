class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        // 数组行列长度
        val m = grid.size
        val n = grid[0].size

        // 状态数组
        val dp = Array(m) { IntArray(n) }

        // 边界条件
        dp[0][0] = grid[0][0]

        // 状态转移方程
        for (i in 0 until m) {
            for (j in 0 until n) {
                // 防止越界
                if (i == 0 && j == 0)
                    continue
                if (i - 1 < 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j]
                } else if (j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j])
                }
            }
        }

        return dp[m - 1][n - 1]
    }
}
