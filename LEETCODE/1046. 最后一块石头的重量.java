class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue 默认为小顶堆，所以需要重写 Comparator，变成大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((x, y) -> y - x);
        // 把所有石头塞进大顶堆里
        for (int stone : stones) {
            queue.offer(stone);
        }
        // 堆里小于等于1个石头时，停止循环
        while (queue.size() > 1) {
            // 取出堆顶石头，也就是最重的石头
            int stone1 = queue.poll();
            // 取出堆顶石头，也就是次重的石头
            int stone2 = queue.poll();
            // 如果二者不相等，把差值再放回堆里
            // 如果二者相等，都扔出去
            if (stone1 > stone2) {
                queue.offer(stone1 - stone2);
            }
        }
        // 此时判断堆是否为空即可
        return queue.isEmpty() ? 0 : queue.poll();
    }
}