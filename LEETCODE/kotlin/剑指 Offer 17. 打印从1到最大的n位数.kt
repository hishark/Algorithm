class Solution {
    fun printNumbers(n: Int): IntArray {
        var n = n
        var max = 0
        while (n != 0) {
            max = max * 10 + 9
            n--
        }
        val ans = IntArray(max)
        for (i in 1..max) {
            ans[i - 1] = i
        }
        return ans
    }
}
