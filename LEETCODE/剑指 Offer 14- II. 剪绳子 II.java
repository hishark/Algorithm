// 贪心
// 对 14-I 的改进，以防越界
// 本题涉及大数越界情况下的求余问题
// 如果按照 I 的解法，在计算过程中就会越界，最终结果就会出错
// 但是基本思想还是一致，不停地拆3出来，拆到剩4就不拆了
class Solution {
    public int cuttingRope(int n) {
        // 单独处理
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        // 最大乘积
        long maxProduct = 1;

        // 取模
        int mod = (int)1e9 + 7;

        // n大于4的情况下不停地拆3出来
        while (n > 4) {
            // 拆一个3就乘一下
            maxProduct *= 3;
            // 每求出一个新的乘积就取模
            maxProduct %= mod;
            // 拆了一个3当然要剪去一个3
            n -= 3;
        }
        
        // 退出循环后，剩下的绳子长度只有可能是1，2，3
        // 1，2，3都没有必要拆，越拆越小，直接乘上即可
        // 4的话，拆了也是2*2，还是4，也是直接乘上即可
        return (int)(maxProduct * n % mod);
    }
}