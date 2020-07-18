class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        // 状态数组
        val len1 = s1.length
        val len2 = s2.length
        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) }

        if (len1 + len2 != s3.length)
            return false

        // 边界条件
        dp[0][0] = true

        // 状态转移方程
        for (i in 0..len1) {
            for (j in 0..len2) {
                if (i > 0)
                    dp[i][j] = dp[i][j] || dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]

                if (j > 0)
                    dp[i][j] = dp[i][j] || dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
            }
        }

        return dp[len1][len2]
    }
}
