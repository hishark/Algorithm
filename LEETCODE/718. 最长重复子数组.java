// 暴力法 - 计算最长公共前缀
// 这个方法会超时！
class Solution {
    public int findLength(int[] A, int[] B) {
        // 结果，最长重复子数组的长度
        int ans = 0;
        // 每次比较时最长公共前缀的长度
        int len = 0;
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<B.length;j++) {
                len = 0;
                while(i+len<A.length && j+len<B.length && A[i+len] == B[j+len])
                    len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}


// 动态规划
class Solution {
    public int findLength(int[] A, int[] B) {
        // 状态数组
        // dp[i][j]表示A[i:]和B[j:]最长公共前缀的长度
        int[][] dp = new int[A.length+1][B.length+1];
        
        // 结果
        int ans = 0;
        
        for (int i=A.length-1;i>=0;i--) {
            for(int j=B.length-1;j>=0;j--) {
                // 状态转移方程
                // dp[i][j] = dp[i+1][j+1] + 1 (A[i]==B[j])
                // dp[i][j] = 0 (A[i]!=B[j])
                dp[i][j] = A[i]==B[j] ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return ans;
    }
}

