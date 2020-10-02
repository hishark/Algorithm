// ref: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode-solution/
// 中等（？应该放简单吧
// 递归 
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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // 后序遍历
        postOrder(root, ans);
        return ans;
    }

    // 递归实现后序遍历，「左右根」
    public void postOrder(TreeNode root, List<Integer> ans) {
        // 递归出口，根为空直接结束后序遍历
        if (root == null)
            return;
        
        // 左
        postOrder(root.left, ans);
        // 右
        postOrder(root.right, ans);
        // 根
        ans.add(root.val);
    }
}

/**
 * 时间复杂度：O(n)。其中n是二叉树的结点数，每一个结点正好遍历一次。
 * 空间复杂度：O(n)。空间占用主要来自于递归过程中栈的开销，平均情况下为O(logn)，最坏情况下树为链状，空间复杂度为O(n)。
 */

 

// 迭代
// 和递归的方法其实是等价的，区别在于递归的时候隐式地维护了一个栈，而在迭代的时候需要显式的模拟一个栈
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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        
        // 判空
        if (root == null)
            return ans;
        
        // 双向队列
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                // 一直往左搜索
                root = root.left;
            }

            // 搜索到了最左边，拿出一个结点
            root = stack.pop();

            // 查看此结点的
            if (root.right == null || root.right == pre) {
                ans.add(root.val);
                pre = root;
                root = null;
            } else { 
                stack.push(root);
                root = root.right;
            }
        }

        return ans;
    }
}

/**
 * 时间复杂度：O(n)，其中 n 是二叉树的结点数，每一个结点正好会被遍历一次。
 * 空间复杂度：O(n)，迭代的过程中显式栈会产生空间开销，平均情况下为 O(logn)，最坏情况下树为链状，此时复杂度为O(n)。
 */