/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// dfs
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


//bfs
class Solution {
    public int maxDepth(TreeNode root) {
        // 判空
        if (root == null)
            return 0;
        
        // 使用队列存储节点
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 初始化，先令根节点入队
        queue.offer(root);
        
        // 二叉树深度，最后要返回的结果
        int depth = 0;
        
        while (!queue.isEmpty()) {
            // 当前层次的节点数目
            int curSize = queue.size();
            // 遍历当前层次的所有节点，并将他们的子节点都入队
            int i = 0;
            while (i < curSize) {
                TreeNode curNode = queue.poll();
                // 左右子树存在的话就将其入队
                if (curNode.left != null)
                    queue.offer(curNode.left);
                if (curNode.right != null)
                    queue.offer(curNode.right);
                i++;
            }
            // 遍历完一个层次，就将深度++
            depth++;
            
        }
        
        return depth;
    }
}
