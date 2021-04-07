// ref: Krahets
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
    public int[] levelOrder(TreeNode root) {
        // 判空
        if (root == null)
            return new int[0];

        // BFS 需要使用队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 先把根节点放入队列
        queue.offer(root);

        // 打印结果数组
        ArrayList<Integer> res = new ArrayList<>();

        // 队列为空时结束循环
        while (!queue.isEmpty()) {
            // 取出队头结点作为当前结点
            TreeNode curNode = queue.poll();
            // 先把当前结点放入结果数组
            res.add(curNode.val);
            // 然后开始判断当前结点的左右结点是否存在
            // 如果存在的话，将其放入队列
            if (curNode.left != null)
                queue.add(curNode.left);
            if (curNode.right != null )
                queue.add(curNode.right);
        }

        // 将ArrayList转换为int[]即可
        int[] finalRes = new int[res.size()];
        for(int i=0;i<res.size();i++) 
            finalRes[i] = res.get(i);

        // 返回最终结果
        return finalRes;
    }
}
//cnt: 1