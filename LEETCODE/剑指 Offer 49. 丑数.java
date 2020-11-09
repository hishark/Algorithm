class Solution {
    public int nthUglyNumber(int n) {
        // 丑数可以递推：丑数 = 某较小丑数 * 某因子（ 2, 3 ,5 三个其中之一）
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        // 状态转移方程
        // dp[i] 代表第 i + 1 个丑数
        int[] dp = new int[n];

        // 边界值
        // 第一个丑数是 1
        dp[0] = 1;

        // 状态转移方程
        for (int i = 1; i < n; i++) {
            int factor2 = dp[index2] * 2;
            int factor3 = dp[index3] * 3;
            int factor5 = dp[index5] * 5;

            // 当前第 i + 1 个丑数就取由之前的丑数递推出来的丑数的最小值
            dp[i] = Math.min(Math.min(factor2, factor3), factor5);

            // 取了哪个因子递推出来的丑数，就将哪个因子的索引自增
            if (dp[i] == factor2)
                index2++;
            if (dp[i] == factor3)
                index3++;
            if (dp[i] == factor5)
                index5++;
        }
        // 返回第 n 个丑数
        return dp[n - 1];
    }
}