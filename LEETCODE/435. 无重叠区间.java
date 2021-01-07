class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 判空
        if (intervals.length == 0) {
            return 0;
        }
        // 按照右端点的大小，从小到大对区间排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        // 区间的个数
        int n = intervals.length;
        // 最前面的区间的右端点
        int right = intervals[0][1];
        // 
        int ans = 1;
        // 遍历剩下的区间
        for (int i = 1; i < n; ++i) {
            // 如果【当前区间的左端点】在【前一个区间的右端点】之后
            // 那么就说明找到了一个不重合的且右端点最小的区间
            if (intervals[i][0] >= right) {
                ans++;
                // 保存当前区间的右端点，给下一次循环使用
                right = intervals[i][1];
            }
        }
        // 【区间总数】减去【不重叠的区间总数】就是【需要移除区间的最小数量】
        return n - ans;
    }
}
// ref：https://leetcode-cn.com/problems/non-overlapping-intervals/solution/wu-zhong-die-qu-jian-by-leetcode-solutio-cpsb/