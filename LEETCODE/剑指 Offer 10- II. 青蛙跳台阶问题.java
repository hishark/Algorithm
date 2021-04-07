// dp
// 10-1 和 10-2 就是一样的题目嘛
class Solution {
    public int numWays(int n) {
        // 状态数组
        int[] dp = new int[n+1];
        
        // 边界值
        if (n==0 || n==1) 
            return 1;
        
        dp[0] = 1;
        dp[1] = 1;

        // 状态转移方程
        for (int i=2;i<=n;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}
