/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 如果要删除头结点，直接返回下一个结点即可
        if (head.val == val) 
            return head.next;

        // 迭代
        ListNode pre = null;
        ListNode cur = head;
        while(cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 退出循环后，cur指向的就是要删除的结点
        pre.next = cur.next;
        return head;
    }
}
