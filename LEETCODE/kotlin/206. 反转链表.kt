//迭代
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null
        var cur: ListNode? = head
        while (cur!=null) {
            var tmp: ListNode? = cur.next
            cur.next = pre
            pre = cur
            cur = tmp
        }
        return pre;
    }
}
//递归
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        if(head==null || head.next==null)
            return head
        val cur: ListNode? = reverseList(head.next)
        head.next.next = head
        head.next = null
        return cur
    }
}