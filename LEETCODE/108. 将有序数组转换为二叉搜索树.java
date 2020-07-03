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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
    
    public TreeNode dfs(int[] nums, int left, int right) {
        // 如果左大于右，返回null
        if (left>right)
            return null;
        
        // 找中点
        int mid = left + (right - left) / 2;
        
        // 中点位置的元素作为根结点
        TreeNode root = new TreeNode(nums[mid]);
        
        // 递归构建左子树
        root.left = dfs(nums, left, mid - 1);
        
        // 递归构建右子树
        root.right = dfs(nums, mid + 1, right);

        // 返回根结点
        return root;
    }
}
