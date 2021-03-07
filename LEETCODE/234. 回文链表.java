//借用另外的数组，将题目转换为了判断回文数组
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 如果链表为空，或者只有一个节点，直接返回true即可
        if(head==null || head.next==null){
            return true;
        }
        // 工具人 temp
        ListNode temp = head;
        int length = 0;
        // 遍历链表求得链表长度
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        // 新建一个数组用来存储链表中的值
        int[] nums = new int[length];
        int i = 0;
        while(head!=null){
            nums[i] = head.val;
            head = head.next;
            i++;ß
        }
        // 头尾指针收缩判断，一旦遇到不同的字符就返回false
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

// 使用快慢指针找到链表中点后，反转后半段链表，再进行比较即可
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 如果链表为空或者只有一个节点，返回true即可。
        if(head == null || head.next == null)
            return true;
        
        // 借助快慢指针找到链表中点，
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        
        // 链表的中点
        ListNode mid = slow.next;
        slow.next = null; //断开前半段链表
        
        //反转后半段链表
        ListNode cur = mid, pre = null;
        while(cur!=null){
            ListNode curTemp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curTemp;
        }
        
        // 最后比较两段链表对应位置的value
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
