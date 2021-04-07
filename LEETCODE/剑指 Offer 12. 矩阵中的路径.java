// ref: https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
class Solution {
    public boolean exist(char[][] board, String word) {
        // 字符串 - 字符数组
        char[] words = word.toCharArray();
        // 遍历所有字符，找到为止，没找到就返回false
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                // 深度优先搜索成功找到了一个就886
                // index每次都是0
                if(dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    // 深度优先搜索🔍，首先就要写递归出口
    public boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        // 越界，矩阵当前字符不等于字符串当前字符，不合法，返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[index])
            return false;

        // 矩阵当前字符=字符串当前字符，且已经是字符串最后一个字符，合法，返回true
        if (index == word.length - 1) // 别忘了 - 1
            return true;

        // 记录下当前的字符，用于访问结束后恢复矩阵
        char curChar = board[i][j];

        // 已访问，标记为'/'
        board[i][j] = '/';

        // 上下左右都访问一下，只要有一条路成了就可以，所以用或
        boolean ans = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) || 
                      dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i , j - 1, index + 1);

        // 访问后还原矩阵
        board[i][j] = curChar;
        // 返回结果
        return ans;
    }
}