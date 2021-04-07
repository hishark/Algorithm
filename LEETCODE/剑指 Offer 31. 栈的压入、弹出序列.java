class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 题目提示说「pushed 是 popped 的排列」，说明我们不需要考虑两个序列「长度不同」或者「元素不同」的情况
        // 借助一个辅助栈模拟压入和弹出操作
        Stack<Integer> stack = new Stack<>();

        // 工具人i
        int i = 0;

        // 遍历入栈序列
        for (int num: pushed) {
            // 把入栈序列pushed的当前元素放入辅助栈stack
            stack.push(num);
            // 循环判断「stack栈顶元素 == popped序列的当前元素」是否成立
            while(!stack.isEmpty() && stack.peek() == popped[i]) {
                // 如果成立的话，就把该元素弹出辅助栈 stack，这样就完成了一次出入栈模拟操作
                // 发射！
                stack.pop();
                // 每成功模拟一次出入栈操作，才能将 i 自增
                i++;
            }
        }
        // 如果最后辅助栈为空，说明模拟出入栈操作成功。
        // 如果不为空，说明模拟失败。
        return stack.isEmpty();
    }
}
//cnt: 1