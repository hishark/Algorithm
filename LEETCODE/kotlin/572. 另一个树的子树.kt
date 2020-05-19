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
 //dfs
class Solution {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        return dfs(s, t)
    }
    // 判断s的子树和t是否相等
    fun dfs(s: TreeNode?, t: TreeNode?): Boolean {
        if(s==null)
            return false
        return check(s, t) || dfs(s?.left, t) || dfs(s?.right, t)
    }
    // 判断s和t是否相等
    fun check(s: TreeNode?, t: TreeNode?): Boolean {
        if(s==null&&t==null)
            return true
        if(s!=null&&t==null || s==null&&t!=null || s?.`val`!=t?.`val`) 
            return false
        return check(s?.left, t?.left) && check(s?.right, t?.right)
    }
}