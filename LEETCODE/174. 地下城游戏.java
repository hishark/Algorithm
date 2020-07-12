class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        // 重点：从右下往左上计算
        int n = dungeon.length;
        int m = dungeon[0].length;

        // 状态数组
        // dp[i][j]表示从(i,j)到终点的最低初始值
        int[][] dp = new int[n+1][m+1];

        // 无效值赋值为最大值
        for (int i=0;i<=n;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 计算dp[n-1][m-1]时要用到的两个值，需要赋值为1
        dp[n-1][m] = dp[n][m-1] = 1;

        // 状态方程
        for (int i=n-1;i>=0;i--) {
            for (int j=m-1;j>=0;j--) {
                int min = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        
        return dp[0][0];
    }
}
