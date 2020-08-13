/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while(tmp != null) {
            length++;
            tmp = tmp.next;
        }

        int[] res = new int[length];
        int index = length - 1;

        while(head != null && index >= 0) {
            res[index] = head.val;
            head = head.next;
            index--;
        }

        return res;
    }
}
