/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {

    // 假设当前遍历结点为 cur，那么 pre 是 cur 的前一个结点
    // head 为tou
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        // 判空
        if (root== null)
            return null;

        // 中序遍历访问树的各个结点，同时在遍历过程中连接前后结点
        dfs(root);

        // 构建头尾结点的引用指向
        // dfs 结束时，head 指向链表中的头结点，pre 指向尾结点，互相指向即可
        head.left = pre;
        pre.right = head;
        
        return head;
    }

    // 中序遍历二叉搜索树，可以得到一个递增序列
    public void dfs(Node cur) {
        // 递归出口
        if (cur == null)
            return;

        // 中序遍历：左，根，右
        // 左左左
        dfs(cur.left);

        // 根根根
        // 若 pre 为空，说明正在访问链表头结点，记为 head
        if (pre == null) 
            head = cur;
        else// 若 pre 不为空，将 pre 和 cur 分两步双向连接即可
            pre.right = cur; // step1

        // step2
        cur.left = pre;

        // 调整 pre 的指向
        pre = cur;

        // 右右右
        dfs(cur.right);
    }
}