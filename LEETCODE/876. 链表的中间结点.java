/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode[] A = new ListNode[101];
        int i = 0;
        while (head != null) {
            A[i++] = head;
            head = head.next;
        }
        return A[i / 2];
    }
}