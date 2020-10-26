// ref: https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/solution/mian-shi-ti-53-ii-0n-1zhong-que-shi-de-shu-zi-er-f/
class Solution {
    public int missingNumber(int[] nums) {
        // 数组最左端
        int left = 0;
        // 数组最右端
        int right = nums.length - 1;
        
        /**
         * 由题意，数组可以分为两部分：
         *  左子数组中每个 nums[i] = i
         *  右子数组中每个 nums[i] != i
         * 
         * 所以题目中想求的就是「右子数组的首位元素」对应的索引
         * 此处采用二分法来查找该元素
         */
        while (left<=right) {
            // 中点
            int mid = left + (right - left) / 2;

            if (nums[mid] == mid) {
                // 此时，「右子数组的首位元素」一定处于[mid + 1, right]中
                // 所以接下来应该开始搜索当前元素的右边
                left = mid + 1;
            } else {
                // 此时，「左子数组的末位元素」一定处于[left, mid - 1]中
                // 所以接下来应该开始搜索当前元素的左边
                right = mid - 1;
            }
        }
        // 返回 left 和 right 都可以，退出上面的循环之后他俩是相同的！
        return left;
    }
}