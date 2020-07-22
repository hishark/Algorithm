class Solution {
    public int findMin(int[] nums) {
        // 如果只有一个元素，直接返回
        if (nums.length == 1)
            return nums[0];

        // 左右边界
        int left = 0;
        int right = nums.length - 1;

        // 二分查找
        // 经过旋转之后的数组被分为了两个数组，nums1和nums2
        // nums1中的元素的任一个都会【大于等于】nums2中的元素的任一个
        // 使用二分查找在nums数组中找到nums2中的第一个元素nums[i]（也就是最小值）
        while (left < right) {
            // 中点
            int mid = left + (right - left) / 2;

            // 比较nums[mid]和nums[right]的大小
            if (nums[mid] < nums[right]) {
                // nums[mid]更小，说明此时nums[mid]处于第二个数组中，left<i<=mid<right
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // nums[mid]更大，说明此时nums[mid]处于第一个数组中，left<mid<i<right
                left = mid + 1;
            } else {
                // 由于存在重复元素，所以无法判断mid目前的位置，但是由于nums[mid]=nums[right]，所以可以忽略右端点
                right -= 1;
            }
        }

        // 返回nums[left]或nums[right]
        return nums[left];
    }
}
