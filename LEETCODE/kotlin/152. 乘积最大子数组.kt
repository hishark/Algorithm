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