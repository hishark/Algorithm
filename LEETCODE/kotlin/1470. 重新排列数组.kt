class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        var res = IntArray(2*n)
        var index = 0
        for (i in 0..n-1) {
            res[index] = nums[i]
            res[index+1] = nums[i+n]
            index += 2
        }
        return res
    }
}