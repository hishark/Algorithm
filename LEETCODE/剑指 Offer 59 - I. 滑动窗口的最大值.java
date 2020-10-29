class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 判空
        if (nums.length == 0 || k == 0)
            return new int[0];
        
        // 双端队列
        Deque<Integer> deque = new LinkedList<>();
        
        // 结果数组
        // 该数组的长度为滑动窗口的个数
        // 也就是【数组长度 - k + 1】
        int[] res = new int[nums.length - k + 1];
        
        // 开始遍历所有窗口，i 为窗口的左边界，j 为窗口的右边界
        // 形成窗口后的每一轮中，nums[i-1]为被删除元素，nums[j]为要添加的元素
        // 未形成窗口时，nums[j]为要添加的元素
        for (int j=0, i=1-k;j<nums.length;i++,j++) {
            // i>0说明此时已经形成了窗口，且窗口正在右移，需要删除一个元素
            // 如果队首元素等于被删除的元素，那么队首元素直接出队（队首元素是窗口内的最大元素）
            // 这一步是为了保证 deque 里只包含窗口内的元素
            if (i>0 && deque.peekFirst() == nums[i-1]) {
                deque.removeFirst();
            }
            
            // 删除deque内所有小于nums[j]的元素，以保持deque递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            
            // 把要添加的元素加入到队列中
            deque.addLast(nums[j]);
            
            // 如果此时形成了滑动窗口，队首元素即最大值，添加至结果数组
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}