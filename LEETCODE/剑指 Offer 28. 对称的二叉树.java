/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// ref: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/solution/mian-shi-ti-28-dui-cheng-de-er-cha-shu-di-gui-qing/
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
        // L和R同时越过叶子结点，为空，则该树从顶到底都对称，返回true
        if (L == null && R == null)
            return true;
        
        // 1. L和R只有一个越过叶子结点
        // 2. L的值和R的值不相等
        // 这两种情况下明显树不对称，返回false
        if ((L == null || R == null) || L.val != R.val)
            return false;
        
        // 判断L的left和R的right是否对称，L的right和R的left是否对称
        return recursion(L.left, R.right) && recursion(L.right, R.left);
    }

    public boolean recursion(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return true;
        if (A == null || B == null)
            return false;
        if (A.val == B.val) {
            return recur(A.left, B.right) && recur(A.right, B.left);
        }
        return false;
    }
}

//cnt: 1