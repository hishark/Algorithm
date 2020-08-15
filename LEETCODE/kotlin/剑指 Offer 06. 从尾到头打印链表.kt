/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
 
// 栈
class Solution {
    fun reversePrint(head: ListNode?): IntArray {
        var head = head
        val stack = Stack<Int>()
        var len = 0
        while (head != null) {
            stack.push(head!!.`val`)
            head = head!!.next
            len++
        }
        val res = IntArray(len)
        var i = 0

        while (!stack.empty()) {
            res[i++] = stack.pop()
        }

        return res
    }
}

// 写递归 报错 Line 46: Exception in thread "main" java.lang.IllegalStateException: param_1 must not be null
