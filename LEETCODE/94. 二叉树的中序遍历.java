// 递归
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历结果
        List<Integer> ans = new ArrayList<Integer>();
        // 递归
        inorder(root, ans);
        // 返回结果即可
        return ans;
    }

    /**
     * 中序遍历
     * @param root 树的根结点
     * @param ans 中序遍历的结果
     */
    public void inorder(TreeNode root, List<Integer> ans) {
        // 遍历到空结点时，结束递归
        if (root == null) {
            return;
        }
        // 中序遍历：左，根，右
        // 左
        inorder(root.left, ans);
        // 根
        ans.add(root.val);
        // 右
        inorder(root.right, ans);
    }
}

// ref：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/

// 栈
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历结果
        List<Integer> ans = new ArrayList<Integer>();
        // 模拟一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 根为空或者栈为空时
        while (root != null || !stack.isEmpty()) {
            // 一直往根结点的左子树走，把结点全部放入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 拿出栈顶结点
            root = stack.pop();
            // 放入结果数组
            ans.add(root.val);
            // 如果root存在右子树就往右子树走
            root = root.right;
        }
        // 返回结果即可
        return ans;
    }
}