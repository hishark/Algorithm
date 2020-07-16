class Solution {
    public boolean isBipartite(int[][] graph) {
        // 0-未访问 1和-1分别代表一种颜色
        int[] visited = new int[graph.length];

        // 遍历所有结点
        // 如果当前结点没有被染过色，就从这个结点开始dfs染色
        for(int i=0;i<graph.length;i++) {
            if(visited[i]==0 && !dfs(graph, i, 1, visited)){
                return false;
            }
        }

        // 走完所有的连通域都没有返回false，那就是个二分图啦
        return true;
    }


    // 返回值的含义：是否为二分图
    public boolean dfs(int[][] graph, int curNode, int color, int[] visited) {
        // 如果已经染过色，就判断染过的色和当前要染的色是不是同一个色
        if (visited[curNode] != 0) {
            // 这个就是边界条件，如果两个色相同，说明一直在正确染色
            // 如果两个色不相同，说明染色错误，直接返回false，不是二分图
            return visited[curNode] == color;
        }

        // 当前结点没染过色，就染color
        visited[curNode] = color;
        // 然后把与curNode相连接的结点全部染成另外一个色-color
        for (int other: graph[curNode]) {
            // 一旦出现了不符合二分图性质的边，就返回false
            if(!dfs(graph, other, -color, visited))
                return false;
        }

        // 走到最后了就返回true，的确是个二分图
        return true;
    }
}
