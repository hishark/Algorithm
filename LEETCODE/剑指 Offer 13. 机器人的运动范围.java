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
// dfs
class Solution {
    public int movingCount(int m, int n, int k) {
        // 访问标记矩阵
        boolean[][] visited = new boolean[m][n];
        // 深度优先搜索
        return dfs(m, n, 0, 0, k, visited);

    }

    // 深度优先搜索，[i,j]是当前访问的格子
    public int dfs(int m, int n, int i, int j, int k, boolean[][] visited) {
        // 递归出口：越界，数位之和不合法，已访问
        if (i < 0 || i >= m || j < 0 || j >= n || digitCount(i, j) > k || visited[i][j]) 
            return 0;

        // 当前位置已访问
        visited[i][j] = true;// 为什么12题需要还原board？这里却不用？因为12题每次都是一次全新的匹配，这一题就是从[0,0]开始搜索一回

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

// bfs
class Solution {
    public int movingCount(int m, int n, int k) {
        // 访问矩阵
        boolean[][] visited = new boolean[m][n];
        // 结果
        int ans = 0;
        // 利用队列实现广度优先遍历
        Queue<int[]> queue= new LinkedList<int[]>();
        // 将机器人初始点 (0,0) 加入队列 queue
        // 四个数字分别代表：横坐标索引值，纵坐标索引值，数位之和
        queue.add(new int[] { 0, 0, 0 });
        // 终止条件：queue为空，说明已经遍历完所有可达解
        while(queue.size() > 0) {
            // 单元格出列，作为当前搜索的单元格
            int[] cur = queue.poll();
            // 得到该单元格的索引和数位之和
            int i = cur[0], j = cur[1], sum = cur[2];
            // 如果越界、不合法、已访问的话就跳过
            if(i >= m || j >= n || sum > k || visited[i][j]) 
                continue;
            // 标记当前单元格已被访问
            visited[i][j] = true;
            // 结果++
            ans++;
            // 把当前元素下方和右方的单元格加入队列
            // 下方单元格：横坐标索引，纵坐标索引，数位之和
            queue.add(new int[]{i, j+1, digitCount(i, j+1)});
            // 右方单元格：横坐标索引，纵坐标索引，数位之和
            queue.add(new int[]{i+1, j, digitCount(i+1, j)});
        }
        return ans;
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
