/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//二分法 递归
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length-1);
    }
    
    public TreeNode recursion(int[] nums, int begin, int end){
        if(begin>end)
            return null;
        int mid = begin + (end - begin)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(nums, begin, mid-1);
        root.right = recursion(nums, mid+1, end);
        return root;
    }
}
