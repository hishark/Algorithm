//贪心
import kotlin.math.max
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.size==0)
            return 0
        var curSum = nums[0]
        var maxSum = nums[0]
        for(i in 1..nums.size-1) {
            curSum = max(nums[i], nums[i] + curSum)
            maxSum = max(maxSum, curSum)
        }
        return maxSum
    }
}
//dp
import kotlin.math.max
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.size==0)
            return 0
        var maxSum = nums[0]
        for(i in 1..nums.size-1) {
            if(nums[i - 1] > 0) 
                nums[i] += nums[i-1]
            maxSum = max(maxSum, nums[i])
        }
        return maxSum
    }
}