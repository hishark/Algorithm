class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        // 三角形的行数
        val n = triangle.size

        // 状态数组
        // dp[i][j]表示从顶点到坐标(i,j)的最小路径和
        val dp = Array(n) { IntArray(n) }

        // 边界值
        dp[0][0] = triangle[0][0]

        // 状态转移
        for (i in 1 until n) {
            // 上一行的长度
            val len = triangle[i - 1].size
            for (j in 0..i) {
                // 当前的dp值只能从dp[i-1][j]和dp[i-1][j-1]转移而来
                // i-1一定不会越界，需要判断j和j-1是否越界，如果越界了就设置为极大值
                val pre1 = if (j >= 0 && j < len) dp[i - 1][j] else Integer.MAX_VALUE
                val pre2 = if (j - 1 >= 0 && j - 1 < len) dp[i - 1][j - 1] else Integer.MAX_VALUE
                // 当前dp = 两个dp的较小值 + 当前结点值
                dp[i][j] = Math.min(pre1, pre2) + triangle[i][j]
            }
        }

        // 找到dp最后一行的最大值返回即可
        var res = Integer.MAX_VALUE
        for (i in 0 until dp[n - 1].size) {
            res = Math.min(res, dp[n - 1][i])
        }

        return res
    }
}
