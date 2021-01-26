// DFS
class Solution {
    // 存储有向图
    List<List<Integer>> edges;
    // 标记每个节点的状态：0=未搜索，1=搜索中，2=已完成
    int[] visited;
    // 用数组来模拟栈，下标 n-1 为栈底，0 为栈顶
    int[] stack;
    // 判断有向图中是否有环
    // 初始状态：无环
    boolean existCycle = false;
    // 栈下标
    int index;

    // 找到拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        // 初始化
        visited = new int[numCourses];

        // 栈中存储的即为拓扑排序
        stack = new int[numCourses];

        // 栈下标
        index = numCourses - 1;

        // 遍历所有的匹配
        for (int[] info : prerequisites) {
            // 根据匹配构建出有向图
            // info[1] 指向 info[0]
            edges.get(info[1]).add(info[0]);
        }

        // 遍历所有节点，每次挑选一个「未搜索」的节点，开始进行深度优先搜索
        for (int i = 0; i < numCourses && !existCycle; i++) {
            // 
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        // 如果存在环，返回空
        if (existCycle) {
            return new int[0];
        }

        // 如果不存在环，那么就存在拓扑排序
        return stack;
    }

    // 深度优先搜索
    public void dfs(int u) {
        // 首先将节点标记为「搜索中」
        visited[u] = 1;

        // 根据有向图 edges 遍历当前节点的相邻节点
        for (int v: edges.get(u)) {
            // 如果相邻节点「未搜索」那么就对相邻节点进行搜索
            if (visited[v] == 0) {
                dfs(v);
                // 一旦发现有环，就立刻停止遍历
                if (existCycle)
                    return;
            }
            // 如果相邻节点处于「搜索中」说明找到了环
            // u 在搜索相邻结点，所以 u 指向 v
            // 如果 v 也处于搜索中，说明 v 也在搜索相邻结点，所以 v 指向 u
            // 从而构成环
            else if (visited[v] == 1) {
                existCycle = true;
                return;
            }
        }
        // 当 u 的所有相邻结点都为「已完成」时，将 u 放入栈中，并标记为「已完成」
        visited[u] = 2;
        // 将节点入栈，组成拓扑排序
        stack[index--] = u;
    }
}

// ref：https://leetcode-cn.com/problems/course-schedule-ii/solution/ke-cheng-biao-ii-by-leetcode-solution/

// BFS
// unread
class Solution {
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
