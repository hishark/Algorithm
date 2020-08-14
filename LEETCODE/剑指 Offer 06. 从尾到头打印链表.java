/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 简单粗暴无脑法，反转链表再输出
class Solution {
    public int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while(tmp != null) {
            length++;
            tmp = tmp.next;
        }

        int[] res = new int[length];
        int index = length - 1;

        while(head != null && index >= 0) {
            res[index] = head.val;
            head = head.next;
            index--;
        }

        return res;
    }
}

// 栈
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = 0;
        while (head!=null) {
             stack.push(head.val);
             head = head.next;
             len++;
        }
        int[] res = new int[len];
        int i = 0;

        while (!stack.empty()) {
            res[i] = stack.pop();
            i++;
        }

        return res;
    }
}

// 递归
class Solution {
    ArrayList<Integer> tmp = new ArrayList<Integer>();

    public int[] reversePrint(ListNode head) {
        recursion(head);
        int[] res = new int[tmp.size()];
        for (int i=0;i<res.length;i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    // 递归的从尾到头添加结点值到tmp
    // 每访问一个节点的时候，先递归添加它后面的结点，再添加它本身
    public void recursion(ListNode head) {
        if(head == null)
            return;
        recursion(head.next);
        tmp.add(head.val);
    }
}
