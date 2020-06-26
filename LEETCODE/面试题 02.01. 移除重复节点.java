/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 空值处理
        if (head==null) 
            return null;
        // HashSet无法存储相同的值，利用这个特点，来不重复的存储节点值
        Set<Integer> hashSet = new HashSet<>();

        // 上一个节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        // 初始化
        hashSet.add(cur.val);
        pre = cur;
        cur = cur.next;

        // 当前节点不为空时一直循环
        while (cur!=null) {
            // HashSet中不存在当前节点就添加进去，并且移动pre和cur
            if (!hashSet.contains(cur.val)) {
                hashSet.add(cur.val);
                pre = cur;
                cur = cur.next;
            } else {
                // 如果HashSet中存在当前节点，就删除当前节点
                pre.next = cur.next;

                // 如果已经到了最后一个节点，直接结束循环
                if(pre.next == null)
                    break;
                else {
                    // 这里只需要移动cur，不需要移动pre
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
