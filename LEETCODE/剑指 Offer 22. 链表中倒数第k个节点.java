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
        // 双指针
        ListNode pre = head;
        ListNode aft = head;

        // 先将 pre 移动到第 k 个结点的位置
        for(int i=0;i<k;i++) {
            pre = pre.next;
        }

        // 然后同时移动两个指针 pre 和 aft，直到 pre 为空，此时 aft 指向的就是倒数第 k 个结点。
        while (pre != null) {
            pre = pre.next;
            aft = aft.next;
        }

        // 返回aft即可
        return aft;
    }
}