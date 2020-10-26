// ref: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/mian-shi-ti-57-ii-he-wei-sde-lian-xu-zheng-shu-x-2/
class Solution {
    public int[][] findContinuousSequence(int target) {
        // 最终结果
        List<int[]> resList = new ArrayList<int[]>();

        // 当前枚举区间为 [start, end]
        for (int start = 1, end = 2; start < end;) {
            // 序列之和，使用求和公式
            int sum = (start + end) * (end - start + 1) / 2;

            // 如果等于 target，就找到了一个合法序列，加入结果列表
            if (sum == target) {
                // 当前合法序列
                int[] curRes = new int[end - start + 1];
                for (int i = start; i <= end; i++) {
                    curRes[i - 1] = i;
                }
                // 添加到结果列表中
                resList.add(curRes);
                // 以 start 为起点的合法序列最多只有一个，所以需要枚举下一个起点，将 start 右移
                start++;
            } else if (sum < target) {
                // 序列之和比目标更小，说明还可以将 end 右移，以获得更大的值
                end++;
            } else {
                // 序列之和比目标更大，说明以 start 为起点不存在一个 end 使得 sum = target
                // 此时应该枚举下一个起点，将 start 右移
                start++;
            }
        }
        // 循环结束，得到所有的合法序列
        return resList.toArray(new int[resList.size()][]);
    }
}