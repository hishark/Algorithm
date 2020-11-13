class Solution {
    public int search(int[] nums, int target) {
        // 目标值的下标
        int index = 0;
        // 左右边界
        int left = 0;
        int right = nums.length - 1;
        
        // 注意是小于等于
        while (left <= right) {
            index = left + (right - left) / 2;
            if (nums[index] == target)
                return index;
            else if (nums[index] > target)
                right = index - 1;
            else
                left = index + 1; 
        }
        // 没找到
        return -1;
    }
}