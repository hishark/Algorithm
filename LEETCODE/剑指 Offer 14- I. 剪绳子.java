// ref: 1. lcof
//      2. https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/zi-jie-ti-ku-jian-14-i-zhong-deng-jian-sheng-zi-1s/
// dp
class Solution {
    public int cuttingRope(int n) {
        // 边界值
        if (n < 2)
            return 0;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        // 状态数组
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;

        // 状态转移方程
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        // dp[n] = max(dp[j] * dp[n-j]) 其中j的范围为：[1,n-1]
        for (int i=4;i<=n;i++) {
            // 当前绳子长度为i
            // 乘积的最大值↓
            int maxValue = 0;

            // j从1开始是因为剪一刀子下去长度最少为1
            // j最大为i因为当前绳子的长度为i
            // 这里的循环条件可以改为j<=i/2，因为i/2之后算出来的就是重复的乘积了，当n特别特别大的时候，只算到i/2可以节省时间
            for(int j=1;j<=i;j++) {
                // 当前乘积
                int product = dp[j] * dp[i-j];
                if (product > maxValue)
                    maxValue = product;                
            }
            // 把最大值存入dp数组
            dp[i] = maxValue;
        }

        // 返回结果
        return dp[n];
    }
}

// 贪心
// 我觉得这题就不适合用dp，就是适合用贪心来做
class Solution {
    public int cuttingRope(int n) {
        // 边界值
        if (n < 2)
            return 0;
        else if (n == 2)
            return 1;
        else if (n == 3)
            return 2;

        // 尽可能多地剪去长度为3的绳子段
        int timesOf3 = n / 3;

        // 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
        // 此时更好的方法是把绳子剪成长度为2的两段，因为2x2>3x1
        if (n - timesOf3 * 3 == 1)
            timesOf3 -= 1; // 所以分一个3出去，和1组成4，再剪成2+2

        int timesOf2 = (n - timesOf3 * 3) / 2;

        return (int)(Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }
}