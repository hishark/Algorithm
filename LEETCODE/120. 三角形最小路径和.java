class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 三角形的行数
        int n = triangle.size();

        // 状态数组
        // dp[i][j]表示从顶点到坐标(i,j)的最小路径和
        int[][] dp = new int[n][n];

        // 边界值
        dp[0][0] = triangle.get(0).get(0);

        // 状态转移
        for (int i=1;i<n;i++) {
            // 上一行的长度
            int len = triangle.get(i-1).size();
            for(int j=0;j<=i;j++) {
                // 当前的dp值只能从dp[i-1][j]和dp[i-1][j-1]转移而来
                // i-1一定不会越界，需要判断j和j-1是否越界，如果越界了就设置为极大值
                int pre1 = j >= 0 && j < len ? dp[i-1][j] : Integer.MAX_VALUE;
                int pre2 = j-1 >=0 && j-1 < len ? dp[i-1][j-1] : Integer.MAX_VALUE;
                // 当前dp = 两个dp的较小值 + 当前结点值
                dp[i][j] = Math.min(pre1, pre2) + triangle.get(i).get(j);
            }
        }

        // 找到dp最后一行的最大值返回即可
        int res = Integer.MAX_VALUE;
        for(int i=0;i<dp[n-1].length;i++) {
            res = Math.min(res, dp[n-1][i]);
        }

        return res;
    }
}
