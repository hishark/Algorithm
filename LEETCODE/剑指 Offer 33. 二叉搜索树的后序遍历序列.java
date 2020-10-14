class Solution {
    public boolean verifyPostorder(int[] postorder) {
        recursion(postorder, i, j);
    }

    // 判断后序遍历 postorder[i, j] 是否满足二叉搜索树的定义
    boolean recursion(int[] postorder, int i, int j) {
        // 递归终止条件，此时树种结点数量 <= 1，无需判断正确性，直接返回 true
        if (i >= j)
            return true;

        // 工具人 p，初始化为 i，用于找结点
        int p = i;

        /**
         * 根据后序遍历的特性，j 即根结点的位置
         * 此时需要找到第一个大于根结点的结点
         * 将位置记录为 m
         * 该位置用于划分左子树区间[i,m-1]和右子树区间[m,j-1]
         * 
         */
        while (postorder[p] < postorder[j])
            p++;
        int m = p;

        /**
         * 接下来判断是否为二叉搜索树
         * 1. 左子树区间[i,m-1]内所有的结点都应该小于根结点 postorder[j]
         *    在之前找 m 位置的时候其实已经保证了这一点，所以无需再次判断
         * 2. 右子树区间[m,j-1]内所有的结点都应该大于根结点 postorder[j]
         *    遍历[p,j]，遇到小于等于根结点就跳出。
         *    最后看 p 是否等于 j 来判断是否为二叉搜索树
         *      a) 若 p == j，则是二叉搜索树
         *      b) 若 p != j，则不是二叉搜索树
         */
        while (postorder[p] > postorder[j])
            p++;

        // 递归判断当前树的左子树和右子树是否满足二叉搜索树的定义
        return p == j && recursion(postorder, i, m - 1) && recursion(postorder, m, j - 1);
    }
}