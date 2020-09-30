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
// ref: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
// 递归 
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // 后序遍历
        postOrder(root, ans);
        return ans;
    }

    // 递归实现后序遍历，「左右根」
    public void postOrder(TreeNode root, List<Integer> ans) {
        // 递归出口，根为空直接结束后序遍历
        if (root == null)
            return;
        
        // 左
        postOrder(root.left, ans);
        // 右
        postOrder(root.right, ans);
        // 根
        ans.add(root.val);
    }
}

/**
 * 时间复杂度：O(n)。其中n是二叉树的结点数，每一个结点正好遍历一次。
 * 空间复杂度：O(n)。空间占用主要来自于递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树为链状，空间复杂度为O(n)。
 */


// 迭代
