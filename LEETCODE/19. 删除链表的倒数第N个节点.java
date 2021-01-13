class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 在 head 前面添加一个空的头结点
        ListNode preHead = new ListNode(0, head);
        // 快慢指针
        ListNode fast = head;
        ListNode slow = preHead;
        // 快指针先单独移动 n 步
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        // 然后快慢指针一起移动，直到快指针指向空
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时慢指针的下一个结点就是要删去的结点
        // 调整 next 的指向即可删去下一个结点
        slow.next = slow.next.next;
        // 返回链表
        return preHead.next;
    }
}

// ref：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/