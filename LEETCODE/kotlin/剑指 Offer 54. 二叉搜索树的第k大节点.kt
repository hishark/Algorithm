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
    var ans: Int = 0
    var kk: Int = 0
    fun kthLargest(root: TreeNode, k: Int): Int {
        // kk作为全局变量使用
        kk = k
        // 对二叉搜索树进行中序遍历
        dfs(root)
        // 返回结果
        return ans
    }

    // 中序遍历的遍历：右根左
    fun dfs(root: TreeNode?) {
        if (root == null)
            return

        // 右
        dfs(root.right)

        // 找到了第k大的元素，记录下来
        if (--kk == 0)
            ans = root.`val`

        // kk已经找到了，返回即可
        if (kk == 0)
            return

        // 左
        dfs(root.left)
    }
}
