class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // 数组长度
        int n = s.length();
        // 数组 diff 中的每一项为 s 和 t 数组对应位置数字的差值
        // 于是题目转换为：计算数组 diff 的元素和不超过 maxCost 的最长子数组长度
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        // diff 数组元素和不超过 maxCost 的最长子数组长度
        int maxLength = 0;

        // 双指针，滑动窗口的左右边界
        int left = 0, right = 0;

        // 当前滑动窗口的元素和
        int sum = 0;
        while (right < n) {
            // 更新滑动窗口的元素和
            sum += diff[right];
            // 如果元素和超过了最大预算，就不断地将滑动窗口的左边界右移
            while (sum > maxCost) {
                // 删去滑动窗口最左边的元素
                sum -= diff[left];
                // 收缩左边界
                left++;
            }
            // 如果元素和未超过最大预算，或者在超过之后收缩了左边界
            // 更新最长子数组长度
            maxLength = Math.max(maxLength, right - left + 1);
            // 向右扩张滑动窗口
            right++;
        }
        // 返回最长子数组长度即可
        return maxLength;
    }
}

// ref：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/solution/jin-ke-neng-shi-zi-fu-chuan-xiang-deng-b-higz/