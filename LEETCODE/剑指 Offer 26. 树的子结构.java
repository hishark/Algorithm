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
    /**
     * 
     * @param A
     * @param B
     * @return 判断B树是否是A树的子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        /**
         * 特判：
         *  如果A为空树或者B为空树时，直接返回false
         */
        if (A == null || B == null)
            return false;

        /**
         * 判断B是否是A的子结构，需要判断：
         *  1. 以结点A为根节点的树是否包含树B recur(A, B)
         *  2. B树是否是A的左子树的子结构
         *  3. B树是否是A的右子树的子结构
         */
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 
     * @param A
     * @param B
     * @return 判断以结点A为根节点的树是否包括树B
     */
    boolean recur(TreeNode A, TreeNode B) {
        // 1. 当结点B为空，说明树B的遍历已经越过叶子结点，匹配完成，返回true
        if(B == null) 
            return true;

        // 2. 当结点A为空，说明树A的遍历已经越过叶子结点，此时说明至今未找到树B的子结构，匹配失败，返回false
        // 3. 当A和B的值不相等时，必然匹配失败，返回false
        if(A == null || A.val != B.val) 
            return false;

        // 以上三种情况都没发生，说明当前A和B结点的值相同，匹配成功，可以继续匹配下一个，接着遍历左右子树即可
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}