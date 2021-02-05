class Solution {
    public int characterReplacement(String s, int k) {
        // 字符串中仅包含大写字母，可以使用一个长度为26的数组维护每一个字符的出现次数
        int[] num = new int[26];
        // 字符串长度
        int n = s.length();
        // 【重复字符出现次数】的最大值
        int max = 0;
        // 双指针，区间边界
        int left = 0, right = 0;
        while (right < n) {
            // 每次区间右移，更新右移位置的字符出现的次数
            num[s.charAt(right) - 'A']++;
            // 并尝试用它更新【重复字符出现次数】的历史最大值
            max = Math.max(max, num[s.charAt(right) - 'A']);
            // 计算区间内【非最长重复字符】的数量，以此判断左指针是否需要右移
            // 如果【非最长重复字符】的数量大于 k，说明区间不满足条件，右移左指针
            if (right - left + 1 - max > k) {
                num[s.charAt(left) - 'A']--; // 记得减1，num记录的是区间中字符出现的次数
                left++;// 右移左指针
            }
            // 如果【非最长重复字符】的数量不大于 k，说明区间满足条件，继续右移右指针
            right++;
        }
        // 最后找到的区间就是包含重复字母的最长子串的长度
        return right - left;
    }
}

// ref：https://leetcode-cn.com/problems/longest-repeating-character-replacement/solution/ti-huan-hou-de-zui-chang-zhong-fu-zi-fu-n6aza/