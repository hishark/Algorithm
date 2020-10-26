// ref: https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/%E2%80%8B/
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 递归终止条件：
         *  1. 递归越过叶子结点，直接返回 null
         *  2. 当 root 等于 p 或者 q 时，root 即最近公共祖先，直接返回
         */
        if (root == null || root == p || root == q)
            return root;
        
        // 递归左子树
        TreeNode leftTree = lowestCommonAncestor(root.left, p, q);

        // 递归右子树
        TreeNode rightTree = lowestCommonAncestor(root.right, p, q);

        // 根据 leftTree 和 rightTree 的值，可以分为四种情况
        // 1. 同时为空，说明 root 的左右子树都不包含 p 和 q
        if (leftTree == null && rightTree == null)
            return null;

        // 2. 只有 leftTree 为空，说明 p 和 q 都不在 root 的左子树中，直接返回 rightTree
        if (leftTree == null)
            return rightTree;

        // 3. 只有 rightTree 为空，说明 p 和 q 都不在 root 的右子树中，直接返回 leftTree
        if (rightTree == null)
            return leftTree;

        // 4. 同时不为空，说明 p 和 q 处于 root 的不同侧，因此 root 就是最近公共祖先，返回即可
        return root;
    }
}