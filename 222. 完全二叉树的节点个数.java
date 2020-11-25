// 二分
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
    public int countNodes(TreeNode root) {
        /**
         * 设完全二叉树的最大层数为 h
         * 节点个数一定在[2^h, 2^(h+1)-1]的范围内
         * 可以在该范围内通过二分查找的方式得到完全二叉树的节点个数
         */
    }
}




// dfs
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
    public int countNodes(TreeNode root) {
        // 递归出口
        if (root == null)
            return 0;

        // 计算左边的节点个数
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        // 返回左右子树的结点个数 + 1
        return left + right + 1;
    }
}





