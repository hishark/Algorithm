// dfs
class Solution {
    int cityNum = 0;
    int[][] isConnected;
    boolean[] visited;
    public int findCircleNum(int[][] isConnect) {
        isConnected = isConnect;
        // 城市的数量
        cityNum = isConnected.length;
        // 记录每个城市是否被访问过
        visited = new boolean[cityNum];
        // 省份的数量
        int provinces = 0;
        // 遍历所有的城市
        for (int i = 0; i < cityNum; i++) {
            // 如果当前城市没有访问过
            if (!visited[i]) {
                // 就从当前城市开始深搜，通过矩阵 isConnected 得到与该城市直接相连的城市有哪些
                dfs(i);
                // 把处于同一个连通分量中的所有城市都搜索完了，就得到了一个省份
                provinces++;
            }
        }
        return provinces;
    }

    // 计算和【下标为 i 的城市】直接相连的城市有哪些
    public void dfs(int i) {
        // 对当前城市i，遍历所有城市
        for (int j = 0; j < cityNum; j++) {
            // 如果i和j相连，且j还没有访问过
            if (isConnected[i][j] == 1 && !visited[j]) {
                // 先标记 j 已访问
                visited[j] = true; // 别忘记更新 visited
                // 然后再继续对 j 进行深搜
                dfs(j);
            }
        }
    }
}
// ref：https://leetcode-cn.com/problems/number-of-provinces/solution/sheng-fen-shu-liang-by-leetcode-solution-eyk0/

// bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 城市的数量
        int cityNum = isConnected.length;
        // 标记城市是否已访问
        boolean[] visited = new boolean[cityNum];
        // 省份的数量
        int provinces = 0;
        // 用于BFS的队列
        Queue<Integer> queue = new LinkedList<Integer>();
        // 遍历所有城市
        for (int i = 0; i < cityNum; i++) {
            // 如果当前城市未访问
            if (!visited[i]) { // 这个是大前提，没访问过才有进行下去的必要，别忘了这里
                // 把未访问的城市放入队列
                queue.offer(i);
                // 队列为空时结束循环
                while (!queue.isEmpty()) {
                    // 取出队头元素
                    int j = queue.poll();
                    // 标记为已访问
                    visited[j] = true; // 别忘记标记
                    // 开始对当前城市 j 周围的城市 k 进行遍历
                    for (int k = 0; k < cityNum; k++) {
                        // 找到一个没访问的就加入到队列中
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                // 队列为空时就成功找出了一个省份
                provinces++;
            }
        }
        // 返回即可
        return provinces;
    }
}