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
        /**
         * 利用双端队列两头都可以添加元素的性质，假设打印列表tmp为双端队列，规定：
         * 1. 偶数层的结点添加到队列头部
         * 2. 奇数层的结点添加到队列尾部
         */
        // 借助队列存储将要遍历的结点
        Queue<TreeNode> queue = new LinkedList<>();
        
        // 层次遍历的结果
        List<List<Integer>> res = new ArrayList<>();
        
        // 判断当前处于什么层，初始化为奇数层
        boolean isOdd = true;
        
        // 判空
        if (root == null)
            return res;

        // 首先把根节点加入到队列中
        queue.add(root);

        // 队列为空时结束循环
        while (!queue.isEmpty()) {
            /**
             * 定义一个双端队列用于存储当前层次的打印结果：
             * 1. 偶数层的结点添加到队列头部
             * 2. 奇数层的结点添加到队列尾部
             */
            LinkedList<Integer> deque = new LinkedList<>();
            // 遍历当前层次的所有结点（即 queue 里的所有结点）
            for (int i=queue.size();i>0;i--) {
                // 取出 queue 的队头结点作为当前遍历结点
                TreeNode curNode = queue.poll();

                // 判断此时处于奇数层还是偶数层
                if (isOdd) 
                    deque.addLast(curNode.val); // 奇数层结点添加到双端队列尾部
                else 
                    deque.addFirst(curNode.val); // 偶数层结点添加到双端队列头部

                // 判断当前结点是否存在左右结点，如果存在就加入到 queue 中等下一层继续遍历
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
            // 把当前层次的遍历结果加入到 res 中
            res.add(deque);
            // 奇变偶 偶变奇
            isOdd = !isOdd;
        }
        return res;
    }
}