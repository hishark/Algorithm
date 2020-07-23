class Solution {
    public int minPathSum(int[][] grid) {
        // 数组行列长度
        int m = grid.length;
        int n = grid[0].length;

        // 状态数组
        int[][] dp = new int[m][n];

        // 边界条件
        dp[0][0] = grid[0][0];

        // 状态转移方程
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                // 防止越界
                if (i==0 && j==0)
                    continue;
                if (i - 1 < 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j - 1 < 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1] + grid[i][j], dp[i-1][j] + grid[i][j]);
                }

            }
        }

        return dp[m-1][n-1];
    }
}
