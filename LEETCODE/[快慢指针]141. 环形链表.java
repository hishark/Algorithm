/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 运动是相对的，快指针相对于慢指针，就相当于慢指针静止，快指针每次移动一步。这样只要是在环中，快指针肯定会与慢指针相遇。
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode l1 = head,l2 = head.next;
        while(l1!=null&l2!=null&l2.next!=null){
            //两个指针相遇了就是有环啦！
            if(l1==l2){
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}