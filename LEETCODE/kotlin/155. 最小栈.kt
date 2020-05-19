class MinStack() {
    /** initialize your data structure here. */
    // 原始栈
    var stack = Stack<Int>()
    // 最小栈
    var minStack = Stack<Int>()
    // 栈中的最小值
    var minValue = Int.MAX_VALUE
    fun push(x: Int) {
        // 在整个过程中，栈可能会经历【空->非空->空】的过程
        // 所以在push之前要判断一下，如果栈为空，重新初始化最小值。
        if(stack.empty()) minValue = Int.MAX_VALUE
        // 更新最小值
        if(x<minValue) minValue = x
        // 每次都把最小值推入最小栈
        minStack.push(minValue)
        // 每个x都推入原始栈
        stack.push(x)
    }
    fun pop() {
        stack.pop()
        minStack.pop()
        // pop可能会导致最小栈变为空，所以这里要进行判空操作。
        if(!minStack.empty())
            minValue = minStack.peek() // 每次pop要注意更新最小值，因为pop出去的值就是栈中的最小值。
    }
    fun top(): Int {
        return stack.peek()
    }
    fun getMin(): Int {
        return minStack.peek()
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */