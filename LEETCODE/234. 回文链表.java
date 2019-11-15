//借用另外的数组
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode temp = head;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        int[] nums = new int[length];
        int i = 0;
        while(head!=null){
            nums[i] = head.val;
            head = head.next;
            i++;
        }
        int begin = 0, end = length-1;
        while(begin<end){
            if(nums[begin]!=nums[end]){
                return false;
            }else{
                begin++;
                end--;
            }
        }
        return true;
    }
}

//使用快慢指针找到链表中点后，反转后半段链表，再进行比较
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        
        //快慢指针找到链表中点，
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;//找到链表的中点
        slow.next = null;//断开前半段链表
        
        //反转后半段链表
        ListNode cur = mid, pre = null;
        while(cur!=null){
            ListNode curTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curTemp;
        }
        
        //比较两段链表对应位置的value
        ListNode newHead = pre;
        while(newHead!=null){
            if(head.val!=newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
