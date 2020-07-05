//dp
class Solution {
    public boolean isMatch(String s, String p) {
        // 两个串的长度
        int lenP = p.length();
        int lenS = s.length();

        // 状态数组
        // dp[i][j]表示p的前i个字符和s的前j个字符是否匹配
        boolean[][] dp = new boolean[lenP+1][lenS+1];

        // 空串匹配成功
        dp[0][0] = true;

        // 由于*可以匹配空串，所以需要考虑p以若干个*开头的情况
        for(int i=1;i<=lenP;i++) {
            if (p.charAt(i-1) != '*') {
                break;
            }
            dp[i][0] = true;
        }

        for (int i=1;i<=lenP;i++) {
            for (int j=1;j<=lenS;j++) {
                // p和s的当前字符可匹配
                // p的i-1对应dp的i
                if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(i-1) == '*') {
                    // dp[i-1][j]表示*匹配了空串
                    // dp[i][j-1]表示*匹配了当前位置的字符
                    // | 是不短路的或
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                }
            }
        }

        return dp[lenP][lenS];
    }
}
