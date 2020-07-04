class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int len = 0;
        int maxLen = 0;
        char[] strs = s.toCharArray();
        // 初始化栈，表示最长子串只能从0开始
        stack.push(-1);

        for (int i=0;i<strs.length;i++) {
            if (strs[i] == '(') {
                // 如果当前括号为左括号，直接入栈
                stack.push(i);
            } else {
                // 如果当前括号为右括号
                // 首先将栈顶元素出栈
                stack.pop();

                // 接着判断此时栈是否为空
                if (stack.empty()) {
                    // 如果栈为空，说明刚刚出栈的是右括号
                    // 直接把当前右括号的下标入栈即可
                    stack.push(i);
                } else {
                    // 如果栈不为空，说明刚刚出栈的是左括号
                    // 计算此时子串的长度
                    // 子串长度 = 当前下标 - 栈顶元素（即相匹配的左括号下标）
                    len = i - stack.peek();
                    // 更新最长子串长度
                    maxLen = Math.max(len, maxLen);
                }
            }
        }

        return maxLen;
    }
}
