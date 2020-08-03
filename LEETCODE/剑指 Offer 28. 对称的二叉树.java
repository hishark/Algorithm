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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        else
            return recursion(root.left, root.right);
    }
    public boolean recursion(TreeNode leftTree, TreeNode rightTree) {
        if(leftTree == null && rightTree == null) 
            return true;
        if(leftTree == null || rightTree == null || leftTree.val != rightTree.val) 
            return false;
        return recursion(leftTree.left, rightTree.right) 
                && recursion(leftTree.right, rightTree.left);
    }
}
