class Solution {
    public int maxValue(int[][] grid) {
        // 状态数组
        // dp[i][j] 表示从左上角开始到 [i,j] 时可以拿到的礼物的最大价值
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        // 边界值
        dp[0][0] = grid[0][0];

        // 状态转移方程
        // 初始化第一行，第一行的每个格子只能一直往右平移
        for (int i=1;i<col;i++) {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }

        // 初始化第一列，第一列的每个格子只能一直往下平移
        for (int i=1;i<row;i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        // 余下的格子，每个格子都可以往右、往下移动
        for (int i=1;i<row;i++) {
            for (int j=1;j<col;j++) {
                dp[i][j] = grid[i][j] + Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[row - 1][col - 1];
    }
}