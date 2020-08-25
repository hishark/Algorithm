/**
 * 搜索矩阵：
 *  递归 —— 深度优先搜索
 *  队列 —— 广度优先搜索
 * 
 * 递归出口：
 *  越界，数位之和不合法，已访问
 * 
 * 记录已访问
 * 
 * 解决子问题，返回当前问题的结果
 * 
 * 
 * Ref：
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/ji-qi-ren-de-yun-dong-fan-wei-by-leetcode-solution/
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visited);

    }

    public int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        // 递归出口：越界，数位之和不合法，已访问
        if (i < 0 || i >= m || j < 0 || j >= n || digitCount(i, j) > k || visited[i][j]) 
            return 0;

        // 当前位置已访问
        visited[i][j] = true;

        // 解决子问题，返回当前问题的结果
        return 1 + dfs(m, n, i + 1, j, k, visited) +  dfs(m, n, i - 1, j, k, visited)
                 + dfs(m, n, i, j + 1, k, visited) + dfs(m, n, i, j - 1, k, visited);
    }

    // 计算x和y的数位之和
    public int digitCount(int x, int y) {
        int sum = 0;
        while (x != 0 || y != 0 ) {
            sum += x%10;
            x /= 10;
            sum += y%10;
            y /= 10;
        }
        return sum;
    }
}

