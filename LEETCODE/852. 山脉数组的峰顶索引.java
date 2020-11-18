// ref: https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/solution/shan-mai-shu-zu-de-feng-ding-suo-yin-by-leetcode/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        /**
         * 将山脉数组中所有满足 A[i] < A[i+1]的 i 点标记为 True 不满足的标记为 False 那么一个山脉数组可以标记为 [True,
         * True, ... , True, False , ... , False]
         */
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // 找中点
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // 由于题目限制，不存在连续相等的数字
                // 所以这里一定是发生突变的地方，更新右边界即可
                right = mid;
            }
        }

        return left;
    }
}