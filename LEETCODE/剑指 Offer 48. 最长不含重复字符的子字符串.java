// ref: https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/

// 动态规划 + 哈希表
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 判空
        if (s.length() == 0)
            return 0;

        // 状态转移方程
        // dp[i] 表示以字符 s[i] 结尾的「最长不重复子字符串」的长度
        int[] dp = new int[s.length()];

        // 使用哈希表统计「每个字符最后一次出现的位置」
        Map<Character, Integer> hashmap = new HashMap<>();

        // 最长不含重复字符的子字符串的长度
        int ans = 0;

        // i 为左边界，j 为右边界
        for (int j = 0; j < s.length(); j++) {
            // 从哈希表中获取到当前字符 s[j] 左边距离最近的相同字符 s[i]
            // 左边不存在相同的字符就给 i 赋值 -1
            int i = hashmap.getOrDefault(s.charAt(j), -1);

            // 遍历字符串的同时使用哈希表统计「每个字符最后一次出现的位置」
            hashmap.put(s.charAt(j), j);

            // 状态转移方程
            if (j != 0)
                dp[j] = dp[j - 1] < j - i ? dp[j - 1] + 1 : j - i;
            else
                dp[j] = 1;

            // 更新结果
            ans = Math.max(ans, dp[j]);

        }
        return ans;
    }
}
