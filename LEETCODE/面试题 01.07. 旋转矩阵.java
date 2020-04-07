//reference:
//https://leetcode-cn.com/problems/rotate-matrix-lcci/solution/jian-dan-java-yuan-di-shuang-bai-by-sweetiee/
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //翻转左下和右上
        //n-1行就已经翻转完了所有的数字
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 中心翻转
        // 甜姐这里写的是 n >> 1
        int mid = n / 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}

