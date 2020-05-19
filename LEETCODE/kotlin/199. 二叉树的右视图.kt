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
    var ans = ArrayList<Int>()

    fun rightSideView(root: TreeNode?): List<Int> {
        dfs(root, 0)
        return ans;
    }

    fun dfs(root: TreeNode?, d: Int) {
        // 直接用d会说d不可重新赋值，但是又不让我声明d是var，kotlin还不太熟这个问题待解决
        var depth = d
        if(root == null) return
        if(depth == ans.size) ans.add(root.`val`)
        depth++
        dfs(root.right, depth)
        dfs(root.left, depth)
    }
}