//baoli
class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        for(i in nums.indices){
            var res = nums[i]
            if(res>max){
                max = res
            }
            for(j in i+1 .. nums.size-1){
                if(j==nums.size) break
                res = res * nums[j]
                if(res>max){
                    max = res
                }
            }
        }
        return max
    }
}

//dp
import kotlin.math.min
import kotlin.math.max
class Solution {
    fun maxProduct(nums: IntArray): Int {
        val len = nums.size
        var dpMax = IntArray(len)
        var dpMin = IntArray(len)
        var maxP = nums[0]
        //别忘记初始化
        dpMax[0] = nums[0]
        dpMin[0] = nums[0]

        for(i in 1..len-1){
            dpMax[i] = max(dpMax[i-1]*nums[i], max(nums[i], dpMin[i-1]*nums[i]))
            dpMin[i] = min(dpMax[i-1]*nums[i], min(nums[i], dpMin[i-1]*nums[i]))
            maxP = max(dpMax[i], maxP)
        }

        return maxP
    }
}