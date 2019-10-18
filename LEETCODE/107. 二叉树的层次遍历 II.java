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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //队列用于层序遍历
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null)
            return list;
        //插入根结点
        queue.offer(root);
        while(!queue.isEmpty()){
            int curLevelNum = queue.size();//当前层数的结点数
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0;i<curLevelNum;i++){
                TreeNode curNode = queue.poll();//返回队列中的第一个结点并删除
                //记得判断当前结点是否为空结点，若为空就跳过。
                if(curNode!=null){
                    subList.add(curNode.val);
                    queue.offer(curNode.left);
                    queue.offer(curNode.right);
                }
            }
            
            if(subList.size()>0){
                //题目要求倒序，插到前面
                list.add(0, subList);
            }
        }
        return list;
    }
}
