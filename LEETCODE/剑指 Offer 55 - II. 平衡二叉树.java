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
    public boolean isBalanced(TreeNode root) {
        int height = tree_height(root);
        return height != -1;
    }
    
    public int tree_height(TreeNode root){
        if(root == null)
            return 0;
        int left_height = tree_height(root.left);
        int right_height = tree_height(root.right);
        if(left_height==-1 || right_height==-1 || left_height-right_height>1 || right_height-left_height>1)
            return -1;
        return (left_height > right_height ? left_height : right_height) + 1;//别忘记+1啊！！
    }
}
