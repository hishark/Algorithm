//ref: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
class MinStack {
    /**
     * A为主栈，用于存储所有的元素
     * B为辅助栈，用于存储最小数
     */
    Stack<Integer> stackA, stackB;

    /** initialize your data structure here. */
    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }
    
    public void push(int x) {
        stackA.push(x);
        // 如果B为空，或者x比B的栈顶元素小，就把x压入B栈
        if (stackB.empty() || x <= stackB.peek())
            stackB.push(x);
    }
    
    public void pop() {
        // 如果A的栈顶元素和B的栈顶元素（即当前的最小数）一致，那么A和B一起pop
        // 如果不一致，只要pop栈A中的栈顶元素即可，因为最小数此时没有发生改变
        //  注意：这里要用 equals 不能用 == 哦 【？】
        if (stackA.pop().equals(stackB.peek()))
            stackB.pop();
    }
    
    public int top() {
        return stackA.peek();
    }
    
    public int min() {
        return stackB.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */