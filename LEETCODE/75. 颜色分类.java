class Solution {
    public void sortColors(int[] nums) {
        // 数组长度
        int len = nums.length;

        /**
         * 使用 p0 来交换 0，使用 p2 来交换 2
         * 在遍历的过程中，找出所有的 0 交换到数组头部
         * 找出所有的 2 交换到数组尾部
         */
        int p0 = 0, p2 = len - 1;
        
        /**
         * p0 从左向右移动，p2 从右向左移动
         * 在从左向右遍历整个数组时，如果遍历的位置超过了 p2，即可停止遍历
         */
        for (int i = 0; i <= p2; i++) {
            /**
             * 如果找到了2，将 nums[i] 与 nums[p2] 交换
             * 可是这样就会导致一个问题，新的 nums[i] 可能是 0 或者 2
             * 如果是 0 的话，直接结束循环，交换即可
             * 如果是 1 的话，啥也不要做
             * 如果是 2 的话，就不断的与 p2 进行交换，直到 nums[i] 不为 2
             */
            while (i <= p2 && nums[i] == 2) {
                // 交换数字
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                // 别忘记将 p2 左移一个位置
                p2--;
            }
            // 如果找到了0，直接将 nums[i] 与 nums[p0] 交换
            if (nums[i] == 0) {
                // 交换数字
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                // 别忘记将 p0 右移一个位置
                p0++;
            }
        }
    }
}

// ref：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/