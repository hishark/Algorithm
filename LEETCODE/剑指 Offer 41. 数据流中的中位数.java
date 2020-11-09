// ref: https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/you-xian-dui-lie-wu-fei-hua-jian-dan-yi-dong-by-je/
// https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
class MedianFinder {
    // 使用一个小顶堆和一个大顶堆来分别保存较大的一半和较小的一半
    PriorityQueue<Integer> minHeap, maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        // PriorityQueue 默认为小顶堆
        // minHeap 为小顶堆。用于保存较大的一半数字
        minHeap = new PriorityQueue<>();
        // maxHeap 为大顶堆，需要重写 Comparator。用于保存较小的一半数字
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        // 重写 Comparator 完整的写法：
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
    }
    
    public void addNum(int num) {
        // 需要保持两个堆的平衡，最大堆的大小要始终等于最小堆的大小，或者等于最小堆的大小 + 1
        // 首先向最大堆中插入元素
        maxHeap.offer(num);
        // 最大堆中插入完，就从最大堆中取出最大的元素，插入最小堆中
        minHeap.offer(maxHeap.poll());
        // 此时如果两个堆不平衡，就把最小堆的元素放到最大堆里去
        if (minHeap.size() > maxHeap.size()) 
            maxHeap.offer(minHeap.poll());
    }
    
    public double findMedian() {
        // 如果两个堆的大小相等，就取出两个堆的堆顶元素求平均值
        if (maxHeap.size() == minHeap.size()) 
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        // 若两个堆的大小不相等，直接取出最大堆的堆顶元素即可
        return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */