class Solution {
    fun xorOperation(n: Int, start: Int): Int {
        var nums = IntArray(n)
        var res = 0
        for (i in 0..n-1) {
            nums[i] = start + 2*i
            res = res xor nums[i]
        }
        return res
    }
}
