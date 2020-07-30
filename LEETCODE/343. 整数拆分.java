class Solution {
    public int integerBreak(int n) {
        // 状态数组
        // dp[i]表示正整数i的最大乘积
        int[] dp = new int[n + 1];

        // 边界条件
        // 0和1都是不可拆分的
        dp[0] = dp[1] = 0;

        // 状态转移方程
        for (int i=2;i<=n;i++) {
            int curMax = 0;
            for (int j=1;j<=i-1;j++) {
                // 假设i拆分出的第一个整数为j，剩下的部分为i-j，那么存在两种情况
                // 1. i-j不再继续拆分，那么乘积就是 j*(i-j)
                // 2. i-j继续拆分，拆成什么样随便他，反正乘积就是 j*dp[i-j]
                // 二者取较大值即可
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }

        return dp[n];
    }
}
