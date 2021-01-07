class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 数组大小
        int n = nums.length;
        // 大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        // 为了方便判断堆顶元素与滑动窗口的位置关系
        // 可以在优先队列中存储二元组 (num,index)，表示元素 num 在数组中的下标为 index。
        // 先把数组中的前 k 个数字放入大根堆
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        // 滑动窗口的最大值
        int[] ans = new int[n - k + 1];
        // 取出大根堆的堆顶元素，即第一个滑动窗口内的最大值
        ans[0] = pq.peek()[0];
        // 继续遍历余下的滑动窗口
        for (int i = k; i < n; i++) {
            // 继续把 (num, index) 放入大根堆
            pq.offer(new int[]{nums[i], i});
            // 查看此时的堆顶元素（即此时堆内的最大值）的下标 pq.peek()[1]
            // 把下标不在滑动窗口内的元素都删去
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            // 此时的堆顶元素即为当前滑动窗口的最大值
            ans[i - k + 1] = pq.peek()[0];
        }
        // 返回结果即可
        return ans;
    }
}
// ref：https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/