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
    fun removeDuplicateNodes(head: ListNode?): ListNode? {
        // 空值处理
        if (head==null) 
            return null
        // Set无法存储相同的值，利用这个特点，来不重复的存储节点值
        var hashSet = mutableSetOf<Int>()

        // 上一个节点
        var pre: ListNode? = null
        // 当前节点
        var cur: ListNode? = head
        // 初始化
        hashSet.add(cur!!.`val`)
        pre = cur
        cur = cur.next

        // 当前节点不为空时一直循环
        while (cur!=null) {
            // HashSet中不存在当前节点就添加进去，并且移动pre和cur
            if (!hashSet.contains(cur.`val`)) {
                hashSet.add(cur.`val`)
                pre = cur
                cur = cur.next
            } else {
                // 如果HashSet中存在当前节点，就删除当前节点
                pre?.next = cur.next

                // 如果已经到了最后一个节点，直接结束循环
                if(pre?.next == null)
                    break
                else 
                    cur = cur.next // 这里只需要移动cur，不需要移动pre
                
            }
        }
        return head
    }
}
