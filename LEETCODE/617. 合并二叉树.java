class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 有一个结点为空，就返回另一个结点
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // 两个结点都不为空，将两个结点的值相加即可
        TreeNode root = new TreeNode(t1.val + t2.val);
        // 合并了当前结点后，还要对该结点的左右子树分别进行合并
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        // 返回根结点
        return root;
    }
}

// ref：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/