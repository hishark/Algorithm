class Solution {
    public ListNode partition(ListNode head, int x) {
        // 双指针
        // left 链表储存小于 x 的结点
        ListNode left = new ListNode(0);
        // left 会不停地移动，由于后面还需要用到所以使用 leftTmp 记下初始位置
        ListNode leftTmp = left;
        // right 链表储存大于等于 x 的结点
        ListNode right = new ListNode(0);
        // right 会不停地移动，由于后面还需要用到所以使用 rightTmp 记下初始位置
        ListNode rightTmp = right;
        // 遍历链表
        while (head != null) {
            // 小于 x 的结点全部放到 left 链表中
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                // 大于等于 x 的结点全部放到 right 链表中
                right.next = head;
                right = right.next;
            }
            // head 移向下一个结点
            head = head.next;
        }
        // 把两个链表串起来即可
        right.next = null;
        left.next = rightTmp.next;
        return leftTmp.next;
    }
}
// ref：https://leetcode-cn.com/problems/partition-list/solution/fen-ge-lian-biao-by-leetcode-solution-7ade/
