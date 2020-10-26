/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// ref: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
// 迭代
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 结点为空时结束循环
        while (root != null) {
            // 如果 p 和 q 都在 root 的右子树中
            if (p.val > root.val && q.val > root.val) {
                // 接下来就往右子树遍历
                root = root.right; 
            // 如果 p 和 q 都在 root 的左子树中
            } else if (p.val < root.val && q.val < root.val) {
                // 接下来就往左子树遍历
                root = root.left;
            } else {
                /**
                 * 剩下三种情况：
                 *  1. p.val == root.val，q 在 root 的左子树或者右子树中
                 *  2. q.val == root.val，p 在 root 的左子树或者右子树中
                 *  3. p 和 q 分别在 root 的不同侧
                 * 这三种情况都说明 root 是 p 和 q 的最近公共祖先
                 * 找到了结果，终止循环即可
                 */
                break;
            }
        }
        // 返回最近公共祖先
        return root;
    }
}

// 递归
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果 p 和 q 都在 root 的右子树中
        if (p.val > root.val && q.val > root.val) {
            // 开始递归右子树并返回
            return lowestCommonAncestor(root.right, p, q);
        }

        // 如果 p 和 q 都在 root 的左子树中
        if (p.val < root.val && q.val < root.val) {
            // 开始递归左子树并返回
            return lowestCommonAncestor(root.left, p, q);
        }

        /**
         * 剩下三种情况：
         *  1. p.val == root.val，q 在 root 的左子树或者右子树中
         *  2. q.val == root.val，p 在 root 的左子树或者右子树中
         *  3. p 和 q 分别在 root 的不同侧
         * 这三种情况都说明 root 是 p 和 q 的最近公共祖先
         */
        return root;
    }
}