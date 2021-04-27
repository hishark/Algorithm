/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    boolean begin = false;

    public int rangeSumBST(TreeNode root, int low, int high) {
        // BST的中序遍历是递增序列
        // 我在中序遍历的时候，碰到low了就开始累加，碰到high了就结束累加
        // 左，根，右
        dfs(root, low, high);

        return res;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null)
            return;

        dfs(root.left, low, high);

        if (root.val == low) {
            begin = true;
        }

        if (begin) {
            res += root.val;
        }

        if (root.val == high) {
            begin = false;
            return;
        }

        dfs(root.right, low, high);
    }
}