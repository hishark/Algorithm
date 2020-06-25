class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        Set<String> dictSet = new HashSet(wordDict);

        // 状态数组
        boolean[] dp = new boolean[length+1];

        // 边界条件
        dp[0] = true;

        // 状态方程
        for (int i=1;i<=length;i++) {
            for (int j=0;j<i;j++) {
                dp[i] = dp[j] && dictSet.contains(s.substring(j, i));
                if(dp[i]==true)
                    break;
            }
        }
        return dp[length];
    }

}