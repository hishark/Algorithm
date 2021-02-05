// 滑动窗口
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // 滑动窗口中的数字总和
        int windoSum = 0;
        // 数组长度
        int n = nums.length;
        // 初始化窗口
        for (int i = 0; i < k; i++) {
            windoSum += nums[i];
        }
        // 初始化子数组最大和
        int maxSum = windoSum;
        // 遍历之后的数字，不停的向右滑动窗口
        for (int i = k; i < n; i++) {
            // 把老窗口的第一个数字删掉，再加上当前的数字，就形成了新的窗口
            windoSum = windoSum - nums[i - k] + nums[i];
            // 更新子数组最大和
            maxSum = Math.max(maxSum, windoSum);
        }
        // 除一下就是最大平均数
        // 别忘了 1.0，返回值类型是 double
        return 1.0 * maxSum / k;
    }
}

// ref：https://leetcode-cn.com/problems/maximum-average-subarray-i/solution/zi-shu-zu-zui-da-ping-jun-shu-i-by-leetc-us1k/