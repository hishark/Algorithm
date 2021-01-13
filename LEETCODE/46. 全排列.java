import java.beans.Visibility;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 搜索回溯
class Solution {
    // 当前的排列
    List<Integer> temp = new ArrayList<Integer>();
    // 全排列结果
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        // 标记数组，标记数字是否已访问
        boolean[] visited = new boolean[nums.length];
        // 从 0 开始回溯搜索
        backtrack(nums, visited, 0);
        // 返回结果
        return res;
    }

    /**
     * 回溯搜索
     * @param nums 原数组
     * @param visited 标记数组，标记数字是否访问过
     * @param curIdx 
     */
    public void backtrack(int[] nums, boolean[] visited, int curIdx) {
        /**
         * 从左到右填到了最后，说明已经填完了 n 个位置
         * 找到了一个可行的解，把当前排列放入结果列表中
         * 递归结束
         */
        if (curIdx == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        // 遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // 往没有访问过的位置填数字
            if (!visited[i]) {
                // 访问后标记一下
                visited[i] = true;
                // 把当前数字加入到当前排列中
                temp.add(nums[i]);
                // 继续填下一个数字
                backtrack(nums, visited, curIdx + 1);
                // 填完了一个排列之后，开始回溯
                // 把当前数字标记为未访问
                visited[i] = false;
                // 把当前数组从当前排列中移除
                temp.remove(temp.size()-1);
            }
            
        }
    }
}

// ref：https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/