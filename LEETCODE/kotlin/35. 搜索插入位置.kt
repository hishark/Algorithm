class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var mid = left + (right - left) / 2
        while (left <= right) {
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] < target) {
                left++
                mid = left + (right - left) / 2
            } else {
                right--
                mid = left + (right - left) / 2
            }
        }

        return left
    }
}
