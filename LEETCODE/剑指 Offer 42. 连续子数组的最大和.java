
//ref: https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
class Solution {
    public int maxSubArray(int[] nums) {
        // 状态数组
        // dp[i] 表示以元素 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[nums.length];

        // 边界值
        dp[0] = nums[0];

        // 最大和
        int max = dp[0];

        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                // 此时说明 dp[i-1] 产生负贡献，还没有 nums[i]大，给 dp[i] 赋值为 nums[i] 即可
                dp[i] = nums[i];
            } else {
                // 此时说明 dp[i-1] 产生正贡献，累加上 nums[i] 后赋值给 dp[i] 即可
                dp[i] = dp[i - 1] + nums[i];
            }
            // 若 dp[i] 大于 max，更新最大值即可
            if (dp[i] > max)
                max = dp[i];
        }
        // 返回最大值
        return max;
    }
}

// 降低空间复杂度到 O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int maxValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            maxValue = Math.max(nums[i], maxValue);
        }
        return maxValue;
    }
}