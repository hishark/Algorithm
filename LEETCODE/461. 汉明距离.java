// 内置函数，没必要
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

// 移位
class Solution {
    public int hammingDistance(int x, int y) {
        // 异或值
        int xor = x ^ y;
        // 汉明距离
        int distance = 0;
        // 如果异或值为0，那么两个数字完全一致，不需要再计算
        while (xor != 0) {
            // 逐位判断异或值的每一位
            // 如果是1，说明原来两个数字的对应二进制位不同
            if (xor % 2 == 1)
                distance += 1;
            // 每判断完一位就右移一位
            xor = xor >> 1;
        }
        // 返回即可
        return distance;
    }
}

// ref：https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/