class Solution {
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        // 判空
        if (matrix.size == 0) {
            return false
        }
        // 从右上角开始搜索
        // 当前值和target相等就返回true
        // target < 当前值，就剔除当前列，往左移动一列
        // target > 当前值，就剔除当前行，往下移动一行
        var row = 0
        var col = matrix[0].size - 1

        while (row < matrix.size && col >= 0) {
            if (matrix[row][col] == target)
                return true
            else if (target < matrix[row][col])
                col--
            else if (target > matrix[row][col])
                row++
        }

        return false
    }
}
