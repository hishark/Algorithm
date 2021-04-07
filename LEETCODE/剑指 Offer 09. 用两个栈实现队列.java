/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
class CQueue {
    // 辅助栈
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<Integer>();
        stackOut = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
        stackIn.push(value);
    }
    
    public int deleteHead() {
        // 判空不能忘记
        if(stackIn.empty() && stackOut.empty())
            return -1;
        
        // out栈不为空，就先pop
        // if(!stackOut.empty())
        //     return stackOut.pop();
        // else{
        //     // 先把in栈的全部pop到out栈中
        //     while(!stackIn.empty()){
        //         stackOut.push(stackIn.pop());
        //     }
        //     return stackOut.pop();
        // }

        // 这样写更简洁啊
        if (stackOut.isEmpty()) {
            while(!stackIn.isEmpty())
                stackOut.push(stackIn.pop());
        }
        return stackOut.pop();
    }
}

