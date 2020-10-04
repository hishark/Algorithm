// ref: https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
// medium

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化
        // 结果链表的头节点
        ListNode head = new ListNode(0); //值任意，反正没有任何意义
        // 当前节点，用于向结果链表插入节点，初始化时指向head
        ListNode cur = head;
        // 进位，初始值为0
        int carry = 0;

        // 当且仅当l1和l2都为空时，才终止遍历链表
        // 也就是说只要有一方不为空，就会一直遍历下去
        while (l1!=null || l2!=null) {
            // 先判断一下l1和l2之间是否有指针为空
            // 如果有为空的，就给它补上0，用于相加
            // 不为空就直接取到节点的值
            int x1 = l1 == null ? 0 : l1.val;
            int x2 = l2 == null ? 0 : l2.val;

            // 两数之和
            int sum = x1 + x2 + carry;

            // 更新进位的值
            carry = sum / 10;
            // 求余数，用于插入结果链表
            sum = sum % 10;
            cur.next = new ListNode(sum);

            // 移动cur
            cur = cur.next;

            // 移动l1和l2
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }

        // 结束循环后，判断carry是否为1，若为1就添加到结果链表的最后
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        
        // 返回结果链表
        return head.next;
    }
}