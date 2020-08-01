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
        if (root == null)
            return new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            int i = 0;
            List<Integer> curList = new ArrayList<>();
            while (i < curSize) {
                TreeNode curNode = queue.poll();
                curList.add(curNode.val);
                
                if(curNode.left != null)
                    queue.offer(curNode.left);
                
                if(curNode.right != null)
                    queue.offer(curNode.right);
                
                i++;
            }
            
            resList.add(curList);
        }

        return resList;
    }
}
