/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// ref: https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/solution/mian-shi-ti-55-ii-ping-heng-er-cha-shu-cong-di-zhi/
class Solution {
    public boolean isBalanced(TreeNode root) {
        int height = tree_height(root);
        // 若返回值为 -1 说明不是平衡树，若不为 -1 说明是平衡树。
        return height != -1;
    }

    // 判断 root 是否为平衡树，若返回值为 -1 说明不是平衡树，若不为 -1 说明是平衡树。
    public int tree_height(TreeNode root) {
        // 递归出口，根为空返回 0
        if (root == null)
            return 0;
        // 求左子树是否为平衡二叉树
        int left_height = tree_height(root.left);
        // 求右子树是否为平衡二叉树
        int right_height = tree_height(root.right);
        /**
         * 只要以下三个条件成立一个就说明当前树不是平衡二叉树
         *  1. 左子树不是平衡二叉树
         *  2. 右子树不是平衡二叉树
         *  3. 左右子树的高度差大于 1
         */
        if (left_height == -1 || right_height == -1 || Math.abs(left_height - right_height) > 1)
            return -1;
        // 如果当前树是平衡二叉树，那么就直接返回它的高度：左右子树高度的较大值 + 1 （别忘记加上 1 ）
        return Math.max(left_height, right_height) + 1;
    }
}