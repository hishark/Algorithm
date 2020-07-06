class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        // 数组长度
        var x = obstacleGrid.size
        var y = obstacleGrid[0].size
        
        // 状态数组
        var dp = Array(x){IntArray(y)}

        // 边界条件
        dp[0][0] = if (obstacleGrid[0][0] == 0) 1 else 0

        // 状态转移  
        for (i in 0..x-1) {
            for (j in 0..y-1) {
                if(i==0 && j==0)
                    continue
                else if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0
                else 
                    dp[i][j] = (if(i - 1 >= 0) dp[i-1][j] else 0) + (if(j-1 >= 0) dp[i][j-1] else 0)
            }
        }

        return dp[x-1][y-1]
    }
}
