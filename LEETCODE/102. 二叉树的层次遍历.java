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
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int curLevelNum = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for(int i=0;i<curLevelNum;i++){
                TreeNode curNode = queue.poll();
                if(curNode!=null){
                    subList.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            if(subList.size()>0){
                list.add(subList);
            }
        }
        return list;
    }
}
