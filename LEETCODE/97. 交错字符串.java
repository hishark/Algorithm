class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 状态数组
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];

        if (len1 + len2 != s3.length())
            return false;

        // 边界条件
        dp[0][0] = true;

        // 状态转移方程
        for (int i=0;i<=len1;i++) {
            for (int j=0;j<=len2;j++) {
                if (i > 0)
                    dp[i][j] =  dp[i][j] || dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
    
                if (j > 0)
                    dp[i][j] = dp[i][j] || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }

        return dp[len1][len2];
    }
}
