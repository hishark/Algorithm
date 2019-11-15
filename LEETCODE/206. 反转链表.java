/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 画个图贼清晰
 */
//递归
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) 
        return head;
    ListNode reversed = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversed;
}

//迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur!=null){
            ListNode curNextTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNextTemp;
        }
        return pre;
    }
}
