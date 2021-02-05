class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        // 数组 A 中数字的总和
        int sumA = Arrays.stream(A).sum();
        // 数组 B 中数字的总和
        int sumB = Arrays.stream(B).sum();
        
        // 对一个可行解(x,y)，他们的差值应该为 delta。（公式推导见 ref）
        int delta = (sumA - sumB) / 2;
        // 为了快速查询 A 中是否存在某个数字，先把数字全部存入哈希表
        // 然后再遍历 B，在哈希表中查询是否有差值为 delta 的数字
        Set<Integer> set = new HashSet<Integer>();

        // 遍历 A，存入哈希表
        // set 会自动去重
        for (int num : A) {
            set.add(num);
        }

        // 一个可行解
        int[] ans = new int[2];

        // 遍历 B 中的数字 y，查找哈希表中是否存在一个数字 x 与 y 差值为 delta
        for (int y : B) {
            // 先将 y 加上差值 delta，假设一个 x
            int x = y + delta;
            // 再判断哈希表里是否存在
            if (set.contains(x)) {
                // 若存在，找到一个可行解，886
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}

// ref：https://leetcode-cn.com/problems/fair-candy-swap/solution/gong-ping-de-tang-guo-jiao-huan-by-leetc-tlam/

