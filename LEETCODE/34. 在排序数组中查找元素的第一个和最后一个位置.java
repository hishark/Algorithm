class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        int leftIndex = getIndex(nums, target, true);
        
        // 如果越界了或者值对不上，就返回 -1 -1
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return targetRange;
        }

        //成功找到了左边界
        targetRange[0] = leftIndex;
        // 有左一定有右
        targetRange[1] = getIndex(nums, target, false) - 1;

        return targetRange;

    }

    /**
     * 返回左右索引值
     * @param nums 数组
     * @param target 目标值
     * @param flag flag为true时递归查询左区间，flag为false时递归查询右区间
     * @return
     */
    public int getIndex(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (flag && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}