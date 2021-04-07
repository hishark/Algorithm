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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 判空
        if (root == null)
            return new ArrayList<>();

        // BFS 需要使用队列存储遍历结点
        Queue<TreeNode> queue = new LinkedList<>();
        // 首先把根结点放入队列
        queue.offer(root);
        // 最终的遍历结果
        List<List<Integer>> resList = new ArrayList<>();

        // 队列为空时停止循环
        while (!queue.isEmpty()) {
            // 记录下队列此时的长度，用于
            int curSize = queue.size();
            // 工具人 i
            int i = 0;
            // 当前层次的遍历结果
            List<Integer> curList = new ArrayList<>();
            // 对此时队列中的所有结点依次进行判断
            while (i < curSize) {
                // 取出队头结点作为当前结点
                TreeNode curNode = queue.poll();
                // 把当前结点加入当前层次的遍历结果数组
                curList.add(curNode.val);
                
                // 判断当前结点的左右结点是否为空
                // 如果不为空，就把节点加入到队列中，用于之后的遍历
                if(curNode.left != null)
                    queue.offer(curNode.left);
                if(curNode.right != null)
                    queue.offer(curNode.right);
                
                // 工具人自增
                i++;
            }
            
            // 把当前层次的遍历结果放入最终结果中，继续下一层的遍历
            resList.add(curList);
        }

        // 返回即可
        return resList;
    }
}
// cnt: 1