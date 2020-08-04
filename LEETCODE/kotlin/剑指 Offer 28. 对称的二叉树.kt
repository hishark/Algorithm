/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        // 空树显然对称
        // 非空树，检查左右子树是否对称
        return if (root == null) true else recursion(root.left, root.right)
        
    }

    // 检查L和R是否对称
    fun recursion(L: TreeNode?, R: TreeNode?): Boolean {
        // 空，对称
        if (L == null && R == null)
            return true
        // 根不同，不对称
        // 若L的left和R的right相同，L的right和R的left相同，说明此树对称
        return if (L == null || R == null || L.`val` != R.`val`) false 
        else recursion(L.left, R.right) && recursion(L.right, R.left)
    }
}
