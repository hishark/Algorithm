/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 二叉树的直径
    int maxNodeNum;

    public int diameterOfBinaryTree(TreeNode root) {
        // 最开始的时候只有根结点，所以为1
        maxNodeNum = 1;
        // 深度优先搜索整棵树
        dfs(root);
        // 结点数减去 1 就是路径长度啦
        return maxNodeNum - 1;
    }

    // 求二叉树的直径
    public int dfs(TreeNode root) {
        // 判空
        if (root == null) {
            return 0;
        }
        // 左子树的直径
        int left = dfs(root.left);
        // 右子树的直径
        int right = dfs(root.right);
        // 更新当前的最大直径
        maxNodeNum = Math.max(maxNodeNum, left + right + 1);
        // 当前树的直径即左右子树的较大者 + 1
        return Math.max(left, right) + 1;
    }
}