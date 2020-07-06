class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 数组长度
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        
        // 状态数组
        int[][] dp = new int[x][y];

        // 边界条件
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        // 状态转移
        for (int i=0;i<x;i++) {
            for (int j=0;j<y;j++) {
                if(i==0 && j==0)
                    continue;
                else if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else 
                    dp[i][j] = (i - 1 >= 0 ? dp[i-1][j] : 0) + (j-1 >= 0 ? dp[i][j-1] : 0);
            }
        }

        return dp[x-1][y-1];
        
    }
}
