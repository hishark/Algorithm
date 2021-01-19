class Solution {
    /**
     * 下一个排列
     * @param nums
     * 
     * 注意到下一个排列总是比当前排列要大，除非该排列已经是最大的排列。
     * 希望能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。
     *  1. 将左边的较小数和右边的较大数交换，以使当前排列变大
     *  2. 要让较小数尽量靠右，而较大数尽可能小。
     *  3. 交换完成后，较大数右边的数需要按照升序重新排列，这样可以保证变大的幅度尽可能小。
     */
    public void nextPermutation(int[] nums) {
        /**
         * 首先从后向前查找第一个顺序对(i,i+1)。满足 nums[i] < nums[i+1]。
         * 这样较小数就是 nums[i]，此时[i+1,n)一定为降序
         * 
         * 这里是为了满足较小数尽量靠右。
         */
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        /**
         * 找到顺序对后，就在 [i+1,n) 中从后向前查找第一个元素 j 
         * 满足 nums[i] < nums[j]。这样较大数即为 nums[j]。
         * 
         * 由于[i+1,n)为降序，所以这样子是为了使较大数尽可能小。
         */
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 找到了 i 和 j 之后，交换二者。
            swap(nums, i, j);
        }
        // 按照升序重新排列较大数右边的数，这样可以保证变大的幅度尽可能小。
        reverse(nums, i + 1);
    }

    /**
     * 交换 nums 数组中下标为 i 和 j 的数字
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 翻转 nums 数组指定区间的数字
     * @param nums
     * @param start 起始位置
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// ref：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/