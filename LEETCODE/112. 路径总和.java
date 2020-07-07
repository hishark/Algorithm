/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 法1 递归
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null && sum-root.val==0)
            return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);//记得减去root.val
    }
}

// 法2 BFS
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 空树
        if (root == null) 
            return false;


        // 定义两个队列，一个存储要遍历的节点，一个存储根节点到这些节点的路径和
        // 两个队列的值一一对应
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueValue = new LinkedList<Integer>();

        // 初始化，将根节点入队
        queueNode.offer(root);
        queueValue.offer(root.val);

        // 队列不为空时一直循环计算
        while (!queueNode.isEmpty()) {
            // 取出队头节点
            TreeNode curNode = queueNode.poll();
            int curVal = queueValue.poll();

            // 如果此节点为叶子结点
            // 判断该节点的值是否等于sum，若等于就返回true
            if (curNode.left == null && curNode.right == null) {
                if (curVal == sum) 
                    return true;
                // 只要节点为叶子结点就直接continue
                continue;
            }

            // 若当前节点的左子树不为空，就让左子树入队
            if (curNode.left != null) {
                queueNode.offer(curNode.left);
                queueValue.offer(curNode.left.val + curVal); // 千万别忘记加上curVal！在累积和啊！
            }

            // 若当前节点的右子树不为空，就让右子树入队
            if (curNode.right != null) {
                queueNode.offer(curNode.right);
                queueValue.offer(curNode.right.val + curVal);
            }
        }

        // 如果整个while循环都没找到符合条件的路径和，表示不存在，返回false
        return false;
    }
}
