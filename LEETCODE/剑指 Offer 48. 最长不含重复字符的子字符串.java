import java.util.Map;

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

        // 边界值
        dp[0] = 1;
        hashmap.put(s.charAt(0), 0);

        // 最长不含重复字符的子字符串的长度
        int ans = dp[0];

        // i 为左边界，j 为右边界
        // 固定右边界j，设字符s[j]左边距离最近的相同字符为 s[i]
        for (int j = 1; j < s.length(); j++) {
            // 从哈希表中获取到当前字符 s[j] 左边距离最近的相同字符 s[i]
            // 左边不存在相同的字符就给 i 赋值 -1
            int i = hashmap.getOrDefault(s.charAt(j), -1);

            // 遍历字符串的同时使用哈希表统计「每个字符最后一次出现的位置」
            hashmap.put(s.charAt(j), j);

            // 状态转移方程
            // 当 dp[j−1]<j−i，说明s[i]在子字符串dp[j-1]区间之外，不会造成重复，dp[j]直接等于dp[j-1]+1
            // 当 dp[j−1]≥j−i，说明s[i]在子字符串dp[j-1]区间之中，会造成重复，dp[j]更新为 j - i
            dp[j] = dp[j - 1] < j - i ? dp[j - 1] + 1 : j - i;
            // 更新结果
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }
}


// 滑动窗口
/**
滑动窗口右边界 j 不断右移将新元素加入窗口，当窗口内是 abc 时满足要求，当再进入 a，窗口变成了abca，不满足要求。
这时，将移动窗口的左边界 i 右移，直到将重复元素移除窗口，才重新开始移动窗口的右边界
一直维持这样的滑动窗口，记录窗口的最大长度
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 字符串长度
        int n = s.length();
        // 利用Set判断是否包含重复字符
        Set<Character> set = new HashSet<>();
        // 双指针，初始化都指向最左端
        int left = 0, right = 0;
        // 滑动窗口的最大长度
        int maxLength = 0;
        // 右指针一直移动到最右才结束循环
        while (right < n) {
            // 若当前滑动窗口内不包含重复字符，右指针 right 就一直向右移
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else { // 遇到窗口内已有的元素，左边界i一直右移直到重复元素不在Set内
                // 如果右指针遇到了滑动窗口中已存在的字符，左指针left就一直右移直到这个重复字符滚粗去
                // 最后留下了右指针指向的字符，删去了之前的字符
                while(set.contains(s.charAt(right))) {
                    // 别删错人删成right了哈
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            // 更新滑动窗口的最大长度
            // 为什么不是right-left+1？因为right在set新增元素之后已经右移了
            maxLength = Math.max(maxLength, right - left);
        }
        
        return maxLength;
    }
}
