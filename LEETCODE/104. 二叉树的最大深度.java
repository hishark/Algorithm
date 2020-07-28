/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 递归DFS
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) ,maxDepth(root.right)) + 1;
    }
}

// 迭代BFS
class Solution {
    public int maxDepth(TreeNode root) {
        // 判空
        if(root == null) return 0;
    
        // 队列，一层层的搜索时，用于存放当前层的所有结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 二叉树的层数
        int ans = 0;

        while(!queue.isEmpty()) {
            // 二叉树当前层的结点数目
            int curSize = queue.size();
            
            // 遍历当前层的所有结点，把它们的左右子结点都加入到队列里，用于下一次循环（外层）
            while(curSize!=0) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left); 
                }
                if(cur.right != null) {
                    queue.offer(cur.right); 
                }
                curSize--;
            }
            
            // 每遍历一层，就增加层数
            ans++;
        }

        // 二叉树的层数即二叉树的最大深度
        return ans;
    }

}
