class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;//初始化
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];//到第i-1层有dp[i-1]种方法，到第i-2层有dp[i-2]种方法，由于每次只可以爬1-2个台阶，所以二者相加即可
        }
        return dp[n];
    }
}
