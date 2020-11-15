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
        
        // 删除最大的 k 位数字
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        
        // 开始拼接出最小的数字
        StringBuilder ans = new StringBuilder();
        // 假设存在前导 0 
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            // 队首数字
            char digit = deque.pollFirst();
            // 如果存在前导 0 且当前数字为 0，就删去前导 0 
            if (leadingZero && digit == '0') {
                continue;
            }
            // 更新前导 0 的存在状态
            leadingZero = false;
            // 拼接结果
            ans.append(digit);
        }
        // 如果结果串长度为 0 说明数字删光了
        return ans.length() == 0 ? "0" : ans.toString();
    }
}
