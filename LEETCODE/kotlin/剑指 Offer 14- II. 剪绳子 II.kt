class Solution {
    fun cuttingRope(n: Int): Int {
        var n = n
        // 单独处理
        if (n == 2)
            return 1
        if (n == 3)
            return 2

        // 最大乘积
        var maxProduct: Long = 1

        // 取模
        val mod = 1e9.toInt() + 7

        // n大于4的情况下不停地拆3出来
        while (n > 4) {
            // 拆一个3就乘一下
            maxProduct *= 3
            // 每求出一个新的乘积就取模
            maxProduct %= mod.toLong()
            // 拆了一个3当然要剪去一个3
            n -= 3
        }

        // 退出循环后，剩下的绳子长度只有可能是1，2，3
        // 不管是谁都没有必要拆，越拆越小，直接乘上即可
        return (maxProduct * n % mod).toInt()
    }
}