class Solution {
    fun runningSum(nums: IntArray): IntArray {
        var res = IntArray(nums.size)
        res[0] = nums[0]
        for(i in 1..res.size-1)
            res[i] = res[i-1] + nums[i]
        return res
    }
}