// ref: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/shu-zu-zhong-de-ni-xu-dui-by-leetcode-solution/
// 待琢磨
class Solution {
    public int reversePairs(int[] nums) {
        // 数组长度
        int length = nums.length;

        // 判空
        if (length < 2)
            return 0;

        // 复制一个数组
        int[] copy = new int[length];
        for (int i = 0; i < length; i++)
            copy[i] = nums[i];

        int[] temp = new int[length];
        return reversePairs(copy, 0, length - 1, temp);

    }

    // 计算逆序对数目并排序
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        // 判空
        if (left == right) {
            return 0;
        }

        // 中点
        int mid = left + (right - left) / 2;
        // nums[left, mid]中的逆序对
        int leftPairs = reversePairs(nums, left, mid, temp);
        // nums[mid+1, right]中的逆序对
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 左边数组的最后一个 比 右边数组的第一个 还要小
        // 说明两个数组之间没有逆序对，直接把两个分数组中的逆序对数目加起来即可
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        // 如果两个分数组中存在逆序对，归并排序并计算其逆序对的数目
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        // 全部加到一起就是总的逆序对数目
        return leftPairs + rightPairs + crossPairs;
    }

    // nums[left, mid] 和 nums[mid+1, right]都是有序的
    // 归并排序的同时计算逆序对的数目
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 归并排序需要使用到一个临时数组
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // 指针 i 指向 nums[left, mid]
        int i = left;
        // 指针 j 指向 nums[mid+1, right]
        int j = mid + 1;

        // 逆序对的数目
        int count = 0;

        for (int k = left; k <= right; k++) {
            // 指针 i 遍历完了 nums[left, mid]
            // 接着遍历右边的数组
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
                // 指针 j 遍历完了 nums[mid+1, right]
                // 接着遍历左边的数组
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
                // 不是逆序对，继续遍历
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
                // temp[i] > temp[j] 发现逆序对，计算逆序对的数目
            } else {
                nums[k] = temp[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }
}