// 排序
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}

// 堆
// ref:
// https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 数组中最小的 k 个数
        int[] ans = new int[k];

        // 判空
        if (k == 0)
            return ans;

        /**
         * Java中默认的为小根堆，实现大根堆需要重写一下 Comparator 题目要求前 k 小的数字，所以需要使用一个容量为 k 的大根堆
         * 
         * 遍历数组的时候，若堆的大小小于 k，就直接把数字放进去 若堆的大小已经为 k，需要判断当前数字和堆顶数字的大小： 1. 若当前数字 >=
         * 堆顶数字，那么这个数就直接跳过 2. 若当前数字 < 堆顶数字，那么就先把堆顶数字 poll 掉，然后把当前数字放入堆中
         * 
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        // 首先，先把数字的前 k 个数字全部怼入堆中
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arr[i]);
        }

        // 接着继续遍历数组中剩下的数字
        for (int i = k; i < arr.length; i++) {
            // 如果「当前遍历的数字」 <「堆顶数字」
            if (maxHeap.peek() > arr[i]) {
                // 就把堆顶数字送出去
                maxHeap.poll();
                // 并把当前数字放入堆中
                maxHeap.offer(arr[i]);
            }
            // 如果「当前遍历的数字」 >=「堆顶数字」，直接跳过即可
        }

        // 此时，大根堆中已经存好了前 k 小的数字们，放入结果数组即可
        for (int i = 0; i < k; i++)
            ans[i] = maxHeap.poll();

        return ans;
    }
}