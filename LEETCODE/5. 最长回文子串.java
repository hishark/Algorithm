class Solution {
    public String longestPalindrome(String s) {
        // 字符串长度
        int n = s.length();
        // 状态转移数组
        // dp[i][j] 表示 s[i,j] 是否为回文串
        boolean[][] dp = new boolean[n][n];
        // 最长回文子串
        String ans = "";
        // l 是当前判断的字符串的长度减 1
        for (int l = 0; l < n; ++l) {
            // i为子串的左端点，j为子串的右端点
            for (int i = 0; i + l < n; ++i) {
                // 右端点 j
                int j = i + l;
                // 如果字符串长度为 1，显然为回文串
                if (l == 0) {
                    dp[i][j] = true;
                    // 如果字符串长度为 2，如果两个字符相等，就为回文串
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    // 如果字符串长度大于 2，那么只要判断【首尾字符是否相等，中间的字符串是否为回文串】即可
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                // 不停的更新最长的子串即可
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1); // substring(i, j+1)也可以，一个意思
                }
            }
        }
        return ans;
    }
}

// ref：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/