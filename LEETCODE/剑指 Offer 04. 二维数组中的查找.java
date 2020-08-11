class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 判空
        if (matrix.length == 0) {
            return false;
        }
        // 从右上角开始搜索
        // 当前值和target相等就返回true
        // target < 当前值，就剔除当前列，往左移动一列
        // target > 当前值，就剔除当前行，往下移动一行
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if(matrix[row][col] == target)
                return true;
            else if (target < matrix[row][col])
                col--;
            else if (target > matrix[row][col])
                row++;
        }
        
        return false;
    }
}
