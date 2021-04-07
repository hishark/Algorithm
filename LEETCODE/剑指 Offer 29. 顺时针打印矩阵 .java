class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // 空值处理
        if(matrix.length==0) 
            return new int[0];

        // 初始化边界和结果数组
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        int[] res = new int[matrix[0].length * matrix.length];

        int index = 0;
        // 按照方向进行打印
        while (true) { // 别忘了这个，不然就给你打印一圈OTZ
            // 从左到右
            // 1. 按照边界打印
            for (int i=left;i<=right;i++)
                res[index++] = matrix[top][i];
            // 2. 上边界收缩（下移）
            top++;
            // 3. 判断收缩后的上边界和下边界是否相遇
            if (top > bottom)
                break;

            // 从上到下
            // 1. 按照边界打印
            for (int i=top;i<=bottom;i++)
                res[index++] = matrix[i][right];
            // 2. 右边界收缩（左移）
            right--;
            // 3. 判断收缩后的右边界和左边界是否相遇
            if (left > right)
                break;

            // 从右到左
            // 1. 按照边界打印
            for (int i=right;i>=left;i--)
                res[index++] = matrix[bottom][i];
            // 2. 下边界收缩（上移)
            bottom--;
            // 3. 判断收缩后的下边界和上边界是否相遇
            if (top > bottom)
                break;

            // 从下到上
            // 1. 按照边界打印
            for (int i=bottom;i>=top;i--)
                res[index++] = matrix[i][left];
            // 2. 左边界收缩（右移）
            left++;
            // 3. 判断收缩后的左边界和右边界是否相遇
            if(left > right) 
                break;
        }
        return res;
    }
}
// cnt: 1