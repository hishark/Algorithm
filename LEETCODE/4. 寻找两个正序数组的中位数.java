// 二分查找
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 如果忽略复杂度的要求，有两种时间复杂度为 O(m+n) 的方法：
         *  1. 使用归并排序合并两个数组，得到一个大的有序数组，中间位置即中位数
         *  2. 不合并数组，直接使用双指针来找到中位数的位置
         * 
         * 如果对时间复杂度的要求有 log，通常都需要使用到二分查找
         */

    }
}

// 双指针
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 只需要找到中位数的位置即可
         */

        // 两个数组的长度
        int m = nums1.length;
        int n = nums2.length;

        // 两个数组的总长度
        int len = m + n;

        /**
         * 判断中位数时需要对数组长度的奇偶情况进行分类
         *  1. 如果是奇数，要知道第 (len+1)/2 个数，共需要遍历 int(len/2)+1 次
         *  2. 如果是偶数，要知道第 len/2 个数和第 len/2+1个数，共需要遍历 len/2+1 次
         * 所以遍历的话，奇偶情况都是 len/2+1 次
         * 
         * 返回中位数的话：
         *  1. 奇数需要最后一次遍历的结果
         *  2. 偶数需要最后一次和上一次遍历的结果
         * 
         * 所以这里使用两个变量：
         *  1. cur 保存当前循环的结果
         *  2. pre 保存上一次循环的结果
         */
        int pre = -1;
        int cur = -1;

        // 双指针，分别指向两个数组
        int mPointer = 0;
        int nPointer = 0;

        for (int i=0;i<=len/2;i++) {
            // 更新 pre
            pre = cur;

            /**
             * 如果 mPointer < m && nums1[mPointer] < nums2[nPointer]，就可以右移
             * 如果 nPointer >= n 说明已经越界，就不需要执行 nums1[mPointer] < nums2[nPointer] 
             */

            if (mPointer < m && (nPointer >= n || nums1[mPointer] < nums2[nPointer])) {
                // 如果 nums1[mPointer] < nums2[nPointer]，那么 nums1 数组的指针右移
                cur = nums1[mPointer++];
            } else {
                // 如果 nums1[mPointer] >= nums2[nPointer]，那么 nums2 数组的指针右移
                // 总而言之是数字更小的那一个数组的指针进行右移
                cur = nums2[nPointer++];
            }

        }

        /**
         * 位运算判断奇偶：
         *  1. n&1=0 说明 n 为偶数
         *  2. n&1=1 说明 n 为奇数
         * 
         * 这里：
         *  1. 如果len为偶数，将最后一次和上一次遍历的结果求平均数即可
         *  2. 如果len为奇数，直接返回最后一次遍历的结果即可
         */
        if ((len & 1) == 0)
            return (pre + cur) / 2.0; // 记得是 2.0 不是 2
        else
            return cur;
    }
}