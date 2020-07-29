class Solution {
    fun search(nums: IntArray, target: Int): Int {
        // 二分查找的左右边界
        var left = 0
        var right = nums.size - 1

        // target不一定只有一个，所以需要查找target的右边界
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] <= target)
                left = mid + 1
            else
                right = mid - 1
        }

        // target的右边界
        val numRight = left

        // 二分查找的左右边界
        left = 0
        right = nums.size - 1

        // target不一定只有一个，所以需要查找target的左边界
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target)
                left = mid + 1
            else
                right = mid - 1
        }

        // target的左边界
        val numLeft = right

        // target的左右边界相减即可得到target的出现次数
        return numRight - numLeft - 1
    }
}
