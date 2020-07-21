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
    fun generateTrees(n: Int): List<TreeNode?> {
        return if (n == 0)
            mutableListOf<TreeNode?>()
        else
            generateTrees(1, n)
    }

    fun generateTrees(start: Int, end: Int): List<TreeNode?> {
        val allTress = mutableListOf<TreeNode?>()

        // 递归出口，此时不存在一棵BST，直接返回null
        if (start > end) {
            allTress.add(null)
            return allTress
        }

        // 枚举[start, end]中的值作为根节点
        for (i in start..end) {
            // 左子树
            val leftTrees = generateTrees(start, i - 1)

            // 右子树
            val rightTrees = generateTrees(i + 1, end)

            // 遍历左右子树，和根节点i生成一棵BST
            for (leftTree in leftTrees) {
                for (rightTree in rightTrees) {
                    // 根节点
                    val root = TreeNode(i)
                    // 左子树
                    root.left = leftTree
                    // 右子树
                    root.right = rightTree

                    allTress.add(root)
                }
            }
        }

        return allTress
    }
}
