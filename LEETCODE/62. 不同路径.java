class Solution {
    public int uniquePaths(int m, int n) {
        // 状态数组
        // dp[i][j] 表示从左上角走到 [i,j] 的路径总数
        int[][] dp = new int[m][n];
        // 初始化第一行，第一行的格子只能通过右移得到
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }
        // 初始化第一列，第一列的格子只能通过下移得到
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }
        // 遍历余下的所有格子
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                // 从左上角走到 [i,j] 的路径数 = 左边的格子的路径数 + 上面的格子的路径数
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 返回右下角的路径数即可
        return dp[m - 1][n - 1];
    }
}

// ref：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/