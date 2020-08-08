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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null)
            return l2
        if (l2 == null)
            return l1
        if (l1!!.`val` <= l2!!.`val`) {
            l1!!.next = mergeTwoLists(l1!!.next, l2)
            return l1
        } else {
            l2!!.next = mergeTwoLists(l2!!.next, l1)
            return l2
        }
    }
}
