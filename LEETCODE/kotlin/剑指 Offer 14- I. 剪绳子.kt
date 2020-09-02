// ref: lcof
//dp
class Solution {
    fun cuttingRope(n: Int): Int {
        // 边界值
        if (n < 2)
            return 0
        else if (n == 2)
            return 1
        else if (n == 3)
            return 2

        // 状态数组
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 0
        dp[2] = 2
        dp[3] = 3

        // 状态转移方程
        // dp[n]表示把长度为n的绳子剪成若干段之后各段长度乘积的最大值
        // dp[n] = max(dp[j] * dp[n-j]) 其中j的范围为：[1,n-1]
        for (i in 4..n) {
            // 当前绳子长度为i
            // 乘积的最大值↓
            var maxValue = 0

            // j从1开始是因为剪一刀子下去长度最少为1
            // j最大为i因为当前绳子的长度为i
            // 这里的循环条件可以改为j<=i/2，因为i/2之后算出来的就是重复的乘积了，当n特别特别大的时候，只算到i/2可以节省时间
            for (j in 1..i) {
                // 当前乘积
                val product = dp[j] * dp[i - j]
                if (product > maxValue)
                    maxValue = product
            }
            // 把最大值存入dp数组
            dp[i] = maxValue
        }

        // 返回结果
        return dp[n]
    }
}

// 贪心
// 贪心算法
class Solution {
    fun cuttingRope(n: Int): Int {
        // 按照如下策略来剪绳子：
        //  1. 当 n>=5 时 尽可能多地剪长度为3的绳子
        //  2. 当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子
        // 证明该思路的正确性：
        //  1. 首先当 n>=5 时，可以证明 2(n-2)>n 且 3(n-3)>n。
        //     也就是说当绳子剩下的长度大于或者等于5的时候，我们就把它剪成长度为3或者2的绳子段
        //     另外 n>=5 时 3(n-3)>=2(n-2)，所以应该尽可能地多剪长度为3的绳子段
        //  2. 当绳子的长度为4，由于2x2>1x3，所以剪成两段长度为2的绳子比较好

        // 几个边界值
        if (n < 2)
            return 0
        if (n == 2)
            return 1
        if (n == 3)
            return 2

        // 尽可能多地剪去长度为3的绳子段
        // numOf3 是绳子段长度为3的绳子数量
        var numOf3 = n / 3

        // 当绳子最后剩下的程度为4的时候，不能再剪去长度为3的绳子段
        // 此时更好的方法是剪成两段长度为2的绳子，因为2x2 > 3x1
        // 如果n减去所有的3剩下了1，说明有一个3可以和这个1加起来等于4，这个4可以拆成2和2，于是3的数量就减一。
        if (n - 3 * numOf3 == 1)
            numOf3 -= 1

        // numsOf2 是绳子段长度为2的绳子数量
        val numOf2 = (n - numOf3 * 3) / 2

        // 最大乘积
        val maxProduct = Math.pow(3.0, numOf3.toDouble()) * Math.pow(2.0, numOf2.toDouble())

        return maxProduct.toInt()
    }
}