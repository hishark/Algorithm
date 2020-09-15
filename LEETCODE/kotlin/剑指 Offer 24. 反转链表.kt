/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

 // 递归
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // 递归终止条件
        if (head == null || head!!.next == null)
            return head

        /**
         * 假设链表为1->2->3->4->5
         * 最后一层递归返回的cur就是最后一个节点5
         */
        val cur = reverseList(head!!.next)
        // 此时的head是4，下面这个操作就是让5指向4，完成一次反转
        head!!.next.next = head
        // 4的next本来是5，现在置为空，防止产生循环
        head!!.next = null
        // 返回cur即可
        return cur
    }
}

// 双指针
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    fun reverseList(head: ListNode): ListNode? {
        // 指向cur的前一个结点
        var pre: ListNode? = null
        // cur最先指向head
        var cur: ListNode? = head
        // tmp工具人用来保存cur的下一个结点
        var tmp: ListNode? = null

        // cur遍历整个链表，当cur指向空，遍历就结束了
        while (cur != null) {
            tmp = cur!!.next
            cur!!.next = pre
            pre = cur
            cur = tmp
        }

        // 别写成cur了，退出上面的循环之后cur就为空了
        return pre
    }
}
// 测试样例为[]时报错 Exception in thread "main" java.lang.IllegalStateException: param_1 must not be null 应该是kotlin不允许参数为空