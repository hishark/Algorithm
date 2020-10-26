// ref: https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;

        // 两个指针相遇时结束循环
        while (left < right) {
            // 求出当前两个指针指向的两数之和
            int sum = nums[left] + nums[right];

            // 判断该两数之和与目标 target 的大小关系
            if (sum < target) {
                // 由于数组递增有序，所以此时可以将 left 指针右移，以获得更大的值
                left++;
            } else if (sum > target) {
                // 此时可以将 right 指针左移，以获得更小的值
                right--;
            } else {
                // 如果相等，返回结果即可
                return new int[] {nums[left], nums[right]};
            }
        }

        // 没找到符合条件的数字组合，返回 0
        return new int[] {0};
    }
}