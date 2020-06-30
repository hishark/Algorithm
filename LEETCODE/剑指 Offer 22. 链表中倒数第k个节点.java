/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        ListNode tmp = head;
        int length = 0;
        while (tmp!=null) {
            tmp = tmp.next;
            length++;
        }
        int index = length - k + 1;
        int i = 1;
        while (i!=index) {
            head = head.next;
            i++;
        }
        res.next = head;


        return res.next;
    }
}
