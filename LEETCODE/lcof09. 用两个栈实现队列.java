class CQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public CQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    
    public void appendTail(int value) {
        stackIn.push(value);
    }
    
    public int deleteHead() {
        if(!stackOut.empty()){
            return stackOut.pop();
        } else {
            while(!stackIn.empty())
                stackOut.push(stackIn.pop());
            if(!stackOut.empty())
                return stackOut.pop();
            else
                return -1;
        }


        
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
