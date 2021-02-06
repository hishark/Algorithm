class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // 数组长度
        int n = cardPoints.length;
        /**
         * 由于只能从开头和末尾拿 k 张牌，所以最后剩下的一定是连续的 n - k 张牌 
         * 可以通过求剩余卡牌点数之和的最小值，来求出拿走卡牌点数之和的最大值。
         * 
         * 滑动窗口的大小为 n - k 
         * 问题转换为：求滑动窗口内点数之和的最小值
         */
        int windowSize = n - k;

        // 滑动窗口当前的点数之和
        int curSum = 0;

        // 滑动窗口点数之和的初始值为前 n - k 个数字的点数之和
        for (int i = 0; i < windowSize; i++) {
            curSum += cardPoints[i];
        }

        // 滑动窗口点数之和的最小值
        int minSum = curSum;

        // 遍历数组，移动滑动窗口
        for (int i = windowSize; i < n; i++) {
            // 滑动窗口每向右移动一格
            // 增加从右侧进入窗口的数字 cardPoints[i]
            // 减少从左侧离开窗口的数字 cardPoints[i - windowSize]
            curSum += cardPoints[i] - cardPoints[i - windowSize];
            // 更新最小值
            minSum = Math.min(minSum, curSum);
        }
        // 拿走的卡牌数字之和最大值 = 数组之和 - 滑动窗口数字之和最小值
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}

// ref：https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/solution/ke-huo-de-de-zui-da-dian-shu-by-leetcode-7je9/