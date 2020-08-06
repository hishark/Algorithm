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
    int ans, kk;
    public int kthLargest(TreeNode root, int k) {
        // kk作为全局变量使用
        kk = k;
        // 对二叉搜索树进行中序遍历
        dfs(root);
        // 返回结果
        return ans;
    }

    // 中序遍历的遍历：右根左
    public void dfs(TreeNode root) {
        if (root ==  null)
            return;

        // 右
        dfs(root.right);

        // 找到了第k大的元素，记录下来
        if (--kk == 0)
            ans = root.val;

        // kk已经找到了，返回即可
        if (kk == 0)
            return;

        // 左
        dfs(root.left);
    }
}
