/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//执行用时 :0 ms, 在所有 java 提交中击败了100.00%的用户
//内存消耗 :37.6 MB, 在所有 java 提交中击败了55.63%的用户
//dfs 递归
class Solution {
    public int minDepth(TreeNode root) {
        //根节点为空
        if (root == null)
            return 0;
        
        //左右子树都为空，只有根节点
        if (root.left == null && root.right == null)
            return 1;
        
        //初始化最小深度
        int min_depth = Integer.MAX_VALUE;
        
        //求最小值
        if (root.left != null)
            min_depth = Math.min(min_depth, minDepth(root.left));
        if(root.right != null)
            min_depth = Math.min(min_depth, minDepth(root.right));
        
        //又忘记+1又忘记+1
        return min_depth + 1;
    }
}
//dfs 迭代 - 太耗时了点还是递归吧 内存消耗都差不多
//执行用时 :5 ms, 在所有 java 提交中击败了5.38%的用户
//内存消耗 :38.6 MB, 在所有 java 提交中击败了36.21%的用户
class Solution {
    public int minDepth(TreeNode root) {
        //整个栈来存树的节点🌲
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root == null){
            return 0;
        }else{
            stack.add(new Pair(root, 1));
        }
        
        //初始化最小深度
        int min_depth = Integer.MAX_VALUE;
        
        //栈不为空就一直迭代下去
        while(!stack.isEmpty()){
            //弹出栈顶元素
            Pair<TreeNode, Integer> currentNode = stack.pollLast();
            
            //取出根节点
            root = currentNode.getKey();
            
            //得到当前树高
            int currentHeight = currentNode.getValue();
            
            //如果该节点的左右子树都为空，当前树高即最小深度
            if(root.left == null && root.right == null){
                min_depth = Math.min(min_depth, currentHeight);
            }
            
            //若左右子树不为空，把左右子树的根节点压入栈，左/右子树根节点的深度即currentHeight+1
            if(root.left != null){
                stack.add(new Pair(root.left, currentHeight+1));
            }
            
            if(root.right != null){
                stack.add(new Pair(root.right, currentHeight+1));
            }
        }
        
        return min_depth;
            
    }
}
