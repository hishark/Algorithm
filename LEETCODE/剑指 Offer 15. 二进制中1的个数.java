//ref: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/

// 位运算

// 解法1 - 逐位判断
public class Solution {
    public int hammingWeight(int n) {
        /**
         * 根据位运算的定义：
         *  1. 如果n&1=0，那么n二进制的最右位是0
         *  2. 如果n&1=1，那么n二进制的最左位是1
         */

        // n二进制中1的个数
        int num = 0;

        /**
         * 本题中n为无符号数，所以右移时使用无符号右移
         * 无符号右移：不管符号位，右移时往最左边补0即可
         */
        while(n != 0) {
            // 如果n的最右边是1，那么n&1=1，所以1的个数就加一
            // 如果n的最右边是0，那么n&1=0，所以1个个数不变
            num += n & 1;

            // 每次判断完最右位数字就将n右移一位
            n >>>= 1;            
        }

        return num;
    }
}

// 解法2 - n&(n−1) 
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 利用 n&(n−1)
        // n       = 100100100000
        // n-1     = 100100011111
        // n&(n-1) = 100100000000
        // 所以n和n-1的&操作会消去n最右边的1
        // 只要算出n变为0总共做了几次&操作即可求解1的个数
        int num = 0;
        while (n != 0) {
            n = n & (n - 1);
            num++;
        }
        return num;
    }
}