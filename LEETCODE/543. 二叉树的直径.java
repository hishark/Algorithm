/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //需要遍历每一个结点来更新maxNodeNum（每一条路径经过的结点数中的最大值）
 class Solution {
    int maxNodeNum;
    public int diameterOfBinaryTree(TreeNode root) {
        maxNodeNum = 1;//开始的时候只有根结点，所以为1
        depth(root);//遍历整棵树
        return maxNodeNum - 1;//结点数-1就是路径长度啦
    }

    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        maxNodeNum = Math.max(maxNodeNum, left + right + 1);
        return Math.max(left, right) + 1;
    }
}