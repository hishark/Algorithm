class Solution {
    // 方向数组
    var dir = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    // 矩阵行列数
    var rows: Int = 0
    var cols: Int = 0

    fun longestIncreasingPath(matrix: Array<IntArray>?): Int {
        // 空矩阵直接返回0
        if (matrix == null || matrix.size == 0)
            return 0

        // 矩阵行列数
        rows = matrix.size
        cols = matrix[0].size

        // 记忆数组，存储已经计算过的路径长度
        val memo = Array(rows) { IntArray(cols) }

        // 最终结果
        var res = 0

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                res = Math.max(res, dfs(i, j, memo, matrix))
            }
        }

        return res
    }


    // 计算第row行第col列节点的最长递增路径
    fun dfs(row: Int, col: Int, memo: Array<IntArray>, matrix: Array<IntArray>): Int {
        // 先判断当前节点是否计算过，如果计算过就直接返回结果
        if (memo[row][col] != 0) {
            return memo[row][col]
        }

        // 计算路径长度，自身+1
        memo[row][col]++

        // 深度优先搜索 - 上下左右
        for (direction in dir) {
            // 下一个节点的行列下标
            val newRow = row + direction[0]
            val newCol = col + direction[1]

            // 如果节点的下标没有越界，且值比当前节点的值更大，那么就可以继续向深处搜索
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && matrix[newRow][newCol] > matrix[row][col]) {
                // 比较memo[row][col]和继续搜索后得到的递增路径，更新为较大的路径
                memo[row][col] = Math.max(memo[row][col], dfs(newRow, newCol, memo, matrix) + 1)
            }
        }

        return memo[row][col]
    }
}
