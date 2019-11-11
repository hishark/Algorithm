/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //head.val == val注意别写在前面，测试样例是[]的时候就gg啦
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head==null)
            return head;
        ListNode pre = head, p = head.next;
        while(p!=null){
            if(p.val == val){
                pre.next = p.next;
                p = p.next;
            }else{
                pre = p;
                p = p.next;
            }
        }
        return head;
    }
}
