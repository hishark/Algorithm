// ref: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
class Solution {
    public int search(int[] nums, int target) {
        // 数组长度
        int len = nums.length;

        // 判空
        if (len == 0)
            return -1;

        // 边界情况
        if (len == 1)
            return nums[0] == target ? 0 : -1;

        // 二分查找时使用的两个指针
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            // 找中点
            int mid = left + (right - left) / 2;

            // 找到了就直接返回
            if (nums[mid] == target)
                return mid;

            /**
             * 判断 mid 分割出来的两个部分：
             *  1. [left, mid]
             *  2. [mid+1, right]
             * 哪个部分是有序的
             */
            // 假设 mid = 6
            // [4,5,6,7,0,1,2] -> 左[4,5,6,7]  右[0,1,2]
            // 以上面这个数组为例
            // nums[mid] 和 nums[0]做比较主要是想判断 nums[mid] 处于旋转后的左还是右
            if (nums[0] <= nums[mid]) {
                // 如果 mid 处于左
                // 那么就在左边的数组进行二分查找
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 如果 mid 处于右
                // 那么就在右边的数组进行二分查找
                if (nums[mid] < target && target <= nums[len - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        // 找不到，返回 -1
        return -1;
    }
}