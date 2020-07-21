/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n==0)
            return new ArrayList<>();
        else 
            return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTress = new ArrayList<>();
        
        // 递归出口，此时不存在一棵BST，直接返回null
        if (start > end) {
            allTress.add(null);
            return allTress;
        }

        // 枚举[start, end]中的值作为根节点
        for (int i=start;i<=end;i++) {
            // 左子树
            List<TreeNode> leftTrees = generateTrees(start, i-1);

            // 右子树
            List<TreeNode> rightTrees = generateTrees(i+1, end);

            // 遍历左右子树，和根节点i生成一棵BST
            for (TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree: rightTrees) {
                    // 根节点
                    TreeNode root = new TreeNode(i);
                    // 左子树
                    root.left = leftTree;
                    // 右子树
                    root.right = rightTree;
                    
                    allTress.add(root);
                }
            }
        }

        return allTress;
    }
}
