/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /**
 感觉写的有点麻烦
 总体思路就是把链表切成三段
 before + reverse + after
 before的最后一个节点指向reverse
 reverse的最后一个节点指向after
 就完成的局部的链表反转
 **/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {   
        if(head==null||head.next==null||m==n){
            return head;
        }
        //切断链表
        ListNode before = head;
        ListNode pre = null;
        ListNode cut = head;
        int cnt = 1;
        while(cnt!=m){
            pre = cut;
            cut = cut.next;
            cnt++;
        }
        if(pre!=null)
            pre.next = null;
        cnt = 0;
        ListNode reverse = cut;
        while(cnt!=n-m){
            cut = cut.next;
            cnt++;
        }

        ListNode after = cut.next;
        cut.next = null; 

        ListNode before_end = before;
        if(m==1){
            before_end = null;
        }else{
            while(before_end.next!=null){
                before_end = before_end.next;
            }
        }
        
        reverse = reverseList(reverse);
 
        ListNode cut_end = reverse;
        while(cut_end.next!=null){
            cut_end = cut_end.next;
        }

        if(before_end!=null)
            before_end.next = reverse;
        cut_end.next = after;

        return before_end==null ? reverse : before;
    }

    public ListNode reverseList(ListNode list){
        //将list进行翻转
        ListNode pre = null;
        ListNode cur = list;
        
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        } 
        return pre;
    }
}