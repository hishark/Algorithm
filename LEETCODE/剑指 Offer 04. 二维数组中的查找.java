class Solution {
    // 这种有序数组找元素肯定有规律的，反正这个套路记得从右上角开始找就可以了
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

        // 找到循环条件就好做啦
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
