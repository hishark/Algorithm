// https://leetcode-cn.com/problems/remove-k-digits/solution/yi-diao-kwei-shu-zi-by-leetcode-solution/
class Solution {
    public String removeKdigits(String num, int k) {
        // 使用双端队列代替栈的实现
        Deque<Character> deque = new LinkedList<Character>();
        // 数字原始长度
        int length = num.length();
        // 
        for (int i = 0; i < length; ++i) {
            // 当前数字
            char digit = num.charAt(i);
            // 队尾数字比当前数字更大的话就把队尾数字拿出来
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            // 当前数字比队尾数字更大的话，就直接插入队尾
            deque.offerLast(digit);
        }
        
        // 
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
