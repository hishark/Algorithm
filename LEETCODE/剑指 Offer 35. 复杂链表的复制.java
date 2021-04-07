/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // 利用哈希表进行链表复制
        HashMap<Node, Node> map = new HashMap<>();
        
        // 使用工具人 cur 指向头结点 head，用于做复制操作
        Node cur = head;

        // 第一步，先复制所有结点的值
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // 第二步，复制所有结点 next 和 random 的指向
        // 将 cur 重新指向头结点
        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        // 此时已经全部串起来了，返回 head 即可
        return map.get(head);
    }
}
// read: 0