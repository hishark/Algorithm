
// 摩尔投票法
// ref: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
class Solution {
    public int majorityElement(int[] nums) {
        // 众数
        int mode = 0;
        // 票数和
        int votes = 0;

        // 遍历所有数字
        for (int num : nums) {
            // 当票数和为 0 时，就假设当前数字是众数 mode
            if (votes == 0)
                mode = num;

            // 如果当前数字是众数，票数+1，反之票数-1
            if (num == mode)
                votes += 1;
            else
                votes -= 1;

        }

        return mode;
    }
}