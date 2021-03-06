
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
 // 递归
class Solution {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        // 递归出口：遍历到叶子结点时返回空
        if (root == null)
            return null

        // 利用工具人tmp暂存一下左子树
        val tmp = root.left
        // 递归右子树，把返回值作为root的左子树
        root.left = mirrorTree(root.right)
        // 递归左子树，把返回值作为root的右子树
        root.right = mirrorTree(tmp)
        // 返回根节点
        return root
    }
}

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
// 辅助栈
class Solution {
    fun mirrorTree(root: TreeNode?): TreeNode? {
        // 特判，根为空直接返回空
        if (root == null)
            return null

        // 辅助栈
        val stack = Stack<TreeNode>()

        // 初始化，添加根结点
        stack.add(root)

        // 当辅助栈为空时跳出循环
        while (!stack.isEmpty()) {
            // 先把当前结点pop出来
            val curNode = stack.pop()

            // 如果当前节点的左结点不为空，就把左节点加入到辅助栈中
            if (curNode.left != null)
                stack.add(curNode.left)
            // 如果当前节点的右结点不为空，就把右节点加入到辅助栈中
            if (curNode.right != null)
                stack.add(curNode.right)

            // 交换当前结点的左右结点
            val tmp = curNode.left
            curNode.left = curNode.right
            curNode.right = tmp
        }

        // 返回root，此时已经完成镜像
        return root
    }
}