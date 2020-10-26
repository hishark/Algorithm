/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 使用两个指针 nodeA 和 nodeB 分别指向链表 headA 和 headB
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        /**
         * nodeA 逐个结点进行遍历，当遍历到最后一个结点时，转而指向 headB 
         * nodeB 逐个结点进行遍历，当遍历到最后一个结点时，转而指向 headA
         * 当二者相遇时，则为他们的第一个公共结点
         */
        while (nodeA != nodeB) {
            nodeA = nodeA.next == null ? headB : nodeA.next;
            nodeB = nodeB.next == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}