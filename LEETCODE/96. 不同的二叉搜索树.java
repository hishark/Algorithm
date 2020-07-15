class Solution {
    public int numTrees(int n) {
        // 状态数组
        int[] dp = new int[n+1];
        // 边界条件
        dp[0] = 1;
        dp[1] = 1;
        
        // 状态转移方程
        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++) 
                dp[i] += dp[j-1] * dp[i-j];
        
        return dp[n];
    }
}
 
