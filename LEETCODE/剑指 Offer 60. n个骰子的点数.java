// ref: https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
class Solution {
    public double[] dicesProbability(int n) {
        /**
         * 如果使用递归来搜索解空间的画，会导致超时
         * 因为在递归过程中存在大量的重复子结构
         * 这会导致大量的重复计算
         * 
         * 故选用动态规划来解决问题
         */

         // 状态转移方程
         // dp[i][j] 表示投掷完 i 枚骰子后，点数之和 j 的出现次数
         int[][] dp = new int[n + 1][6 * n + 1];

         // 边界处理
         for (int i=1;i<=6;i++) {
             // 投掷完 1 枚骰子后，可能的点数之和 i 为 1,2,3,4,5,6
             // 每个点数之和可能出现的次数都为 1
             dp[1][i] = 1; 
         }

         // 统计点数之和中，所有可能的值出现的次数
         // 
         for (int i=2;i<=n;i++) {
             for (int j=i;j<=6*i;j++) {
                 for (int k=1;k<=6 && k<=j;k++) {
                     /**
                      * 投掷完 i 枚骰子后，点数之和 j 可能出现的次数
                      * 可以由投掷完 n - 1 枚骰子后，对应的点数之和：
                      * j-1,j-2,j-3,...,j-6 可能出现的次数之和
                      * 转化而来
                      *
                      * 这里用 k 来表示第 i 枚骰子会出现的六个点数
                      */
                     dp[i][j] += dp[i-1][j-k];
                 }
             }
         }

         // 点数之和中，所有可能的值出现的概率
         double[] ans = new double[6 * n - n + 1];

         // 计算概率 
         for (int i=n;i<=6*n;i++) {
             ans[i-n] = (double) dp[n][i] / Math.pow(6, n);
         }

         return ans;
    }
}