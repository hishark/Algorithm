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
        // 空树显然对称
        if (root == null)
            return true;
        // 非空树，检查左右子树是否对称
        return recursion(root.left, root.right);
    }

    // 检查L和R是否对称
    public boolean recursion(TreeNode L, TreeNode R) {
        // 空，对称
        if (L == null && R == null)
            return true;
        // 根不同，不对称
        if (L == null || R == null || L.val != R.val)
            return false;
        // 若L的left和R的right相同，L的right和R的left相同，说明此树对称
        return recursion(L.left, R.right) && recursion(L.right, R.left);
    }
}
