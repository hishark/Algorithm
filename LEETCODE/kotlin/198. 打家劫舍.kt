import kotlin.math.max
class Solution {
    fun rob(nums: IntArray): Int {
        val len = nums.size

        when (len) {
            0 -> return 0
            1 -> return nums[0]
        }
        
        // 状态数组
        var dp = IntArray(len)

        // 边界值
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        // 状态方程
        for (i in 2..len-1) {
            dp[i] = max(dp[i-1], dp[i-2] + nums[i])
        }

        return dp[len - 1]
    }
}