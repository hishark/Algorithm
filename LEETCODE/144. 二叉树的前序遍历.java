// 递归
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序遍历的结果
        List<Integer> res = new ArrayList<Integer>();
        // 递归
        preorder(root, res);
        // 返回结果
        return res;
    }

    // 前序遍历
    public void preorder(TreeNode root, List<Integer> res) {
        // 递归出口
        if (root == null) {
            return;
        }
        // 根
        res.add(root.val);
        // 左
        preorder(root.left, res);
        // 右
        preorder(root.right, res);
    }
}

// ref：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/

// 迭代
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序遍历结果
        List<Integer> res = new ArrayList<Integer>();
        // 空树直接返回即可
        if (root == null) {
            return res;
        }
        // 模拟递归方法中的栈
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        // 当前遍历节点
        TreeNode node = root;
        // 栈为空停止循环
        while (!stack.isEmpty() || node != null) {
            // 当前遍历的节点不为空
            while (node != null) {
                // 添加至遍历序列
                res.add(node.val);
                // 压入栈中
                stack.push(node);
                // 遍历左子树
                node = node.left;
            }
            // 一直到没有左子树之后，再从栈中取出节点
            node = stack.pop();
            // 查找其右子树
            node = node.right;
        }
        return res;
    }
}