import java.util.LinkedList;

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
    // 结果列表
    LinkedList<List<Integer>> res = new LinkedList<>();
    // 路径
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursion(root, sum);
        return res;
    }

    public void recursion(TreeNode root, int sum) {
        // 判空
        if (root == null)
            return;

        // 首先把根结点加入到路径中
        path.add(root.val);
        // 路径和减去根结点的值
        sum -= root.val;

        // 此时需要判断一下路径和是否等于 0 且根结点不存在左右结点，若成立，把此时的路径添加到结果中
        if (sum == 0 && root.left == null & root.right == null)
            res.add(new LinkedList(path));
        
        // 递归左右子树
        recursion(root.left, sum);
        recursion(root.right, sum);

        // 回溯，删去此时路径中的最后一个结点
        path.removeLast();


    }
    
}