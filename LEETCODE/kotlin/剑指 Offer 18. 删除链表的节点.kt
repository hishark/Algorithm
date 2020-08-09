class Solution {
    fun deleteNode(head: ListNode, `val`: Int): ListNode {
        // 如果要删除头结点
        if (head.`val` === `val`)
            return head.next

        var pre: ListNode? = null
        var cur = head
        while (cur.`val` !== `val`) {
            pre = cur
            cur = cur.next
        }
        pre!!.next = cur.next
        return head
    }
}
