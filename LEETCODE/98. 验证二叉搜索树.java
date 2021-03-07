/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// ref：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
// 递归
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 递归判断是否为 BST
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 判断子树中所有节点的值是否都在 (left, right) 的范围内
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        // 如果全部遍历完了都合法，说明是一棵BST
        if (node == null) {
            return true;
        }
        // 
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        // 依次判断左右子树是否符合BST的要求
        // 左子树需要小于根节点的值 node.val
        // 柚子树需要大于根节点的值 node.val
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}


// 中序遍历
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 模拟一个栈（话说为什么不直接用栈Stack？）
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // 中序遍历得到的节点值
        double inorder = -Double.MAX_VALUE;

        // 栈为空时停止循环
        while (!stack.isEmpty() || root != null) {
            // 中序遍历：左中右
            // 先一直遍历到最左边的叶子节点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 从栈中取出这个最左边的叶子节点
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}