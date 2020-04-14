/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
  * 执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗 :39.8 MB, 在所有 Java 提交中击败了95.83%的用户
  */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //计算链表长度，保证l1是更长的链表
        int length1 = 0, length2 = 0;
        ListNode len1 = l1, len2 = l2;
        while(len1.next!=null){
            length1++;
            len1 = len1.next;
        }
        while(len2.next!=null){
            length2++;
            len2 = len2.next;
        }
        if(length1<length2){
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }

        //翻转链表
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode pre1 = l1, cur1 = l1;
        ListNode cur2 = l2;
        //进位
        int carry = 0;
        while(cur1!=null || cur1!=null){
            //当前节点的值
            int val1 = (cur1 == null) ? 0 : cur1.val;
            int val2 = (cur2 == null) ? 0 : cur2.val;

            //当前两个节点相加，再加上进位的值
            int val = (val1 + val2 + carry) % 10 ;
            //算出新的进位
            carry = (val1 + val2 + carry) / 10;
            //把相加之后的新的值存入cur1
            cur1.val = val;
            
            //指向下一个节点，这么写是为了防止空指针报错
            cur1 = (cur1 == null) ? null : cur1.next;
            cur2 = (cur2 == null) ? null : cur2.next;
        }
        //如果还有一个进位，就添加到链表的最后
        ListNode ans = pre1;
        while(pre1.next!=null){
            pre1 = pre1.next;
        }
        if(carry>0){
            pre1.next = new ListNode(carry);
        }

        //翻转之后就得到最终的结果
        ans = reverseList(ans);

        return ans;
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