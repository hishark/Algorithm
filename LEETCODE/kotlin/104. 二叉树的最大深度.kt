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
// 递归dfs
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else Math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}

// 迭代bfs
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        // 判空
        if (root == null) return 0

        // 队列，一层层的搜索时，用于存放当前层的所有结点
        val queue = LinkedList<TreeNode>()
        queue.offer(root)

        // 二叉树的层数
        var ans = 0

        while (!queue.isEmpty()) {
            // 二叉树当前层的结点数目
            var curSize = queue.size

            // 遍历当前层的所有结点，把它们的左右子结点都加入到队列里，用于下一次循环（外层）
            while (curSize != 0) {
                val cur = queue.poll()
                if (cur.left != null) {
                    queue.offer(cur.left)
                }
                if (cur.right != null) {
                    queue.offer(cur.right)
                }
                curSize--
            }

            // 每遍历一层，就增加层数
            ans++
        }

        // 二叉树的层数即二叉树的最大深度
        return ans
    }

}
