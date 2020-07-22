class Solution {
    public int findMin(int[] nums) {
        // 如果只有一个数字就直接返回
        if (nums.length == 1)
            return nums[0];

        // 左右边界
        int left = 0;
        int right = nums.length - 1;

        // 如果第一个元素比最后一个元素小，说明没有旋转，直接返回第一个元素即可
        if (nums[left] < nums[right])
            return nums[0];

        // 二分查找
        while (left <= right) {

            // 中点
            int mid = left + (right - left) / 2;

            // 原数组为升序数组，所以一定满足nums[mid-1]<nums[mid]<nums[mid]+1，所以一旦出现矛盾，说明找到了【变化点】，也就找到了最小值
            // 注意一定要把nums[mid]和nums[mid+1]之间的比较放在前面，不然会出现越界异常
            //（比如只有两个元素的时候，mid=0，mid-1=-1，会造成越界）
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])
                return nums[mid];

            // 【变化点】左边的元素都比nums[0]大，右边的元素都比nums[0]小
            // 比较nums[mid]和nums[0]的大小，以决定应该继续查找左区间还是右区间
            if (nums[mid] > nums[0]) {
                // nums[mid]更大，说明此时在【变化点】的左边，所以应该继续查找右区间
                left = mid + 1;
            } else {
                // 本题数组无重复元素，所以else里一定是nums[mid] < nums[0]
                // nums[mid]更小，说明此时在【变化点】的右边，所以应该继续查找左区间
                right = mid - 1;
            }

        }

        return -1;
    }
}
