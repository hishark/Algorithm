//ref: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 利用 &
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
