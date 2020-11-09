import java.util.Deque;
import java.util.Queue;

class MaxQueue {
    // 维护一个单调递减的双端队列（队头永远是最大值）
    Deque<Integer> deque;
    // 使用一个辅助队列来记录所有被插入的值
    Queue<Integer> queue;

    public MaxQueue() {
        deque = new LinkedList<Integer>();
        queue = new LinkedList<Integer>();
    }
    
    // 求最大值
    public int max_value() {
        // 队列为空，返回 -1
        if (deque.isEmpty())
            return -1;
        // 返回队头元素，即双端队列中的最大值
        return deque.peekFirst();
    }
    
    // 插入
    public void push_back(int value) {
        // 当双端队列不为空，且队尾取出的值比 value 小的时候，不停的让队尾元素出队
        // 由于有辅助队列的存在，所以不用担心丢失这些比 value 小的元素
        while(!deque.isEmpty() && deque.peekLast() < value) 
            deque.pollLast();
        
        // 让双端队列中所有比 value 小的元素出队后，就将 value 插入队尾
        // 由此来保持双端队列的单调递减
        deque.offerLast(value);
        // 使用辅助队列来记录所有被插入的值
        queue.offer(value);
    }
   
    // 删除
    public int pop_front() {
        // 如果队列为空，返回 -1
        if (queue.isEmpty())
            return -1;
        
        // 取出辅助队列的队头元素
        int ans = queue.poll();
        // 如果该元素等于双端队列的最大值，也同时取出双端队列中的队头元素
        // 如果该元素不是双端队列中的最大值，可以不用管它
        // 单调递减的双端队列的存在只是为了便于求解最大值
        if (ans == deque.peekFirst())
            deque.pollFirst();

        // 返回删除的元素
        return ans;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */