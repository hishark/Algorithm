class Solution {
    public int search(int[] nums, int target) {
        // 二分查找的左右边界
        int left = 0;
        int right = nums.length - 1;

        // target不一定只有一个，所以需要查找target的右边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // target的右边界
        int numRight = left;

        // 二分查找的左右边界
        left = 0;
        right = nums.length - 1;

        // target不一定只有一个，所以需要查找target的左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // target的左边界
        int numLeft = right;

        // target的左右边界相减即可得到target的出现次数
        return numRight - numLeft - 1;
    }
}
