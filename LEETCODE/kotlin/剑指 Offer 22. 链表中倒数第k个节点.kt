/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    fun getKthFromEnd(head: ListNode, k: Int): ListNode {
        // 双指针
        var pre: ListNode? = head
        var aft = head

        // 先将pre移动到第k个结点的位置
        for (i in 0 until k) {
            pre = pre!!.next
        }

        // 然后同时移动两个指针pre和aft，直到pre为空，此时aft指向的就是倒数第k个结点
        while (pre != null) {
            pre = pre!!.next
            aft = aft.next
        }

        // 返回aft即可
        return aft
    }
}