class Solution {
    // 方向数组
    public int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 矩阵行列数
    public int rows;
    public int cols;

    public int longestIncreasingPath(int[][] matrix) {
        // 空矩阵直接返回0
        if(matrix == null || matrix.length == 0)
            return 0;

        // 矩阵行列数
        rows = matrix.length;
        cols = matrix[0].length;

        // 记忆数组，存储已经计算过的路径长度
        int[][] memo = new int[rows][cols];

        // 最终结果
        int res = 0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                res = Math.max(res, dfs(i, j, memo, matrix));
            }
        }

        return res;
    }
    

    // 计算第row行第col列节点的最长递增路径
    public int dfs(int row, int col, int[][] memo, int[][] matrix) {
        // 先判断当前节点是否计算过，如果计算过就直接返回结果
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        // 计算路径长度，自身+1
        memo[row][col]++;

        // 深度优先搜索 - 上下左右
        for (int[] direction: dir) {
            // 下一个节点的行列下标
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            // 如果节点的下标没有越界，且值比当前节点的值更大，那么就可以继续向深处搜索
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                // 比较memo[row][col]和继续搜索后得到的递增路径，更新为较大的路径
                memo[row][col] = Math.max(memo[row][col], dfs(newRow, newCol, memo, matrix) + 1);
            }
        }

        return memo[row][col];
    }
}
